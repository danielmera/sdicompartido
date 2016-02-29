package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.Trip;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.TripDao;

public class CargarViaje implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String respuesta = "EXITO";
		Long id = new Long( request.getParameter("id"));
		TripDao dao = PersistenceFactory.newTripDao();
		Trip trip = dao.findById(id);
		request.setAttribute("trip", trip);
		return respuesta;
	}

}
