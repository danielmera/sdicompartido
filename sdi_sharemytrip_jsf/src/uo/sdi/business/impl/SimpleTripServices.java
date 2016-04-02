package uo.sdi.business.impl;

import java.util.ArrayList;
import java.util.List;

import uo.sdi.business.TripsService;
import uo.sdi.business.impl.classes.TripsListado;
import uo.sdi.business.impl.classes.UpdateTrip;
import uo.sdi.model.Trip;
import uo.sdi.model.TripAndRelation;
import uo.sdi.model.User;
import alb.util.log.Log;

public class SimpleTripServices implements TripsService {

	/**
	 * Devuelve una lista con todos los viajes que hay en la BD
	 */
	@Override
	public List<Trip> getTrips() throws Exception {
		return new TripsListado().getAllTrips();
	}

	/**
	 * Devuelve una lista con los viajes posteriores a la fecha en la que se manda
	 * la petición de este acción.
	 */
	@Override
	public List<Trip> getTripsAfterNow() {
		return new TripsListado().getTripsByActualDateOpenStatus();
	}
	
	/**
	 * Devuelve una lista con los viajes disponibles posteriores a la fecha en la que se manda
	 * la petición de esta acción
	 */
	@Override
	public List<Trip> getTripsAfterNowByUserId(Long id){
		return new TripsListado().getTripsByActualDateOpenStatusWithFilter(id);
	}

	/**
	 * Devuelve una lista de mapas con una lista de viajes y la relación
	 * que tiene con el usuario (ADMITIDO,EXCLUIDO,SIN PLAZAS,...) dentro de
	 * cada mapa.
	 */
	@Override
	public List<TripAndRelation> getViajesUsuario(User user) {
		List<Trip> viajesPendientesConfirmadosAdmitidos;
		List<Trip> viajesPendientesConfirmadosExcluidos;
		List<Trip> viajesPendientesSinPlazas;
		List<Trip> viajesPendientesSinConfirmar;
		List<Trip> viajesComoPromotor;
		// List<Trip> viajesHechosPromotor;
		// List<Trip> viajesHechos;

		List<TripAndRelation> viajesUsuario = new ArrayList<TripAndRelation>();

		TripsListado tl = new TripsListado();
		try {
			viajesPendientesSinConfirmar = tl.getUserPendingTrips(user);
			Log.debug(
					"Obtenida lista de viajes pendientes por confirmar conteniendo [%d] viajes",
					viajesPendientesSinConfirmar.size());
			crearMapaAuxiliar(viajesUsuario, viajesPendientesSinConfirmar,
					"PENDIENTE DE CONFIRMACIÓN");
			viajesPendientesConfirmadosAdmitidos = tl
					.getUserPendingTripsAccepted(user);
			Log.debug(
					"Obtenida lista de viajes pendientes confirmados admitidos conteniendo [%d] viajes",
					viajesPendientesConfirmadosAdmitidos.size());
			crearMapaAuxiliar(viajesUsuario,viajesPendientesConfirmadosAdmitidos,"ADMITIDO");
			viajesPendientesConfirmadosExcluidos = tl
					.getUserPendingTripsExcluded(user);
			Log.debug(
					"Obtenida lista de viajes pendientes confirmados excluidos conteniendo [%d] viajes",
					viajesPendientesConfirmadosExcluidos.size());
			crearMapaAuxiliar(viajesUsuario,viajesPendientesConfirmadosExcluidos,"EXCLUIDO");
			viajesPendientesSinPlazas = tl
					.getUserPendingTripsWithoutAvailablePax(user);
			Log.debug(
					"Obtenida lista de viajes pendientes sin plazas conteniendo [%d] viajes",
					viajesPendientesSinPlazas.size());
			crearMapaAuxiliar(viajesUsuario,viajesPendientesSinPlazas,"SIN PLAZAS");
			viajesComoPromotor = tl.getTripsByPromoterIdAfterNow(user);
			Log.debug(
					"Obtenida lista de viajes como promotor conteniendo [%d] viajes",
					viajesComoPromotor.size());
			crearMapaAuxiliar(viajesUsuario,viajesComoPromotor,"PROMOTOR");
			return viajesUsuario;
		} catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo la lista de viajes");
			return null;
		}
	}

	@Override
	public int updateTrip(Trip trip){
		return new UpdateTrip().update(trip);
	}

	/**
	 * Método auxiliar para crear mapas auxiliares para establecer la relación
	 * que tiene la lista de viajes obtenida con el usuario en sesión (Esto es 
	 * necesario en la vista principal.xhtml).
	 * @param auxViajes
	 * @param viajes
	 * @param mensaje
	 */
	private void crearMapaAuxiliar(List<TripAndRelation> auxViajes,
			List<Trip> viajes, String mensaje) {
		for(Trip t:viajes){
			auxViajes.add(new TripAndRelation(t,mensaje));
		}
	}
}
