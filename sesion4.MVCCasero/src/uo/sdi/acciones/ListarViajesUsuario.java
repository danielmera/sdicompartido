package uo.sdi.acciones;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.TripDao;
import alb.util.log.Log;

public class ListarViajesUsuario implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";

		List<Trip> viajesPendientesConfirmadosAdmitidos;
		List<Trip> viajesPendientesConfirmadosExcluidos;
		List<Trip> viajesHechos;
		List<Trip> viajesPendientesSinConfirmar;
		List<Trip> viajesComoPromotor;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
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
					"Obtenida lista de viajes activos conteniendo [%d] viajes",
					viajesPendientesConfirmadosAdmitidos.size());
			viajesPendientesConfirmadosExcluidos = dao
					.findByUserIdAndStatusOpenOrCloseExcluded(user.getId());
			request.setAttribute("listaViajesPendientesConfirmadosExcluidos",
					viajesPendientesConfirmadosExcluidos);
			Log.debug(
					"Obtenida lista de viajes activos conteniendo [%d] viajes",
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

		return resultado;
	}

}
