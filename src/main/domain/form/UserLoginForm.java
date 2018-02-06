package main.domain.form;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import main.domain.data.User;
import main.domain.repository.UserRepository;

@ManagedBean
public class UserLoginForm {
	
	private String login;
	private String password;

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
	
}
