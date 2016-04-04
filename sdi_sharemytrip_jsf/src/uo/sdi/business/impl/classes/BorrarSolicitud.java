package uo.sdi.business.impl.classes;

import uo.sdi.infrastructure.Factories;
import uo.sdi.persistence.ApplicationDao;

public class BorrarSolicitud {

	public int eliminarSolicitud(Long user_id,Long trip_id){
		ApplicationDao dao = Factories.persistence.newApplicationDao();
		Long[] ids = {user_id,trip_id};
		return dao.delete(ids);
	}
}
