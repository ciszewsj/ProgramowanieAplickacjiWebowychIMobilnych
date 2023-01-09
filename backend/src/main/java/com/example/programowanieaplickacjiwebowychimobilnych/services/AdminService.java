package com.example.programowanieaplickacjiwebowychimobilnych.services;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.ParcelStatus;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.ParcelRepository;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.ParcelStatusRepository;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.AdminUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdminService implements AdminUseCase {
	private final ParcelRepository parcelRepository;
	private final ParcelStatusRepository parcelStatusRepository;

	@Override
	public List<Parcel> getParcels() {
		return parcelRepository.findAll();
	}

	@Override
	public Parcel getParcel(Long parcelId) {
		return null;
	}

	@Override
	public void changeParcelStatus(Long parcelId, ParcelStatus.Status parcelStatus) {
		if (parcelStatus != null) {
			Parcel p = parcelRepository.findById(parcelId).orElse(null);
			if (p != null) {
				ParcelStatus parcelStatus1 = new ParcelStatus();
				parcelStatus1.setStatus(parcelStatus);
				parcelStatus1 = parcelStatusRepository.save(parcelStatus1);
				p.getParcelStatus().add(parcelStatus1);
				parcelRepository.save(p);
			}
		}
	}
}
