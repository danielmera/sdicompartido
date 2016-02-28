package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.Rating;
import uo.sdi.persistence.PersistenceFactory;

public class CargarComentario implements Accion{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		Long id_rating = new Long(request.getParameter("id"));
		Long trip_id = new Long(request.getParameter("trip_id"));
		Rating r = PersistenceFactory.newRatingDao().findById(id_rating);
		request.setAttribute("comment", r);
		request.setAttribute("trip_id", trip_id);
		return resultado;
	}

	
	
}
