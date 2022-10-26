package com.example.programowanieaplickacjiwebowychimobilnych.services;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Customer;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CustomerService implements CustomerUseCase {
	@Override
	public void createCustomer(Customer customer) {

	}

	@Override
	public void changeCustomerData(Customer customer) {

	}

	@Override
	public void deleteCustomer(Customer customer) {

	}

	@Override
	public void changePassword(Customer customer) {

	}

	@Override
	public Page<Customer> getCustomers() {
		return null;
	}
}
