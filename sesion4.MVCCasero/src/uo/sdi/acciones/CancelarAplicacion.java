package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.SeatDao;

public class CancelarAplicacion implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		Long id = new Long( request.getParameter("id"));
		Long trip_id = new Long( request.getParameter("trip_id"));
		SeatDao dao = PersistenceFactory.newSeatDao();
		Seat seat = new Seat(id, trip_id,"Aún no tiene comentarios.",SeatStatus.EXCLUDED);
		dao.save(seat);
		return resultado;
	}

}
