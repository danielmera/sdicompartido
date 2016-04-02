package uo.sdi.business.impl.classes;

import java.util.List;

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
	
	//Buscar usuario por login
	public User findByLogin(String login){
		UserDao dao = Factories.persistence.newUserDao();
		User usuario =  dao.findByLogin(login);
		return usuario;
	}
	
	/**
	 * Lista de usuarios que van como pasajeros en el viaje que se pasa 
	 * con el parámetro trip_id
	 */
	public List<User> findUsersByTripIdAndUserId(Long trip_id,Long user_id){
		UserDao dao = Factories.persistence.newUserDao();
		return dao.findBySeatTripId(trip_id, user_id);
	}
	
	public List<User> findUsersByTripAndUserIdOnlyAdmited(Long trip_id,Long user_id){
		UserDao dao = Factories.persistence.newUserDao();
		return dao.findUsersAdmitedInTrip(trip_id, user_id);
	}
	
	public List<User> findSolicitantesByTripId(Long trip_id){
		UserDao dao = Factories.persistence.newUserDao();
		return dao.findUsersWithApplicationButWithoutSeat(trip_id);
	}
}
