package uo.sdi.business.impl.classes;

import java.util.Date;
import java.util.List;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.TripDao;


public class TripsListado {

	private static TripDao dao = Factories.persistence.newTripDao();

	/**
	 * Lista de viajes del usuario en sesión de los que es promotor
	 * @param user
	 * @return
	 */
	public List<Trip> getTripsByPromoterId(User user){
		return dao.findByPromotorId(user.getId());
	}
	
	public List<Trip> getTripsByPromoterIdAfterNow(User user){
		return dao.findByPromoterIdAfterNow(user.getId());
	}
	
	/**
	 * Lista con todos los viajes que hay en la BBDD.
	 * @return
	 * @throws Exception
	 */
	public List<Trip> getAllTrips() throws Exception {
		return  dao.findAll();
	}

	/**
	 * Lista de viajes que se puede ver sin iniciar sesión en la aplicación.
	 * @return
	 */
	public List<Trip> getTripsByActualDateOpenStatus() {
		return dao.findByClosingDateOpenStatus(new Date());
	}
	
	/**
	 * Lista de viajes que están disponibles para el usuario en sesión.
	 * @param id del usuario que está en sesión.
	 * @return
	 */
	public List<Trip> getTripsByActualDateOpenStatusWithFilter(Long id) {
		return dao.findByClosingDateOpenStatusWithFilter(new Date(),id);
	}
	
	/**
	 * Lista de viajes pendientes del usuario en sesión que no han sido
	 * confirmados.
	 * @param user
	 */
	public List<Trip> getUserPendingTrips(User user){
		return dao.findByUserIdPendingTrips(user.getId());
	}
	
	/**
	 * Lista de viajes en los que el usuario en sesión ha sido aceptado.
	 * @param user
	 */
	public List<Trip> getUserPendingTripsAccepted(User user){
		return dao.findByUserIdAndStatusOpenOrCloseAccepted(user.getId());
	}
	
	/**
	 * Lista de viajes en los que el usuario en sesión ha sido excluido.
	 * @param user
	 */
	public List<Trip> getUserPendingTripsExcluded(User user){
		return dao.findByUserIdAndStatusOpenOrCloseExcluded(user.getId());
	}
	
	/**
	 * Lista de viajes en los que el usuario en sesión está apuntado
	 * pero ya no quedan plazas
	 * @param user
	 */
	public List<Trip> getUserPendingTripsWithoutAvailablePax(User user){
		return dao.findByUserIdAndStatusOpenWithoutAvailablePax(user.getId());
	}
	
	/**
	 * Lista de viajes que tiene el usuario que se pasa como parámetro
	 * en los que ha sido admitido pero el viaje ha sido cancelado por el 
	 * promotor
	 * @param user
	 * @return
	 */
	public List<Trip> getUserPendingTripsWithStatusCancelledAccepted(User user){
		return dao.findByUserIdAndStatusCancelledAccepted(user.getId());
	}
}
