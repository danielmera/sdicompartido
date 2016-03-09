package uo.sdi.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import uo.sdi.business.TripsService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Trip;

@ManagedBean
@SessionScoped
public class BeanTrips implements Serializable {

	private static final long serialVersionUID = 55L;

	private Trip trip = new Trip();

	private Trip[] trips = null;

	public BeanTrips() {
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

	public String listado() {
		TripsService service;
		try {
			service = Factories.services.createTripsService();
			// De esta forma le damos información a toArray para poder
			// hacer el casting a Alumno[]
			trips = (Trip[]) service.getTrips().toArray(new Trip[0]);
			return "exito";
		} catch (Exception e) {
			e.printStackTrace();
			return "error"; 
		}
	}
}
