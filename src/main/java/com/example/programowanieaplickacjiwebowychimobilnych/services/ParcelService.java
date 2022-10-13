package com.example.programowanieaplickacjiwebowychimobilnych.services;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.exception.ParametrizedException;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.ParcelRepository;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.ParcelUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelService implements ParcelUseCase {
	private final ParcelRepository parcelRepository;

	public ParcelService(ParcelRepository parcelRepository) {
		this.parcelRepository = parcelRepository;
	}

	public void createParcel() {
		Parcel parcel = new Parcel();
		parcelRepository.save(parcel);
	}

	public List<Parcel> getParcels() {
		return parcelRepository.findAll();
	}

	@Override
	public Parcel createParcel(Parcel parcel) {
		return null;
	}

	@Override
	public Parcel updateParcel(Parcel parcel) {
		return null;
	}

	@Override
	public Parcel changeParcelStatus(Parcel parcel) {
		return null;
	}

	@Override
	public Parcel getParcelInfo(Long parcelId) {
		return parcelRepository.findById(parcelId).orElseThrow(() -> new ParametrizedException(HttpStatus.NOT_FOUND, "", ""))
				;
	}
}
