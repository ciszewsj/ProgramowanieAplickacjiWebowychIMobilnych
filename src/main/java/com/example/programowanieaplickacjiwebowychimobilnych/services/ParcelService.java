package com.example.programowanieaplickacjiwebowychimobilnych.services;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Address;
import com.example.programowanieaplickacjiwebowychimobilnych.data.Customer;
import com.example.programowanieaplickacjiwebowychimobilnych.data.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.data.Recipient;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.ParcelRepository;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.ParcelUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ParcelService implements ParcelUseCase {
	private final ParcelRepository parcelRepository;

	@Override
	public Parcel createParcel(Parcel parcel, Address address, Recipient recipient, Customer sender) {
		return null;
	}

	@Override
	public void updateParcel(Parcel parcel, Long userId) {

	}

	@Override
	public void changeParcelAddress(Long parcelId, Address address) {

	}

	@Override
	public Parcel getParcel(Long parcelId, Long userId) {
		return null;
	}

	@Override
	public Page<Parcel> getParcels(Long userId) {
		return null;
	}
}
