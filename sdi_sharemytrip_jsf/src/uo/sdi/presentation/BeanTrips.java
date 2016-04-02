package uo.sdi.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import uo.sdi.business.ApplicationService;
import uo.sdi.business.TripsService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Application;
import uo.sdi.model.Trip;
import uo.sdi.model.TripAndRelation;
import uo.sdi.model.TripStatus;
import uo.sdi.model.User;
import alb.util.log.Log;

@ManagedBean
@SessionScoped
public class BeanTrips implements Serializable {

	private static final long serialVersionUID = 55L;

	private Trip[] trips = null;

	private TripAndRelation[] tripsWithRelation = null;

	private List<Trip> auxTrips = null;
	
	public BeanTrips() {
	}

	public List<Trip> getAuxTrips() {
		return auxTrips;
	}

	public void setAuxTrips(List<Trip> auxTrips) {
		this.auxTrips = auxTrips;
	}



	public TripAndRelation[] getTripsWithRelation() {
		return tripsWithRelation;
	}

	public void setTripsWithRelation(TripAndRelation[] tripsWithRelation) {
		this.tripsWithRelation = tripsWithRelation;
	}

	public Trip[] getTrips() {
		return trips;
	}

	public void setTrips(Trip[] trips) {
		this.trips = trips;
	}

	/**
	 * Lista los viajes futuros con estado abierto
	 */
	public String listado() {
		TripsService service;
		try {
			service = Factories.services.createTripsService();
			//trips = (Trip[]) service.getTripsAfterNow().toArray(new Trip[0]);
			auxTrips = service.getTripsAfterNow();
			return "exito";
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "error";
		}
	}

	public String listadoDetalle() {
		TripsService service;
		try {
			service = Factories.services.createTripsService();
			User user = (User) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get("LOGGEDIN_USER");
			trips = (Trip[]) service.getTripsAfterNowByUserId(user.getId())
					.toArray(new Trip[0]);
			return "exito";
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "error";
		}
	}

	/**
	 * Operación de solicitud de plaza para los viajes disponibles para los
	 * usuarios registrado.
	 * 
	 * @param trip
	 *            , viaje en el que se solicita la plaza
	 * @return
	 */
	public String solicitarPlaza(Trip trip) {
		ApplicationService service;
		if (trip.getStatus().equals(TripStatus.OPEN)
				&& trip.getAvailablePax() > 0) {
			try {
				service = Factories.services.createApplicationService();
				User sessionuser = (User) FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap()
						.get("LOGGEDIN_USER");
				Application app = new Application(sessionuser.getId(),
						trip.getId());
				service.saveApplication(app);
				//Se actualiza la lista de viajes para que la vista de los viajes del usuario
				//contenga el viaje con la solicitud de plaza que acaba de hacer y vea que está
				//pendiente de confirmación.
				cargarViajesUsuario();
				Log.info(
						"Operación exitosa, plaza solicitada para el viaje con id [%s]",
						trip.getId().toString());
				return "exito";
			} catch (Exception e) {
				Log.error(e.getMessage());
				Log.debug(
						"Operación fallida, la solicitud de plaza para el viaje con id [%s] no se ha creado",
						trip.getId().toString());
				return "error";
			}
		} else {
			Log.debug("El estado del viaje no es OPEN o el nº de plazas es igual a 0");
			return "error";
		}
	}

	/**
	 * Cargar la lista de viajes del usuario que está en sesión
	 */
	public String cargarViajesUsuario() {
		TripsService service;
		FacesContext fc = FacesContext.getCurrentInstance();
		User user = (User) fc.getExternalContext().getSessionMap()
				.get("LOGGEDIN_USER");
		if (user != null) {
			try {
				service = Factories.services.createTripsService();
				tripsWithRelation = (TripAndRelation[]) service
						.getViajesUsuario(user).toArray(new TripAndRelation[0]);
				return "exito";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		} else
			return "error";
	}
}
