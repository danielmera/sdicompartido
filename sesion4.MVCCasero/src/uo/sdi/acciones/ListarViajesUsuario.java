package uo.sdi.acciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		/* Comprobamos que si se ha cargado la lista de los viajes del usuario
		 * en caso de no ser así se cargan los viajes del mismo y se guardan en la sesión
		 * para ahorrar tiempo de procesamiento, y que la comunicación sea más fluida.
		 */
		//if (session.getAttribute("viajesAux") == null) {
			cargarViajesUsuario(user, request);
		//}
		return resultado;
	}

	protected void cargarViajesUsuario(User user, HttpServletRequest request) {
		List<Trip> viajesPendientesConfirmadosAdmitidos;
		List<Trip> viajesPendientesConfirmadosExcluidos;
		List<Trip> viajesPendientesSinPlazas;
		List<Trip> viajesHechos;
		List<Trip> viajesPendientesSinConfirmar;
		List<Trip> viajesComoPromotor;
		List<Map<String, Object>> auxViajes = new ArrayList<Map<String, Object>>();
		TripDao dao = PersistenceFactory.newTripDao();
		try {
			viajesPendientesSinConfirmar = dao.findByUserIdPendingTrips(user
					.getId());
			Log.debug(
					"Obtenida lista de viajes pendientes por confirmar conteniendo [%d] viajes",
					viajesPendientesSinConfirmar.size());
			crearMapaAuxiliar(auxViajes, viajesPendientesSinConfirmar,
					"PENDIENTE DE CONFIRMACIÓN");

			viajesPendientesConfirmadosAdmitidos = dao
					.findByUserIdAndStatusOpenOrCloseAccepted(user.getId());
			Log.debug(
					"Obtenida lista de viajes pendientes confirmados admitidos conteniendo [%d] viajes",
					viajesPendientesConfirmadosAdmitidos.size());
			crearMapaAuxiliar(auxViajes, viajesPendientesConfirmadosAdmitidos,
					"ADMITIDO");

			viajesPendientesConfirmadosExcluidos = dao
					.findByUserIdAndStatusOpenOrCloseExcluded(user.getId());
			Log.debug(
					"Obtenida lista de viajes pendientes confirmados excluidos conteniendo [%d] viajes",
					viajesPendientesConfirmadosExcluidos.size());
			crearMapaAuxiliar(auxViajes, viajesPendientesConfirmadosExcluidos,
					"EXCLUIDO");

			viajesPendientesSinPlazas = dao
					.findByUserIdAndStatusOpenWithoutAvailablePax(user.getId());
			Log.debug(
					"Obtenida lista de viajes pendientes confirmados excluidos conteniendo [%d] viajes",
					viajesPendientesSinPlazas.size());
			crearMapaAuxiliar(auxViajes, viajesPendientesSinPlazas,
					"SIN_PLAZAS");

			viajesComoPromotor = dao.findByPromotorId(user.getId());
			Log.debug(
					"Obtenida lista de viajes como promotor conteniendo [%d] viajes",
					viajesComoPromotor.size());
			crearMapaAuxiliar(auxViajes, viajesComoPromotor, "PROMOTOR");

			/* Guardamos este objeto dentro de sessión para no tener que 
			 * cargar los viajes del usuario cada vez que vayamos a la vista
			 * principal.jsp de cada usuario.
			 */
			request.getSession().setAttribute("viajesAux", auxViajes);

			viajesHechos = dao.findByUserIdAndStatusDone(user.getId());
			request.setAttribute("listaViajesHechos", viajesHechos);
			Log.debug(
					"Obtenida lista de viajes hechos conteniendo [%d] viajes",
					viajesHechos.size());
			
			/*viajesCancelados = dao.findByUserIdAndStatusCancelled(user.getId());
			request.setAttribute("listaViajesCancelados", viajesCancelados);
			Log.debug(
					"Obtenida lista de viajes cancelados conteniendo [%d] viajes",
					viajesCancelados.size());*/
		} catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo la lista de viajes");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void crearMapaAuxiliar(List<Map<String, Object>> auxViajes,
			List<Trip> viajes, String mensaje) {
		Map map = new HashMap<String, Object>();
		map.clear();
		map.put("viajes", viajes);
		map.put("relacion", mensaje);
		auxViajes.add(map);
	}

}
