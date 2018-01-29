package data;

import java.util.Date;
import java.util.List;

public class Ride {
	
	// ----- Parameters -------------------------
	
	private int ID;
    private int maxSeats;
    private int bookedSeats;
    private List<String> locations;
    private List<Date> timeStamps;
    private List<String> caracteristics;
	
	// ----- Getters and Setters ----------------
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public List<String> getLocations() {
		return locations;
	}
	
	public void setLocations(List<String> locations) {
		this.locations = locations;
	}
	
	public List<Date> getTimeStamps() {
		return timeStamps;
	}
	
	public void setDates(List<Date> timeStamps) {
		this.timeStamps = timeStamps;
	}
	
	public int getMaxSeats() {
		return maxSeats;
	}
	
	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}
	
	public int getBookedSeats() {
		return bookedSeats;
	}
	
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	
	public List<String> getCaracteristics() {
		return caracteristics;
	}
	
	public void setCaracteristics(List<String> caracteristics) {
		this.caracteristics = caracteristics;
	}

}
