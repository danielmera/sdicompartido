package uo.sdi.business.impl;

import uo.sdi.business.UserService;
import uo.sdi.business.exception.EntityAlreadyExistsException;
import uo.sdi.business.exception.EntityNotFoundException;
import uo.sdi.business.impl.classes.AltaUsuario;
import uo.sdi.business.impl.classes.UpdateUser;
import uo.sdi.business.impl.classes.UsuariosBuscar;
import uo.sdi.model.User;

public class SimpleUserService implements UserService{

	@Override
	public User findById(Long id) throws EntityNotFoundException {
		return new UsuariosBuscar().findById(id);
	}

	@Override
	public void saveUser(User usuario) throws EntityAlreadyExistsException {
		new AltaUsuario();
	}

	@Override
	public void updateUser(User usuario) throws EntityNotFoundException {
		new UpdateUser();
	}

}
