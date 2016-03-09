package uo.sdi.business.impl.classes;

import java.util.List;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Trip;
import uo.sdi.persistence.TripDao;


public class TripsListado {

	public List<Trip> getAllTrips() throws Exception {
		TripDao dao = Factories.persistence.newTripDao();
		return  dao.findAll();
	}
	
}
