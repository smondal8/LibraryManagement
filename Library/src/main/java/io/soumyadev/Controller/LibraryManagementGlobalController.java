package io.soumyadev.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.soumyadev.Model.AuthenticationRequest;
import io.soumyadev.Model.AuthenticationResponse;
import io.soumyadev.Services.MyUserDetailsService;
import io.soumyadev.config.JWTRequestFilter;
import io.soumyadev.config.JWTUtil;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class LibraryManagementGlobalController {
	@Autowired
	private AuthenticationManager authenticationmanager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JWTUtil jwtTokenUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest req,AuthenticationResponse res){
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));			
		} catch (AuthenticationException e) {
			log.error("Username or password is not matching.");
			return new ResponseEntity<String>("Username or password is not matching.", HttpStatus.UNAUTHORIZED);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
