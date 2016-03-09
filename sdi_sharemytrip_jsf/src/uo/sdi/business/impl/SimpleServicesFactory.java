package uo.sdi.business.impl;

import uo.sdi.business.ServicesFactory;
import uo.sdi.business.TripsService;

/**
 * Factoría para encapsular todas las los service de la capa de negocio.
 * @author Daniel Mera López
 */
public class SimpleServicesFactory implements ServicesFactory{

	@Override
	public TripsService createTripsService() {
		return new SimpleTripServices();
	}
}
