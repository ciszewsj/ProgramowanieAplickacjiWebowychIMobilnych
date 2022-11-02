package com.example.programowanieaplickacjiwebowychimobilnych.controller;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.ParcelUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parcel")
@RequiredArgsConstructor
@Slf4j
public class ParcelController {
	private final ParcelUseCase parcelUseCase;

	@GetMapping
	public Page<Parcel> getUserParcels(Long userID) {
		return parcelUseCase.getParcels(userID);
	}
}
