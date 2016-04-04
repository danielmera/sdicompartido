package uo.sdi.business.impl.classes;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Seat;
import uo.sdi.persistence.SeatDao;

public class BuscarPlaza {

	public Seat findByUserIdAndTripId(Long user_id,Long trip_id){
		SeatDao dao = Factories.persistence.newSeatDao();
		return dao.findByUserAndTrip(user_id, trip_id);
	}
	
}
