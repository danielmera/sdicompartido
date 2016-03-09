package uo.sdi.business.impl.classes;

import uo.sdi.business.exception.EntityNotFoundException;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;
import uo.sdi.persistence.UserDao;

public class UsuariosBuscar {

	//Buscar usuario por Id
	public User findById(Long id) throws EntityNotFoundException{
		UserDao dao = Factories.persistence.newUserDao();
		User usuario = dao.findById(id);
		if(usuario == null)
			throw new EntityNotFoundException("No se ha encontrado el usuario");
		return usuario;
	}
	
}
