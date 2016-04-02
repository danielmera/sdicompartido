package uo.sdi.business;

import java.util.List;

import uo.sdi.business.exception.EntityNotFoundException;
import uo.sdi.business.exception.EntityAlreadyExistsException;
import uo.sdi.model.User;

public interface UserService {

	User findById(Long id) throws EntityNotFoundException;

	User findByLogin(String login);
	
	User verify(String login,String password);
	
	Long saveUser(User usuario) throws EntityAlreadyExistsException;

	void updateUser(User usuario) throws EntityNotFoundException;

	List<User> getPasajerosTripId(Long trip_id, Long user_id);

	List<User> getSolicitantesByTripId(Long trip_id);

	List<User> getPasajerosTripOnlyAdmited(Long trip_id, Long user_id);
}
