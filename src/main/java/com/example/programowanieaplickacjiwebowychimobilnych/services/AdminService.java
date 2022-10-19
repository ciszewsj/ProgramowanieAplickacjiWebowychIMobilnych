package com.example.programowanieaplickacjiwebowychimobilnych.services;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.data.ParcelStatus;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.AdminUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdminService implements AdminUseCase {
	@Override
	public Page<Parcel> getParcels() {
		return null;
	}

	@Override
	public void changeParcelStatus(Long parcelId, ParcelStatus parcelStatus, Long userId) {

	}
}
