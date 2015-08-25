package org.mohammad.ticket.orm;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authorities implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private AuthoritiesUserId authority;
	//TODO map user object // username

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority.getAuthority();
	}

	public Authorities() {
		super();
	}
	public Authorities(AuthoritiesUserId authority) {
		super();
		this.authority = authority;
	}

	public Authorities(String authority, String username) {
		super();
		this.authority = new AuthoritiesUserId(authority, username);
	}

	

}
