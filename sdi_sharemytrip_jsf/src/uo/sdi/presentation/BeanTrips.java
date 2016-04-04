package uo.sdi.presentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import uo.sdi.business.ApplicationService;
import uo.sdi.business.TripsService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.AddressPoint;
import uo.sdi.model.Application;
import uo.sdi.model.Trip;
import uo.sdi.model.TripAndRelation;
import uo.sdi.model.TripStatus;
import uo.sdi.model.User;
import uo.sdi.model.Waypoint;
import alb.util.log.Log;

@ManagedBean
@SessionScoped
public class BeanTrips implements Serializable {

	private static final long serialVersionUID = 55L;

	private Trip[] trips = null;

	private TripAndRelation[] tripsWithRelation = null;

	private List<Trip> auxTrips = null;

	private Trip trip = new Trip();

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public BeanTrips() {
		iniciarViaje(null);
	}

	public List<Trip> getAuxTrips() {
		return auxTrips;
	}

	public void setAuxTrips(List<Trip> auxTrips) {
		this.auxTrips = auxTrips;
	}

	public TripAndRelation[] getTripsWithRelation() {
		return tripsWithRelation;
	}

	public void setTripsWithRelation(TripAndRelation[] tripsWithRelation) {
		this.tripsWithRelation = tripsWithRelation;
	}

	public Trip[] getTrips() {
		return trips;
	}

	public void setTrips(Trip[] trips) {
		this.trips = trips;
	}

	public void iniciarViaje(ActionEvent event) {
		trip.setDeparture(new AddressPoint("", "", "", "", "", new Waypoint(
				4343.3, 4343.3)));
		trip.setDestination(new AddressPoint("", "", "", "", "", new Waypoint(
				4343.3, 4343.3)));
		trip.setArrivalDate(new Date());
		trip.setClosingDate(new Date());
		trip.setDepartureDate(new Date());
		trip.setAvailablePax(0);
		trip.setMaxPax(0);
		trip.setEstimatedCost(0.0);
		trip.setComments("");
	}

	public String registroViaje() {
		TripsService service;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			service = Factories.services.createTripsService();
			User user = (User) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get("LOGGEDIN_USER");
			Date now = new Date();
			if (trip.getDepartureDate().compareTo(now) > 0) {
				// fecha de salida es menor que la fecha de llegada
				if (trip.getDepartureDate().compareTo(trip.getArrivalDate()) < 0) {
					// fecha limite es menor que la fecha de salida
					if (trip.getClosingDate()
							.compareTo(trip.getDepartureDate()) <= 0) {
						trip.setPromoterId(user.getId());
						trip.setStatus(TripStatus.OPEN);
						service.saveTrip(trip);
						Log.info("Operación exitosa, registrado el viaje con id [%s]");
						iniciarViaje(null);
						cargarViajesUsuario();
						return "exito";
					} else {
						Log.info("Error: la fecha límite ha de ser previa a la fecha de salida.");
						fc.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"La fecha límite ha de ser previa a la fecha de salida.",
										"La fecha límite ha de ser previa a la fecha de salida."));
						return "fracaso";
					}
				} else {
					Log.info("Error: la fecha de salida ha de ser previa a la fecha "
							+ "de llegada.");
					fc.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"La fecha de salida ha de ser previa a la fecha "
									+ "de llegada.",
							"La fecha de salida ha de ser previa a la fecha "
									+ "de llegada."));
					return "fracaso";
				}
			} else {
				Log.info("Error: la fecha de salida ha de ser posterior a la fecha actual.");
				fc.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"La fecha de salida ha de ser posterior a la fecha actual.",
								"La fecha de salida ha de ser posterior a la fecha actual."));
				return "fracaso";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "error";
		}
	}

	public String editarViaje() {
		TripsService service;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			service = Factories.services.createTripsService();
			Date now = new Date();
			if (trip.getDepartureDate().compareTo(now) > 0) {
				// fecha de salida es menor que la fecha de llegada
				if (trip.getDepartureDate().compareTo(trip.getArrivalDate()) < 0) {
					// fecha limite es menor que la fecha de salida
					if (trip.getClosingDate()
							.compareTo(trip.getDepartureDate()) <= 0) {
						service.updateTrip(trip);
						Log.info("Operación exitosa, editado el viaje seleccionado.");
						iniciarViaje(null);
						cargarViajesUsuario();
						return "exito";
					} else {
						Log.info("Error: la fecha límite ha de ser previa a la fecha de salida.");
						fc.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"La fecha límite ha de ser previa a la fecha de salida.",
										"La fecha límite ha de ser previa a la fecha de salida."));
						return "fracaso";
					}
				} else {
					Log.info("Error: la fecha de salida ha de ser previa a la fecha "
							+ "de llegada.");
					fc.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"La fecha de salida ha de ser previa a la fecha "
									+ "de llegada.",
							"La fecha de salida ha de ser previa a la fecha "
									+ "de llegada."));
					return "fracaso";
				}
			} else {
				Log.info("Error: la fecha de salida ha de ser posterior a la fecha actual.");
				fc.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"La fecha de salida ha de ser posterior a la fecha actual.",
								"La fecha de salida ha de ser posterior a la fecha actual."));
				return "fracaso";
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "error";
		}

	}

	/**
	 * Lista los viajes futuros con estado abierto
	 */
	public String listado() {
		TripsService service;
		try {
			service = Factories.services.createTripsService();
			// trips = (Trip[]) service.getTripsAfterNow().toArray(new Trip[0]);
			auxTrips = service.getTripsAfterNow();
			return "exito";
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "error";
		}
	}

	public String listadoDetalle() {
		TripsService service;
		try {
			service = Factories.services.createTripsService();
			User user = (User) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get("LOGGEDIN_USER");
			trips = (Trip[]) service.getTripsAfterNowByUserId(user.getId())
					.toArray(new Trip[0]);
			return "exito";
		} catch (Exception e) {
			Log.error(e.getMessage());
			return "error";
		}
	}

	/**
	 * Operación de solicitud de plaza para los viajes disponibles para los
	 * usuarios registrado.
	 * 
	 * @param trip
	 *            , viaje en el que se solicita la plaza
	 * @return
	 */
	public String solicitarPlaza(Trip trip) {
		ApplicationService service;
		if (trip.getStatus().equals(TripStatus.OPEN)
				&& trip.getAvailablePax() > 0) {
			try {
				service = Factories.services.createApplicationService();
				User sessionuser = (User) FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap()
						.get("LOGGEDIN_USER");
				Application app = new Application(sessionuser.getId(),
						trip.getId());
				service.saveApplication(app);
				// Se actualiza la lista de viajes para que la vista de los
				// viajes del usuario
				// contenga el viaje con la solicitud de plaza que acaba de
				// hacer y vea que está
				// pendiente de confirmación.
				cargarViajesUsuario();
				Log.info(
						"Operación exitosa, plaza solicitada para el viaje con id [%s]",
						trip.getId().toString());
				return "exito";
			} catch (Exception e) {
				Log.error(e.getMessage());
				Log.debug(
						"Operación fallida, la solicitud de plaza para el viaje con id [%s] no se ha creado",
						trip.getId().toString());
				return "error";
			}
		} else {
			Log.debug("El estado del viaje no es OPEN o el nº de plazas es igual a 0");
			return "error";
		}
	}

	/**
	 * Cargar la lista de viajes del usuario que está en sesión
	 */
	public String cargarViajesUsuario() {
		TripsService service;
		FacesContext fc = FacesContext.getCurrentInstance();
		User user = (User) fc.getExternalContext().getSessionMap()
				.get("LOGGEDIN_USER");
		if (user != null) {
			try {
				service = Factories.services.createTripsService();
				tripsWithRelation = (TripAndRelation[]) service
						.getViajesUsuario(user).toArray(new TripAndRelation[0]);
				return "exito";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		} else
			return "error";
	}

	// Borrar los datos del formulario de registro cuando se cancela la
	// operación
	public void reset() {
		iniciarViaje(null);
		RequestContext.getCurrentInstance().reset("form:panel");
	}

	@SuppressWarnings("deprecation")
	public void precargaDatos() {
		trip.setDeparture(new AddressPoint("CallePrecargada1",
				"CiudadPrecargada1", "ProvinciaPrecargada1", "PaisPrecargado1",
				"01010", new Waypoint(4343.3, 4343.3)));
		trip.setDestination(new AddressPoint("CallePrecargada2",
				"CiudadPrecargada2", "ProvinciaPrecargada2", "PaisPrecargado2",
				"10101", new Waypoint(3434.5, 3434.5)));
		Date closingDate = new Date();
		System.out.println(closingDate);
		closingDate.setHours(closingDate.getHours() + 2);
		System.out.println(closingDate);
		trip.setClosingDate(closingDate);
		Date departureDate = new Date();
		departureDate.setHours(departureDate.getHours() + 3);
		trip.setDepartureDate(departureDate);
		Date arrivalDate = new Date();
		arrivalDate.setHours(arrivalDate.getHours() + 4);
		trip.setArrivalDate(arrivalDate);

		trip.setAvailablePax(4);
		trip.setMaxPax(5);
		trip.setEstimatedCost(55.5);
		trip.setComments("ComentarioPrecargado");
	}

	public String cargarViaje(Trip trip) {
		this.trip = trip;
		return "exito";
	}
}
