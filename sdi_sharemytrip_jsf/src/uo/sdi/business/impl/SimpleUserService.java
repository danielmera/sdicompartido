package uo.sdi.business.impl;

import java.util.List;

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
	public Long saveUser(User usuario) throws EntityAlreadyExistsException {
		return new AltaUsuario().save(usuario);
	}

	@Override
	public void updateUser(User usuario) throws EntityNotFoundException {
		new UpdateUser();
	}

	@Override
	public User findByLogin(String login) {
		return new UsuariosBuscar().findByLogin(login);
	}
	
	@Override
	public User verify(String login,String password){
		User user = new UsuariosBuscar().findByLogin(login);
		if(user!=null && user.getPassword().equals(password))
			return user;
		return null;
	}
	
	@Override
	public List<User> getPasajerosTripId(Long trip_id,Long user_id){
		return new UsuariosBuscar().findUsersByTripIdAndUserId(trip_id, user_id);
	}
	
	@Override
	public List<User> getSolicitantesByTripId(Long trip_id){
		return new UsuariosBuscar().findSolicitantesByTripId(trip_id);
	}
	
	@Override
	public List<User> getPasajerosTripOnlyAdmited(Long trip_id,Long user_id){
		return new UsuariosBuscar().findUsersByTripAndUserIdOnlyAdmited(trip_id, user_id);
	}
}
