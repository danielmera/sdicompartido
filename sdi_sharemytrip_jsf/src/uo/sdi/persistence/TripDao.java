package uo.sdi.persistence;

import java.util.Date;
import java.util.List;

import uo.sdi.model.Trip;
import uo.sdi.persistence.util.GenericDao;

public interface TripDao extends GenericDao<Trip, Long> {

	Trip findByPromoterIdAndArrivalDate(Long id, Date arrivalDate);

	List<Trip> findByClosingDateOpenStatus(Date actualDate);

	List<Trip> findByUserIdAndStatusDone(Long id);

	List<Trip> findByUserIdAndStatusCancelled(Long id);

	List<Trip> findByUserIdPendingTrips(Long id);

	List<Trip> findByPromotorId(Long id);

	List<Trip> findByUserIdAndStatusOpenOrCloseAccepted(Long id);

	List<Trip> findByUserIdAndStatusOpenOrCloseExcluded(Long id);

	List<Trip> findByUserIdAndStatusOpenWithoutAvailablePax(Long id);

	List<Trip> findByClosingDateOpenStatusWithFilter(Date actualDate, Long id);

	List<Trip> findByPromoterStatusOpenAvailablePax(Long id);

	int decreaseAvailablePax(Long trip_id, Integer availablePax);

	int setOtherApplicationsToSinPlaza(Long trip_id);

	List<Trip> findByPromoterIdDone(Long id);

	List<Trip> findByPromoterIdAfterNow(Long id);

	List<Trip> findByUserIdAndStatusCancelledAccepted(Long id);
}
