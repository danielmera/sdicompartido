package uo.sdi.model;

import java.io.Serializable;

/**
 * Clase auxiliar utilizada a la hora de mostrar los viajes del usuario
 * junto con la relación que mantienen con el usuario.
 * @author Daniel
 */
public class TripAndRelation implements Serializable{

	private static final long serialVersionUID = 555L;

	private Trip trip;
	
	private String relacion;
	
	public TripAndRelation(){		
	}
	
	public TripAndRelation(Trip trip,String relacion){
		this.trip = trip;
		this.relacion = relacion;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	
}
