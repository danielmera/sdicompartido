package uo.sdi.business.impl.classes;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Seat;
import uo.sdi.persistence.SeatDao;

public class UpdatePlaza {

	public int actualizar(Seat seat){
		SeatDao dao = Factories.persistence.newSeatDao();
		return dao.update(seat);
	}
}
