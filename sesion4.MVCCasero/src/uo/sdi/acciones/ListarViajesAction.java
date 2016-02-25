package uo.sdi.acciones;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.User;
import uo.sdi.model.Trip;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.TripDao;
import alb.util.log.Log;

public class ListarViajesAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Trip> viajes;
		HttpSession session = request.getSession();
		Date fechaActual = new Date();
		try {
			TripDao dao = PersistenceFactory.newTripDao();
			if(session.getAttribute("user")!=null){
				viajes=dao.findByClosingDateOpenStatusWithFilter(fechaActual,((User) session.getAttribute("user")).getId());
			}else
				viajes=dao.findByClosingDateOpenStatus(fechaActual);
			request.setAttribute("listaViajes", viajes);
			Log.debug("Obtenida lista de viajes conteniendo [%d] viajes", viajes.size());
		}
		catch (Exception e) {
			Log.error("Algo ha ocurrido obteniendo lista de viajes.");
		}

		return "EXITO";
	}
	
	@Override
	public String toString() {
		return getClass().getName();
	}
	
}
