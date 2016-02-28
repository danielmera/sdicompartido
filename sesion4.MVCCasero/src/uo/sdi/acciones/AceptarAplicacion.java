package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.model.Trip;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.SeatDao;
import uo.sdi.persistence.TripDao;

public class AceptarAplicacion implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		Long id = new Long( request.getParameter("id"));
		Long trip_id = new Long( request.getParameter("trip_id"));
		SeatDao dao = PersistenceFactory.newSeatDao();
		Seat seat = new Seat(id, trip_id,"Aún no tiene comentarios.",SeatStatus.ACCEPTED);
		dao.save(seat);
		TripDao tdao = PersistenceFactory.newTripDao();
		Trip trip = tdao.findById(trip_id);
		trip.setAvailablePax(trip.getAvailablePax()-1);
		tdao.update(trip);
//		if(!(trip.getAvailablePax()>0))
//			tdao.setOtherApplicationsToSinPlaza(trip_id);
		return resultado;
	}

}
