package com.example.programowanieaplickacjiwebowychimobilnych.usecase;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Customer;
import org.springframework.data.domain.Page;

public interface CustomerUseCase {
	void createCustomer(Customer customer);

	void changeCustomerData(Customer customer);

	void deleteCustomer(Customer customer);

	void changePassword(Customer customer);

	Page<Customer> getCustomers();
}
