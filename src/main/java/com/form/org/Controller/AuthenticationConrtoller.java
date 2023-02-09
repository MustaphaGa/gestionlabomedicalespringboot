package com.form.org.Controller;

import static com.form.org.utils.Constants.AUTHENTICATION_ENDPOINT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.form.org.Services.auth.ApplicationUserDetailsService;
import com.form.org.dto.auth.AuthenticationReponse;
import com.form.org.dto.auth.AuthenticationRequest;
import com.form.org.model.auth.ExtendedUser;
import com.form.org.utils.JwtUtil;

@RestController
@RequestMapping(AUTHENTICATION_ENDPOINT)
public class AuthenticationConrtoller {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private ApplicationUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
   
  	 
      @PostMapping("/authenticate")
	 public ResponseEntity<AuthenticationReponse> authenticate(@RequestBody AuthenticationRequest request){    
    	 authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
				request.getLogin(),
				request.getPassword())
				);
	    			
		final UserDetails userDetails=  userDetailsService.loadUserByUsername(request.getLogin());
		
		final String jwt= jwtUtil.generateToken((ExtendedUser) userDetails); 
		
  		return ResponseEntity.ok(AuthenticationReponse.builder().accessToken(jwt).build()); 

    		
   
	}
}
