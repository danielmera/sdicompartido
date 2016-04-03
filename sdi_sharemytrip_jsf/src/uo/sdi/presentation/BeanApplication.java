package uo.sdi.presentation;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import uo.sdi.business.ApplicationService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Trip;
import uo.sdi.model.TripAndRelation;
import uo.sdi.model.User;
import alb.util.log.Log;

@ManagedBean
@SessionScoped
public class BeanApplication implements Serializable {

	private static final long serialVersionUID = 1111L;

	@ManagedProperty(value = "#{viajes}")
	private BeanTrips beantrips;

	private Trip trip;
	
	public BeanApplication() {
	}
	
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@PostConstruct
	public void init() {
		Log.info("BeanApplication - PostConstruct");
		beantrips = (BeanTrips) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get(new String("viajes"));
		// si no existe lo creamos e inicializamos
		if (beantrips == null) {
			Log.info("BeanTrips-No existia");
			beantrips = new BeanTrips();
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("viajes", beantrips);
		}
	}

	@PreDestroy
	public void end() {
		Log.info("BeanApplication - PreDestroy");
	}

	public BeanTrips getBeanTrips() {
		return this.beantrips;
	}

	public void setBeanTrips(BeanTrips beantrips) {
		this.beantrips = beantrips;
	}

	/**
	 * Método para eliminar una solicitud de la base de datos
	 * 
	 * @return
	 */
	public void eliminar(TripAndRelation var) {
		ApplicationService service;
		try {
			service = Factories.services.createApplicationService();
			User user = (User) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get("LOGGEDIN_USER");
			service.removeApplication(user.getId(), var.getTrip().getId());
			Log.debug("Operación eliminar solicitud llevada a cabo con éxito");
			beantrips.cargarViajesUsuario();
			//return "exito";
		} catch (Exception e) {
			Log.error(e.getMessage());
			//return "error";
		}
	}
}
