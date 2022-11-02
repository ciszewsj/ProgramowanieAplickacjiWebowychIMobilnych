package com.example.programowanieaplickacjiwebowychimobilnych.controller;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.ChangeParcelStatusRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.AdminUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/admin")
public class AdminContoller {
	private final AdminUseCase adminUseCase;

	@GetMapping("/parcels")
	private Page<Parcel> getAllParcels() {
		return adminUseCase.getParcels();
	}

	@PutMapping("/parcel")
	private void changeParcelStatus(@RequestBody ChangeParcelStatusRequest request) {
		adminUseCase.changeParcelStatus(request.getParcelId(), request.getParcelStatus());
	}

}