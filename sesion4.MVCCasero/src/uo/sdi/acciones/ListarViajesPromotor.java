package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.TripDao;

public class ListarViajesPromotor implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Long user_id = user.getId();
		TripDao dao = PersistenceFactory.newTripDao();
		List<Trip> viajesPromotor;
		
		viajesPromotor = dao.findByPromoterStatusOpenAvailablePax(user_id);
		request.setAttribute("viajesPromotor", viajesPromotor);
		return resultado;
	}

}
