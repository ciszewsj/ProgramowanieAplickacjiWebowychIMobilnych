package com.example.programowanieaplickacjiwebowychimobilnych.usecase;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Address;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Customer;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Recipient;
import org.springframework.data.domain.Page;

public interface ParcelUseCase {

	Parcel createParcel(Parcel parcel, Address address, Recipient recipient, Customer sender);

	void updateParcel(Parcel parcel, Long userId);

	void changeParcelAddress(Long parcelId, Address address);

	Parcel getParcel(Long parcelId, Long userId);

	Page<Parcel> getUserParcels(Long userId);

	Page<Parcel> getParcels();

}
