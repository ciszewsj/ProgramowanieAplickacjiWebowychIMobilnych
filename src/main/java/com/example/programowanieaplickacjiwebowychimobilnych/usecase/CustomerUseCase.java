package com.example.programowanieaplickacjiwebowychimobilnych.usecase;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Customer;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.LoginRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.RegisterRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.data.response.LoginResponse;
import org.apache.coyote.Request;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AuthenticationManager;

public interface CustomerUseCase {

	LoginResponse loginCustomer(LoginRequest request) throws Exception;

	void createCustomer(RegisterRequest request);

	void changeCustomerData(Customer customer);

	void deleteCustomer(Customer customer);

	void changePassword(Customer customer);

	Page<Customer> getCustomers();
}
