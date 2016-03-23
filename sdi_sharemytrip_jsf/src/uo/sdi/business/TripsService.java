package uo.sdi.business;

import java.util.List;

import uo.sdi.model.Trip;

public interface TripsService {

	public List<Trip> getTrips() throws Exception;

	public List<Trip> getTripsAfterNow();
	
}
