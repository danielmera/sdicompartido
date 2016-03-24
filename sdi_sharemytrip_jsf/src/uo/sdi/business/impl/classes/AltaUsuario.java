package uo.sdi.business.impl.classes;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;
import uo.sdi.persistence.UserDao;

public class AltaUsuario {

	public Long save(User user){
		UserDao dao =  Factories.persistence.newUserDao();
		return dao.save(user);
	}
	
}
