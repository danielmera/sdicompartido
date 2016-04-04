package uo.sdi.business.impl.classes;

import uo.sdi.business.SeatService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;

public class ConfirmarSolicitud {

	public void excluir(Long trip_id,Long user_id){
		SeatService service = Factories.services.createSeatService();
		service.salvar(new Seat(user_id,trip_id,"",SeatStatus.EXCLUDED));
	}
	
	public void admitir(Long trip_id,Long user_id){
		SeatService service = Factories.services.createSeatService();
		service.salvar(new Seat(user_id,trip_id,"",SeatStatus.ACCEPTED));
	}
	
}
