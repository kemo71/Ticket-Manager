package org.mohammad.ticket.model;

import org.hibernate.validator.constraints.NotEmpty;

public class RegisterModel {
	
	@NotEmpty//you can 
	private String username;
	@NotEmpty
	
	private String password;
	@NotEmpty
	private String passwordConformation;
	@NotEmpty
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConformation() {
		return passwordConformation;
	}
	public void setPasswordConformation(String passwordConformation) {
		this.passwordConformation = passwordConformation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
