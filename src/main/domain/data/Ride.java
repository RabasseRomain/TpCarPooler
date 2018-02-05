package main.domain.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ride {
	
	// ----- Parameters -------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	//@JsonIgnore
	@ManyToOne
    private User driver;
	//@JsonIgnore
	@ManyToMany
	private List<User> passengers;
	
    private int maxSeats;
    
    @Temporal(TemporalType.DATE)
    private Date departure;
//    private List<Date> timeStamps;
    
//    private List<String> locations;
 
	// ----- Getters and Setters ----------------
	
	public long getId() {
		return id;
	}
	
	public void setId(long Id) {
		id = Id;
	}
	
	public User getDriver() {
		return driver;
	}
	
	public void setDriver(User driver) {
		this.driver = driver;
	}
	
	public List<User> getPassengers() {
		return passengers;
	}
	
	public void setPassengers(List<User> passengers) {
		this.passengers = passengers;
	}
	
	public int getMaxSeats() {
		return maxSeats;
	}
	
	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

//	public List<String> getLocations() {
//		return locations;
//	}
//	
//	public void setLocations(List<String> locations) {
//		this.locations = locations;
//	}
//	
//	public List<Date> getTimeStamps() {
//		return timeStamps;
//	}
//	
//	public void setTimeStamps(List<Date> timeStamps) {
//		this.timeStamps = timeStamps;
//	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

}
