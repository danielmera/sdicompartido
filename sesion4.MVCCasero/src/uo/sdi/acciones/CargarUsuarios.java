package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;
import alb.util.log.Log;

public class CargarUsuarios implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		Long trip_id;
		if (request.getParameter("id") == null)
			trip_id = new Long((String) request.getAttribute("id"));
		else {
			trip_id = new Long(request.getParameter("id"));
		}
		UserDao dao = PersistenceFactory.newUserDao();
		try {
			User promotor = dao.findPromoterByTripId(trip_id);
			User sessionuser = (User) request.getSession().getAttribute("user");
			List<User> pasajeros = dao.findBySeatTripId(trip_id,
					sessionuser.getId());
			Log.debug(
					"Se han encontrado [%d] pasajeros para el viaje con id [%s]",
					pasajeros.size(), trip_id.toString());
			request.setAttribute("promotor", promotor);
			request.setAttribute("pasajeros", pasajeros);
			request.setAttribute("trip_id",trip_id);
		} catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo los pasajeros o el promotor del viaje");
			request.setAttribute("message",
					"Se ha producido un error relacionado con la BD");
			resultado = "FRACASO";
		}
		return resultado;
	}

}
