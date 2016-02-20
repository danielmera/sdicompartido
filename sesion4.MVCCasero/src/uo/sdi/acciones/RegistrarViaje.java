package uo.sdi.acciones;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.AddressPoint;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.model.Waypoint;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.TripDao;
import alb.util.log.Log;

public class RegistrarViaje implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		// Datos Salida
		String calle = request.getParameter("calle");
		String ciudad = request.getParameter("ciudad");
		String provincia = request.getParameter("provincia");
		String pais = request.getParameter("pais");
		String zipcode = request.getParameter("zipcode");
		Double lon = new Double(request.getParameter("longitud"));
		Double lat = new Double(request.getParameter("latitud"));
		Waypoint waypointsalida = new Waypoint(lat, lon);
		AddressPoint salida = new AddressPoint(calle, ciudad, provincia, pais,
				zipcode, waypointsalida);

		// TODO Comprobación de fechas:
		/*
		 * Comprobar que la: fecha de salida es menor que el momento actual.
		 * fecha de salida es menor que la fecha de llegada. fecha limite es
		 * menor que la fecha de salida. No se si existe la posibilidad, o si lo
		 * hace por defecto, de que en el input de la fecha salga desde la fecha
		 * actual o no.
		 */

		String f = request.getParameter("fechasalida");
		String[] dateTime = f.split("T");
		String[] date = dateTime[0].split("-");
		String[] time = dateTime[1].split(":");
		Date fechasalida = new Date(new Integer(date[0]), new Integer(date[1]),
				new Integer(date[2]), new Integer(time[0]),
				new Integer(time[1]));

		// Datos Llegada
		String calledest = request.getParameter("calledest");
		String ciudaddest = request.getParameter("ciudaddest");
		String provinciadest = request.getParameter("provinciadest");
		String paisdest = request.getParameter("paisdest");
		String zipcodedest = request.getParameter("zipcodedest");
		Double londest = new Double(request.getParameter("longituddest"));
		Double latdest = new Double(request.getParameter("latituddest"));
		Waypoint waypointllegada = new Waypoint(latdest, londest);
		AddressPoint llegada = new AddressPoint(calledest, ciudaddest,
				provinciadest, paisdest, zipcodedest, waypointllegada);

		f = request.getParameter("fechallegada");
		dateTime = f.split("T");
		time = dateTime[1].split(":");
		Date fechallegada = new Date(new Integer(date[0]), new Integer(date[1]),
				new Integer(date[2]), new Integer(time[0]),
				new Integer(time[1]));
		
		f = request.getParameter("fechalimite");
		dateTime = f.split("T");
		time = dateTime[1].split(":");
		Date fechalimite = new Date(new Integer(date[0]), new Integer(date[1]),
				new Integer(date[2]), new Integer(time[0]),
				new Integer(time[1]));

		Double coste = new Double(request.getParameter("coste"));
		String comentarios = request.getParameter("comentarios");
		Integer maxpax = new Integer(request.getParameter("maxpax"));

		HttpSession session = request.getSession();
		User usuario = ((User) session.getAttribute("user"));

		Trip trip = new Trip(usuario.getId(), salida, fechasalida, llegada,
				fechallegada, fechalimite, coste, comentarios, maxpax);

		TripDao dao = PersistenceFactory.newTripDao();
		// fecha de salida es menor que el momento actual
		if (fechasalida.compareTo(new Date()) > 0) {
			// fecha de salida es menor que la fecha de llegada
			if (fechasalida.compareTo(fechallegada) < 0) {
				// fecha de salida es menor que la fecha de llegada
				if (fechalimite.compareTo(fechasalida) < 0) {
					dao.save(trip);
					Log.debug("Viaje [%s] creado correctamente", trip.getId());
				}
			} else {
				resultado = "FRACASO";
				Log.info("Error: la fecha de salida ha de ser previa a la fecha"
						+ "de llegada.");
				request.setAttribute("message",
						"la fecha de salida ha de ser previa a la fecha"
								+ "de llegada.");
			}
		} else {
			resultado = "FRACASO";
			Log.info("Error: la fecha de salida ha de ser posterior a la fecha actual");
			request.setAttribute("message",
					"la fecha de salida ha de ser posterior a la fecha actual");
		}

		return resultado;
	}

}
