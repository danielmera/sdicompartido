package uo.sdi.business;

import uo.sdi.model.Application;

public interface ApplicationService {

	Long[] saveApplication(Application app);

	int removeApplication(Long user_id, Long trip_id);
	
}
