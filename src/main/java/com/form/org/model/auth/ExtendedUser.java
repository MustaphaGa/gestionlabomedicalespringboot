package com.form.org.model.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class ExtendedUser extends User{
	
	private static final long serialVersionUID = 1L;

	public ExtendedUser(String email, String password,
		      Collection<? extends GrantedAuthority> authorities) {
		    super(email, password, authorities);
		  }

		 
}
