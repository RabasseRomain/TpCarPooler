package main.domain.form;

import javax.validation.constraints.NotNull;

public class RideBooking {
	
    @NotNull
    private String login;
    @NotNull
    private long RideId;
    @NotNull
    private int seatsBooked;
    
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public long getRideId() {
		return RideId;
	}
	public void setRideId(long rideId) {
		RideId = rideId;
	}
	public int getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
    
    
}
