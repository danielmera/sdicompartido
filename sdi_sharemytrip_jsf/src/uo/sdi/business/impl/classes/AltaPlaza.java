package uo.sdi.business.impl.classes;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Seat;
import uo.sdi.persistence.SeatDao;

public class AltaPlaza {

	public void alta(Seat seat){
		SeatDao dao = Factories.persistence.newSeatDao();
		dao.save(seat);
	}
}
