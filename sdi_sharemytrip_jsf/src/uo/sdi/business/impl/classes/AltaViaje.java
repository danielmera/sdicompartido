package uo.sdi.business.impl.classes;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Trip;
import uo.sdi.persistence.TripDao;

public class AltaViaje {

	public Long save(Trip trip) {
		TripDao dao = Factories.persistence.newTripDao();
		return dao.save(trip);
	}

}
