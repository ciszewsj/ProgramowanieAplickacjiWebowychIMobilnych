package com.example.programowanieaplickacjiwebowychimobilnych.usecase;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Customer;
import com.example.programowanieaplickacjiwebowychimobilnych.data.Parcel;

public interface CustomerUseCase {
	Customer addCustomerToParcel(Parcel parcel, Customer customer);
}
