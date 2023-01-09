package com.example.programowanieaplickacjiwebowychimobilnych.controller;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.serlializer.CustomerSerializer;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.ChangeParcelStatusRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.data.response.ParcelResponse;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.AdminUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Transactional
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
	private final AdminUseCase adminUseCase;

	@GetMapping("/parcels")
	private List<ParcelResponse> getAllParcels() {
		return adminUseCase.getParcels().stream().map(CustomerSerializer::mapParcelToParcelResponse).collect(Collectors.toList());
	}

	@PutMapping("/parcel")
	private void changeParcelStatus(@RequestBody ChangeParcelStatusRequest request) {
		adminUseCase.changeParcelStatus(request.getParcelId(), request.getParcelStatus());
	}

}
