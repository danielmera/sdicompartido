package uo.sdi.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.Trip;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import alb.util.log.Log;

public class ListarViajesUsuario implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		
		List<Trip> viajesActivos;
		List<Trip> viajesHechos;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		try {
			viajesActivos=PersistenceFactory.newTripDao().findByUserIdAndStatusOpenOrClose(user.getId());
			request.setAttribute("listaViajesActivos", viajesActivos);
			Log.debug("Obtenida lista de viajes activos conteniendo [%d] viajes", viajesActivos.size());
			
			viajesHechos=PersistenceFactory.newTripDao().findByUserIdAndStatusDone(user.getId());
			request.setAttribute("listaViajesHechos", viajesHechos);
			Log.debug("Obtenida lista de viajes hechos conteniendo [%d] viajes", viajesHechos.size());
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo lista de viajes");
		}
		
		return resultado;
	}

}
