package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.Application;
import uo.sdi.persistence.ApplicationDao;
import uo.sdi.persistence.PersistenceFactory;

public class MostrarAplicaciones implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		Long id = new Long(request.getParameter("id"));
		ApplicationDao dao = PersistenceFactory.newApplicationDao();
		List<Application> applicationsTrip = dao.findByTripIdNoSeat(id);
		request.setAttribute("applicationsTrip", applicationsTrip);
		return resultado;
	}

}
