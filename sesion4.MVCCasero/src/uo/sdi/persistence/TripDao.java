package uo.sdi.persistence;

import java.util.Date;
import java.util.List;

import uo.sdi.model.Trip;
import uo.sdi.persistence.util.GenericDao;

public interface TripDao extends GenericDao<Trip, Long> {

	Trip findByPromoterIdAndArrivalDate(Long id, Date arrivalDate);

	List<Trip> findByClosingDateOpenStatus(Date actualDate);

	List<Trip> findByUserIdAndStatusOpenOrClose(Long id);

	List<Trip> findByUserIdAndStatusDone(Long id);

	
}