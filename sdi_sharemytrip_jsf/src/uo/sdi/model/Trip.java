package uo.sdi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is not an entity, it is a DTO with the same fields as a row in the
 * table
 * 
 * @see Data Transfer Object pattern
 * @author alb
 * 
 */
public class Trip implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private AddressPoint departure;
	private AddressPoint destination;
	private Date arrivalDate;
	private Date departureDate;
	private Date closingDate;
	private Integer availablePax = 0;
	private Integer maxPax = 0;
	private Double estimatedCost = 0.0;
	private String comments;
	private TripStatus status;

	private Long promoterId;
	
	public Trip(){}
	
	public Trip(Long promoterId, AddressPoint departure, Date departureDate,
			AddressPoint destination, Date arrivalDate, Date closingDate,
			Double estimatedCost, String comments, Integer maxPax) {
		this.promoterId = promoterId;
		this.departure = departure;
		this.departureDate = departureDate;
		this.destination = destination;
		this.arrivalDate = arrivalDate;
		this.closingDate = closingDate;
		this.estimatedCost = estimatedCost;
		this.comments = comments;
		this.maxPax = maxPax;
		this.availablePax = this.maxPax;
		this.status = TripStatus.OPEN;
	}

	public AddressPoint getDeparture() {
		return departure;
	}

	public void setDeparture(AddressPoint departure) {
		this.departure = departure;
	}

	public TripStatus getStatus() {
		return status;
	}

	public void setStatus(TripStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressPoint getDestination() {
		return destination;
	}

	public void setDestination(AddressPoint destination) {
		this.destination = destination;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Integer getAvailablePax() {
		return availablePax;
	}

	public void setAvailablePax(Integer availablePax) {
		this.availablePax = availablePax;
	}

	public Integer getMaxPax() {
		return maxPax;
	}

	public void setMaxPax(Integer maxPax) {
		this.maxPax = maxPax;
	}

	public Double getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}
	
	//Atributo para guardar la relación que tiene con el viaje el usuario
	private String relacion;
	
	public void setRelacion(String relacion){
		this.relacion = relacion;
	}
	
	public String getRelacion(){
		return this.relacion;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", departure=" + departure + ", destination="
				+ destination + ", arrivalDate=" + arrivalDate
				+ ", departureDate=" + departureDate + ", closingDate="
				+ closingDate + ", availablePax=" + availablePax + ", maxPax="
				+ maxPax + ", estimatedCost=" + estimatedCost + ", comments="
				+ comments + ", status=" + status + ", promoterId="
				+ promoterId + "]";
	}

}
