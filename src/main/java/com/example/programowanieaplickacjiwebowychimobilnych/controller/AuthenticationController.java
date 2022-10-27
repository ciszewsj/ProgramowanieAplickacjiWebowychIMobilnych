package com.example.programowanieaplickacjiwebowychimobilnych.controller;

import com.example.programowanieaplickacjiwebowychimobilnych.config.JwtTokenUtil;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.JwtRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.data.response.JwtResponse;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenUtil jwtTokenUtil;
	//	private final UserDetailsService jwtInMemoryUserDetailsService;
	private final CustomerRepository customerRepository;
	private final PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {
		log.warn(passwordEncoder.encode(authenticationRequest.getPassword()));
		log.error("YES, {} - {}", authenticationRequest.getUsername(), authenticationRequest.getPassword());
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = customerRepository.findByName(authenticationRequest.getUsername()).orElse(null);
//				.loadUserByUsername(authenticationRequest.getUsername());

		log.error("HERE: {}",
				userDetails.getPassword());
		final String token = jwtTokenUtil.generateToken(userDetails);
		log.error("HERE?");
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			log.error(password);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			log.warn(e.toString());
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			log.warn(e.toString());
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@RequestMapping("/register")
	public String registerCustomer() {
		return "";
	}
}
