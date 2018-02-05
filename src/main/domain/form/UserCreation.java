package main.domain.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCreation {
	
	// --------------------------------
	
	@NotNull
	@Size(min=3, max=30)
	private String login;
	@NotNull
	@Size(min=3, max=30)
	private String 	password;
	@NotNull
	private String 	email;
	@NotNull
	private Date 	birthDate;
	
	private String 	firstName;
	
	private String 	lastName;

	// --------------------------------
	
	@Override
	public String toString() {
		return "UserCreated [login=" + login + ", password=" + password + ", email=" + email + ", birthDate=" + birthDate + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	// -------------------------------
	
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

}
