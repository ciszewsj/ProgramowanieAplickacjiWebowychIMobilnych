package com.example.programowanieaplickacjiwebowychimobilnych.controller;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParcelController {

	@Autowired
	ParcelService parcelService;

	@GetMapping
	public List<Parcel> getPackages() {
		return parcelService.getParcels();
	}

	@PostMapping
	public void postParcel() {
		parcelService.createParcel();
	}
}
