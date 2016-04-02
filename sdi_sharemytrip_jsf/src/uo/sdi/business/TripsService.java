package uo.sdi.business;

import java.util.List;

import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.model.TripAndRelation;

public interface TripsService {

	public List<Trip> getTrips() throws Exception;

	public List<Trip> getTripsAfterNow();
	
	public List<Trip> getTripsAfterNowByUserId(Long id);
	
	public List<TripAndRelation> getViajesUsuario(User user);

	int updateTrip(Trip trip);
}
