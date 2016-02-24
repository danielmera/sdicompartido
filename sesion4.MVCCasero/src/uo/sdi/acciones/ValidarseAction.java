package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.TripDao;
import uo.sdi.persistence.UserDao;
import alb.util.log.Log;

public class ValidarseAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String resultado = "EXITO";
		String nombreUsuario = request.getParameter("nombreUsuario");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			UserDao dao = PersistenceFactory.newUserDao();
			User userByLogin = dao.findByLogin(nombreUsuario);
			if (userByLogin != null) {
				if (userByLogin.getPassword().equals(password)) {
					session.setAttribute("user", userByLogin);
					int contador = Integer.parseInt((String) request
							.getServletContext().getAttribute("contador"));
					request.getServletContext().setAttribute("contador",
							String.valueOf(contador + 1));
					Log.info("El usuario [%s] ha iniciado sesión",
							nombreUsuario);
					cargarViajesUsuario(userByLogin, request);
				} else {
					Log.info("La password [%s] no es correcta", password);
					request.setAttribute("message",
							"Password incorrecta, prueba con otra");
					resultado = "FRACASO";
				}
			} else {
				session.invalidate();
				Log.info("El usuario [%s] no está registrado", nombreUsuario);
				request.setAttribute("message",
						"El usuario con el que está intentando acceder no existe");
				resultado = "FRACASO";
			}
		} else if (!nombreUsuario.equals(session.getAttribute("user"))) {
			Log.info(
					"Se ha intentado iniciar sesión como [%s] teniendo la sesión iniciada como [%s]",
					nombreUsuario,
					((User) session.getAttribute("user")).getLogin());
			session.invalidate();
			resultado = "FRACASO";
		}
		return resultado;
	}

	@Override
	public String toString() {
		return getClass().getName();
	}

	private void cargarViajesUsuario(User user, HttpServletRequest request) {
		List<Trip> viajesPendientesConfirmadosAdmitidos;
		List<Trip> viajesPendientesConfirmadosExcluidos;
		List<Trip> viajesHechos;
		List<Trip> viajesPendientesSinConfirmar;
		List<Trip> viajesComoPromotor;
		TripDao dao = PersistenceFactory.newTripDao();
		try {
			viajesPendientesSinConfirmar = dao.findByUserIdPendingTrips(user
					.getId());
			request.setAttribute("listaViajesPendientesSinConfirmar",
					viajesPendientesSinConfirmar);
			Log.debug(
					"Obtenida lista de viajes pendientes por confirmar conteniendo [%d] viajes",
					viajesPendientesSinConfirmar.size());

			viajesPendientesConfirmadosAdmitidos = dao
					.findByUserIdAndStatusOpenOrCloseAccepted(user.getId());
			request.setAttribute("listaViajesPendientesConfirmadosAdmitidos",
					viajesPendientesConfirmadosAdmitidos);
			Log.debug(
					"Obtenida lista de viajes pendientes confirmados admitidos conteniendo [%d] viajes",
					viajesPendientesConfirmadosAdmitidos.size());
			viajesPendientesConfirmadosExcluidos = dao
					.findByUserIdAndStatusOpenOrCloseExcluded(user.getId());
			request.setAttribute("listaViajesPendientesConfirmadosExcluidos",
					viajesPendientesConfirmadosExcluidos);
			Log.debug(
					"Obtenida lista de viajes pendientes confirmados excluidos conteniendo [%d] viajes",
					viajesPendientesConfirmadosExcluidos.size());

			viajesComoPromotor = dao.findByPromotorId(user.getId());
			request.setAttribute("listaViajesPromotor", viajesComoPromotor);
			Log.debug(
					"Obtenida lista de viajes como promotor conteniendo [%d] viajes",
					viajesComoPromotor.size());

			viajesHechos = dao.findByUserIdAndStatusDone(user.getId());
			request.setAttribute("listaViajesHechos", viajesHechos);
			Log.debug(
					"Obtenida lista de viajes hechos conteniendo [%d] viajes",
					viajesHechos.size());
		} catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo lista de viajes");
		}
	}

}
