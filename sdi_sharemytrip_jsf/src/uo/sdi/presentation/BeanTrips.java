package uo.sdi.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import uo.sdi.business.TripsService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Trip;
import uo.sdi.model.TripAndRelation;
import uo.sdi.model.User;

@ManagedBean
@SessionScoped
public class BeanTrips implements Serializable {

	private static final long serialVersionUID = 55L;

	private Trip trip = new Trip();

	private Trip[] trips = null;

	private TripAndRelation[] tripsWithRelation = null;

	public BeanTrips() {
	}

	public TripAndRelation[] getTripsWithRelation() {
		return tripsWithRelation;
	}

	public void setTripsWithRelation(TripAndRelation[] tripsWithRelation) {
		this.tripsWithRelation = tripsWithRelation;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
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
			trips = (Trip[]) service.getTripsAfterNow().toArray(new Trip[0]);
			return "exito";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 
	 */
	public String cargarViajesUsuario() {
		TripsService service;
		FacesContext fc = FacesContext.getCurrentInstance();
		User user = (User) fc.getExternalContext().getSessionMap()
				.get("LOGGEDIN_USER");
		if (user != null) {
			try {
				service = Factories.services.createTripsService();
				trips = (Trip[]) service.getTripsAfterNow()
						.toArray(new Trip[0]);
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
