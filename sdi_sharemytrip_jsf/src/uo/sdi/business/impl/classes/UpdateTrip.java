package uo.sdi.business.impl.classes;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Trip;
import uo.sdi.persistence.TripDao;

public class UpdateTrip {

	public int update(Trip trip){
		TripDao dao =  Factories.persistence.newTripDao();
		return dao.update(trip);
	}
	
}
