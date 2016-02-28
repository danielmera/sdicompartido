package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.model.Rating;
import uo.sdi.persistence.PersistenceFactory;

public class CargarComentarios implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String respuesta = "EXITO";
		Long trip_id = new Long(request.getParameter("trip_id"));
		try {
			List<Rating> ratings = PersistenceFactory.newRatingDao().findByFromTripId(trip_id);
			Log.debug("Lista de ratings con [%d] elementos", ratings.size());
			request.setAttribute("ratings", ratings);
		} catch (Exception e) {
			Log.debug("No se puede obtener la lista de ratings, es posible que "
					+ "no exista conexión con la base de datos");
			request.setAttribute("message", "Se ha producido un error al intentar obtener datos de la BD");
			respuesta = "FRACASO";
		}
		return respuesta;
	}

}
