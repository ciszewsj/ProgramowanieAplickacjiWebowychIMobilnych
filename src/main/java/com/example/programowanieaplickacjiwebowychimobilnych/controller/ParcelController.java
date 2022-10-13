package com.example.programowanieaplickacjiwebowychimobilnych.controller;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.services.ParcelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcel")
public class ParcelController {

	final ParcelService parcelService;

	public ParcelController(ParcelService parcelService) {
		this.parcelService = parcelService;
	}

	@GetMapping
	public List<Parcel> getParcels() {
		return parcelService.getParcels();
	}

	@GetMapping("/{parcelId}")
	public Parcel getParcel(@PathVariable Long parcelId) {
		return parcelService.getParcelInfo(parcelId);
	}

	@PostMapping(value = "/send")
	public void postParcel() {
		parcelService.createParcel();
	}
}
