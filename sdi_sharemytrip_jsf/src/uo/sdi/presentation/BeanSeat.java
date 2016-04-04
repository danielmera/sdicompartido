package uo.sdi.presentation;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import uo.sdi.business.SeatService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import alb.util.log.Log;

@ManagedBean
@RequestScoped
public class BeanSeat implements Serializable {

	private static final long serialVersionUID = 1211L;

	@ManagedProperty(value = "#{sessionuser}")
	private BeanUser beanuser;
	@ManagedProperty(value = "#{viajes}")
	private BeanTrips beantrips;
	
	private Trip trip;

	public BeanSeat() {
	}

	@PostConstruct
	public void init() {
		Log.info("BeanSeat - PostConstruct");
		beanuser = (BeanUser) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get(new String("sessionuser"));
		beantrips = (BeanTrips) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get(new String("viajes"));
		// si no existe lo creamos e inicializamos
		if (beanuser == null) {
			Log.info("BeanUser-No existia");
			beanuser = new BeanUser();
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("sessionuser", beanuser);
		}
		if(beantrips == null) {
			Log.info("BeanTrips-No existia");
			beantrips = new BeanTrips();
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("viajes", beantrips);
		}
	}

	@PreDestroy
	public void end() {
		Log.info("BeanSeat - PreDestroy");
	}
	
	public BeanTrips getBeantrips() {
		return beantrips;
	}

	public void setBeantrips(BeanTrips beantrips) {
		this.beantrips = beantrips;
	}

	public BeanUser getBeanuser() {
		return beanuser;
	}

	public void setBeanuser(BeanUser beanuser) {
		this.beanuser = beanuser;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public String confirmar(User user) {
		SeatService service;
		try {
			service = Factories.services.createSeatService();
			service.admitir(user.getId(), trip.getId());
			Log.debug("Operación de actualización llevada a cabo con éxito");
			trip.setAvailablePax(trip.getAvailablePax() - 1);
			// Actualizamos el nº de plazas disponibles en el viaje
			Factories.services.createTripsService().updateTrip(trip);
			// Actualizamos la lista de solicitantes para ver solo los que no
			// han sido gestionados.
			beanuser.cargarSolicitantes(trip);
			return "exito";
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "fracaso";
		}
	}
	
	public String excluir(User user) {
		SeatService service;
		try {
			service = Factories.services.createSeatService();
			service.excluir(user.getId(), trip.getId());
			Log.debug("Operación de actualización llevada a cabo con éxito");
			// Actualizamos la lista de solicitantes para ver solo los que no
			// han sido gestionados.
			beanuser.cargarSolicitantes(trip);
			return "exito";
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "fracaso";
		}
	}

	public String updateToExcluded(User user) {
		SeatService service;
		try {
			service = Factories.services.createSeatService();
			Seat seat = service.findByUserAndTrip(user.getId(), trip.getId());
			seat.setStatus(SeatStatus.EXCLUDED);
			int filasActualizadas = service.update(seat);
			if (filasActualizadas == 1) {
				Log.debug("Operación de actualización llevada a cabo con éxito");
				trip.setAvailablePax(trip.getAvailablePax() + 1);
				// Actualizamos el nº de plazas disponibles en el viaje
				Factories.services.createTripsService().updateTrip(trip);
				// Actualizamos la lista de solicitantes para ver solo los que
				// no han sido gestionados.
				beanuser.cargarPasajerosAdmitidos(trip);
				return "exito";
			} else {
				Log.debug("No se ha actualizado ningún seat en la BD");
				return "fracaso";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "fracaso";
		}
	}

	public String cancelarPlaza(Trip trip) {
		SeatService service;
		User user = (User) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("LOGGEDIN_USER");
		try {
			service = Factories.services.createSeatService();
			if (service.eliminarPlaza(user.getId(), trip.getId()) == 1
					&& Factories.services.createApplicationService()
							.removeApplication(user.getId(), trip.getId()) == 1) {
				trip.setAvailablePax(trip.getAvailablePax() + 1);
				// Actualizamos el nº de plazas disponibles en el viaje
				Factories.services.createTripsService().updateTrip(trip);
				Log.debug(
						"Cancelación de plaza para el viaje [%s] y usuario [%s]",
						trip.getId().toString(), user.getLogin());
				beantrips.cargarViajesUsuario();
				return "exito";
			} else {
				Log.debug("No se ha completado la operación de cancelación de la plaza");
				return "fracaso";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "fracaso";
		}
	}
}
