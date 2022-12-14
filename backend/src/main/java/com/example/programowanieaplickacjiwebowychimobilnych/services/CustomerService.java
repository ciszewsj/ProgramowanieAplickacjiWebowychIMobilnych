package com.example.programowanieaplickacjiwebowychimobilnych.services;

import com.example.programowanieaplickacjiwebowychimobilnych.config.JwtTokenUtil;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Address;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Customer;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Role;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.LoginRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.RegisterRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.data.response.LoginResponse;
import com.example.programowanieaplickacjiwebowychimobilnych.exception.ParametrizedException;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.AddressRepository;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.CustomerRepository;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.RolesRepository;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

import static com.example.programowanieaplickacjiwebowychimobilnych.config.ApplicationRoles.ROLE_User;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CustomerService implements CustomerUseCase {
	private final CustomerRepository customerRepository;
	private final AddressRepository addressRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenUtil jwtTokenUtil;
	private final RolesRepository rolesRepository;

	@Override
	public LoginResponse loginCustomer(@Validated LoginRequest request) throws Exception {
		authenticate(request.getUsername(), request.getPassword());
		UserDetails userDetails = customerRepository.findByName(request.getUsername()).orElseThrow(new ParametrizedException(HttpStatus.CONFLICT, "USER NOT FOUND", ""));
		String token = jwtTokenUtil.generateToken(userDetails);
		return new LoginResponse(token, "");
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@Override
	public void createCustomer(RegisterRequest request) {
		Role role = rolesRepository.findFirstByRole(ROLE_User);
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setEmail(request.getEmail());
		customer.getRoles().add(role);
		customer.setPassword(passwordEncoder.encode(request.getPassword()));
		customerRepository.save(customer);

	}
}
