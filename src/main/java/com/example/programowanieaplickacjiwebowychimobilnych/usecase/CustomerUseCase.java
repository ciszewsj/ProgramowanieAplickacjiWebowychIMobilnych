package com.example.programowanieaplickacjiwebowychimobilnych.usecase;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Customer;

public interface CustomerUseCase {
	void createCustomer(Customer customer);

	void changeCustomerData(Customer customer);

	void deleteCustomer(Customer customer);

	void changePassword(Customer customer);

	void getCustomers();
}
