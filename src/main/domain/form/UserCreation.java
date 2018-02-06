package main.domain.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCreation {
	
	// --------------------------------
	
	@NotNull
	@Size(min=3, max=30)
	private String login;
	@NotNull
	@Size(min=3, max=30)
	private String password;
	@NotNull
	private String email;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	// --------------------------------
	
	@Override
	public String toString() {
		return "UserCreated [login=" + login + ", password=" + password + ", email=" + email + ", birthDate=" + birthDate + "]";
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

}
