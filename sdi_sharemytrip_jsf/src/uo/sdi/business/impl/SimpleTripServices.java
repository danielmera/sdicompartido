package uo.sdi.business.impl;

import java.util.List;

import uo.sdi.business.TripsService;
import uo.sdi.business.impl.classes.TripsListado;
import uo.sdi.model.Trip;

public class SimpleTripServices implements TripsService{

	@Override
	public List<Trip> getTrips() throws Exception {
		return new TripsListado().getAllTrips();
	}
	
	@Override
	public List<Trip> getTripsAfterNow(){
		return new TripsListado().getTripsByActualDateOpenStatus();
	}
}
