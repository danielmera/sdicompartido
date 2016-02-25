package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alb.util.log.Log;
import uo.sdi.model.Application;
import uo.sdi.model.Trip;
import uo.sdi.model.TripStatus;
import uo.sdi.model.User;
import uo.sdi.persistence.ApplicationDao;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.TripDao;

public class SolicitarPlaza implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String respuesta = "EXITO";
		String trip_id = request.getParameter("id");
		TripDao tripdao = PersistenceFactory.newTripDao();
		Trip trip = tripdao.findById(new Long(trip_id));
		if (trip.getStatus().equals(TripStatus.OPEN)) {
			if (trip.getAvailablePax() > 0) {
				ApplicationDao dao = PersistenceFactory.newApplicationDao();
				User user = (User) request.getSession().getAttribute("user");
				dao.save(new Application(user.getId(), new Long(trip_id)));
				// Actualizamos el número de plazas del vuelo
				//trip.setAvailablePax(trip.getAvailablePax() - 1);
				//if (trip.getAvailablePax() == 0)
					//trip.setStatus(TripStatus.CLOSED);
				//tripdao.update(trip);
			} else {
				Log.debug("El viaje [%s] no tiene plazas libres",
						(trip_id + ""));
				request.setAttribute("message",
						"Este viaje no dispone de plazas libres");
				respuesta = "FRACASO";
			}
		} else {
			Log.debug(
					"El viaje tiene el estado [%s], por lo que no se puede solicitar plaza"
							+ " (para reservar el estado del viaje tiene que ser OPEN)",
					trip.getStatus());
			request.setAttribute("message",
					"El viaje tiene el estado " + trip.getStatus()
							+ " cuando debería de ser OPEN para poder solicitar una plaza");
			respuesta = "FRACASO";
		}
		return respuesta;
	}

}
