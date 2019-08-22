package in.yis.mains.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.yis.mains.config.JwtTokenUtil;
import in.yis.mains.model.JwtRequest;
import in.yis.mains.model.JwtResponse;
import in.yis.mains.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService jwtInMemoryUserDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	static String sk;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	//	add for ops users
	@RequestMapping(value = "/authenticates", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationTokens(@RequestBody JwtRequest authenticationRequest) throws Exception {
		System.out.println("step 1");
		System.out.println(passwordEncoder.encode(authenticationRequest.getPassword()));
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		System.out.println("step 5");
		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println("step 8");
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		System.out.println("step 2");
		try {
//			sk = passwordEncoder.encode(password);
			System.out.println("step 3");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			System.out.println("step 4");
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping({ "/hellos" })
	public String hello() {
		return "Hello World from sakib";
	}

}
