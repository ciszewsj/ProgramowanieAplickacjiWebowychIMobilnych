package com.example.programowanieaplickacjiwebowychimobilnych.services;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelService {
	@Autowired
	private ParcelRepository parcelRepository;

	public void createParcel() {
		Parcel parcel = new Parcel();
		parcelRepository.save(parcel);
	}

	public List<Parcel> getParcels() {
		return parcelRepository.findAll();
	}
}
