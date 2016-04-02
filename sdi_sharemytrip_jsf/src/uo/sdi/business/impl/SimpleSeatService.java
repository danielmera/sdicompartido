package uo.sdi.business.impl;

import uo.sdi.business.SeatService;
import uo.sdi.business.impl.classes.AltaPlaza;
import uo.sdi.business.impl.classes.BuscarPlaza;
import uo.sdi.business.impl.classes.UpdatePlaza;
import uo.sdi.model.Seat;

public class SimpleSeatService implements SeatService{

	@Override
	public void salvar(Seat seat) {
		new AltaPlaza().alta(seat);;
	}

	@Override
	public int update(Seat seat) {
		return new UpdatePlaza().actualizar(seat);	
	}
	
	@Override
	public Seat findByUserAndTrip(Long user_id,Long trip_id){
		return new BuscarPlaza().findByUserIdAndTripId(user_id, trip_id);
	}
	
}
