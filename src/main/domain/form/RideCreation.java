package main.domain.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

public class RideCreation {
	
	// --------------------------------
	@NotNull
	private String login;
	@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;  
    @NotNull
    private String departurePlace;
    @NotNull
    private String arrivalPlace;
    @NotNull
    private int maxSeats;
 	
	// --------------------------------
	
    @Override
	public String toString() {
		return "RideCreated [departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", departurePlace="
				+ departurePlace + ", arrivalPlace=" + arrivalPlace + ", maxSeats=" + maxSeats + "]";
	}
	
	// --------------------------------
    
	 public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDeparturePlace() {
		return departurePlace;
	}
	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}
	public String getArrivalPlace() {
		return arrivalPlace;
	}
	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}
	public int getMaxSeats() {
		return maxSeats;
	}
	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}  

}
