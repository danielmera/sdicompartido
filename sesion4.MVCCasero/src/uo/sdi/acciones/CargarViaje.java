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
		String var =  (String) request.getSession().getAttribute("previous");
		request.getSession().removeAttribute("previous");
		Long id = new Long( request.getParameter("id"));
		TripDao dao = PersistenceFactory.newTripDao();
		Trip trip = dao.findById(id);
		request.setAttribute("trip", trip);
		if(var.equals("principal"))
			request.setAttribute("previous", var);
		return respuesta;
	}

}
