package org.mohammad.ticket.orm;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String userPassword;
	private String email;
	private String userStatus;
	private boolean enabled;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="username")
	private List<Authorities> authorities;
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public List<Authorities> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}
	public String getUser_status() {
		return userStatus;
	}
	public void setUser_status(String user_status) {
		this.userStatus = user_status;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_password() {
		return userPassword;
	}
	public void setUser_password(String user_password) {
		this.userPassword = user_password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public Users(String username){
		super();
		this.username = username;
	}
	public Users(){
		super();
	}
	//TODO @Override equals

}
