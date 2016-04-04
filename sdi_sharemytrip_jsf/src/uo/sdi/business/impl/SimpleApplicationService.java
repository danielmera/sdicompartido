package uo.sdi.business.impl;

import uo.sdi.business.ApplicationService;
import uo.sdi.business.impl.classes.AltaSolicitud;
import uo.sdi.business.impl.classes.BorrarSolicitud;
import uo.sdi.model.Application;

public class SimpleApplicationService implements ApplicationService{

	@Override
	public Long[] saveApplication(Application app) {
		return new AltaSolicitud().save(app);
	}
	
	@Override
	public int removeApplication(Long user_id,Long trip_id){
		return new BorrarSolicitud().eliminarSolicitud(user_id, trip_id);
	}
}
