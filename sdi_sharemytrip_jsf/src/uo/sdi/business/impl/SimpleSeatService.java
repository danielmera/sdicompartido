package uo.sdi.business.impl;

import uo.sdi.business.SeatService;
import uo.sdi.business.impl.classes.AltaPlaza;
import uo.sdi.business.impl.classes.BorrarPlaza;
import uo.sdi.business.impl.classes.BuscarPlaza;
import uo.sdi.business.impl.classes.ConfirmarSolicitud;
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
	
	@Override
	public int eliminarPlaza(Long user_id,Long trip_id){
		return new BorrarPlaza().eliminarPlaza(user_id,trip_id);
	}
	
	@Override
	public void admitir(Long user_id,Long trip_id){
		new ConfirmarSolicitud().admitir(trip_id, user_id);
	}
	
	@Override
	public void excluir(Long user_id,Long trip_id){
		new ConfirmarSolicitud().excluir(trip_id, user_id);
	}
	
}
