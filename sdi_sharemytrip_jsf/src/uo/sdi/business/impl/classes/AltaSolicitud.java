package uo.sdi.business.impl.classes;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Application;
import uo.sdi.persistence.ApplicationDao;

public class AltaSolicitud {

	public Long[] save(Application app){
		ApplicationDao dao =  Factories.persistence.newApplicationDao();
		return dao.save(app);
	}
}
