package uo.sdi.business.impl;

import uo.sdi.business.ApplicationService;
import uo.sdi.business.SeatService;
import uo.sdi.business.ServicesFactory;
import uo.sdi.business.TripsService;
import uo.sdi.business.UserService;

/**
 * Factoría para encapsular todas las los service de la capa de negocio.
 * @author Daniel Mera López
 */
public class SimpleServicesFactory implements ServicesFactory{

	@Override
	public TripsService createTripsService() {
		return new SimpleTripServices();
	}

	@Override
	public UserService createUsersService() {
		return new SimpleUserService();
	}

	@Override
	public ApplicationService createApplicationService() {
		return new SimpleApplicationService();
	}

	@Override
	public SeatService createSeatService() {
		return new SimpleSeatService();
	}
	
}
