package org.mohammad.ticket.orm;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AuthoritiesUserId implements Serializable{

	
	private String authority;
	private String username;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AuthoritiesUserId() {
		super();
	}
	public AuthoritiesUserId(String authority, String username) {
		super();
		this.authority = authority;
		this.username = username;
	}
	

}
