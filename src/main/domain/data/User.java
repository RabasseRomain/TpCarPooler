package main.domain.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User {
	
	// ----- Parameters -------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long 	id;
	@NotBlank
	private String 	login;
	@NotBlank
	private String 	password;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date 	birthDate;
	//@JsonIgnore
	@OneToMany(mappedBy = "driver")
	private List<Ride> offeredRides;
	//@JsonIgnore
	@ManyToMany(mappedBy = "passengers")
	private List<Ride> bookedRides;
	
	private String 	firstName;
	private String 	lastName;
	private String 	email;
	
	private int 	rating;
	private boolean confirmed;
	
	// ----- Getters and Setters ----------------
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public boolean isConfirmed() {
		return confirmed;
	}
	
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public List<Ride> getOfferedRides() {
		return offeredRides;
	}
	
	public void setOfferedRides(List<Ride> offeredRides) {
		this.offeredRides = offeredRides;
	}
	
	public List<Ride> getBookedRides() {
		return bookedRides;
	}
	
	public void setBookedRides(List<Ride> bookedRides) {
		this.bookedRides = bookedRides;
	}
//	public List<Vehicule> getVehicules() {
//		return vehicules;
//	}
//	public void setVehicules(List<Vehicule> vehicules) {
//		this.vehicules = vehicules;
//	}
	
}
