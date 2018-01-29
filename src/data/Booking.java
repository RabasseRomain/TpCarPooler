package data;

import java.util.Date;

public class Booking {
	
	// ----- Parameters -------------------------
	
	private int rideID;
    private String userLogin;
    private Date dateBooked;
    private int seatBooked;
    	
	// ----- Getters and Setters ----------------
	
	public int getRideID() {
		return rideID;
	}
	
	public void setRideID(int rideID) {
		this.rideID = rideID;
	}
	
	public String getUserLogin() {
		return userLogin;
	}
	
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	public Date getDateBooked() {
		return dateBooked;
	}
	
	public void setDateBooked(Date dateBooked) {
		this.dateBooked = dateBooked;
	}
	
	public int getSeatBooked() {
		return seatBooked;
	}
	
	public void setSeatBooked(int seatBooked) {
		this.seatBooked = seatBooked;
	}
}
