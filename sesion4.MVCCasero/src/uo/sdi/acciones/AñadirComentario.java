package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.RatingDao;
import uo.sdi.model.User;
import uo.sdi.model.Rating;

public class AñadirComentario implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		Integer value = new Integer(request.getParameter("rating"));
		String comentario = request.getParameter("comentario");
		RatingDao dao = PersistenceFactory.newRatingDao();
		HttpSession sesion = request.getSession();
		Long tripId = (Long) sesion.getAttribute("tripId");
		Long userAbout = (Long) sesion.getAttribute("aboutUserId");
		Long userFrom = ((User) sesion.getAttribute("user")).getId();
		sesion.removeAttribute("aboutUserId");
		sesion.removeAttribute("tripId");
		Rating r = new Rating(tripId, userFrom, tripId, userAbout, comentario,
				value);
		try {
			Long id = dao.save(r);
			Log.debug("Se ha creado el comentario con id [%d]", id);
			request.setAttribute("id", tripId.toString());
		} catch (Exception e) {
			Log.debug("No se ha podido salvar el comentario en la BD, es posible que existan problemas de conexión con la misma");
			request.setAttribute(
					"message",
					"Se han producido problemas relacionados con la BD al tratar de guardar el comentario");
			resultado = "FRACASO";
		}
		return resultado;
	}
}
