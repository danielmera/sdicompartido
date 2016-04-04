package uo.sdi.business.impl.classes;

import uo.sdi.infrastructure.Factories;
import uo.sdi.persistence.SeatDao;

public class BorrarPlaza {

	public int eliminarPlaza(Long user_id,Long trip_id){
		SeatDao dao = Factories.persistence.newSeatDao();
		Long[] ids = {user_id,trip_id};
		return dao.delete(ids);
	}
	
}
