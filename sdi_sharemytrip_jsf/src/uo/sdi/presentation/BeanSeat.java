package uo.sdi.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import uo.sdi.business.SeatService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Seat;
import uo.sdi.model.SeatStatus;
import uo.sdi.model.Trip;
import uo.sdi.model.User;
import alb.util.log.Log;

@ManagedBean
@RequestScoped
public class BeanSeat implements Serializable{

	private static final long serialVersionUID = 1211L;

	public BeanSeat() {
	}

	public String updateToExcluded(User user, Trip trip) {
		SeatService service;
		try {
			service = Factories.services.createSeatService();
			Seat seat = service.findByUserAndTrip(user.getId(), trip.getId());
			seat.setStatus(SeatStatus.EXCLUDED);
			int filasActualizadas = service.update(seat);
			if (filasActualizadas == 1) {
				Log.debug("Operación de actualización llevada a cabo con éxito");
				trip.setAvailablePax(trip.getAvailablePax() + 1);
				// Actualizamos el nº de plazas disponibles en el viaje
				Factories.services.createTripsService().updateTrip(trip);
				return "exito";
			}else{
				Log.debug("No se ha actualizado ningún seat en la BD");
				return "fracaso";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "fracaso";
		}
	}
}
