package uo.sdi.business;

import uo.sdi.model.Seat;

public interface SeatService {
	
	void salvar(Seat seat);
	int update(Seat seat);
	Seat findByUserAndTrip(Long user_id, Long trip_id);
}
