package uo.sdi.business;

import uo.sdi.business.exception.EntityNotFoundException;
import uo.sdi.business.exception.EntityAlreadyExistsException;
import uo.sdi.model.User;

public interface UserService {

	User findById(Long id) throws EntityNotFoundException;

	User findByLogin(String login);
	
	void saveUser(User usuario) throws EntityAlreadyExistsException;

	void updateUser(User usuario) throws EntityNotFoundException;
}
