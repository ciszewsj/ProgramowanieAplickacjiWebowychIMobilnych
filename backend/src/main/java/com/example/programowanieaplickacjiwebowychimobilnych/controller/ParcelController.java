package com.example.programowanieaplickacjiwebowychimobilnych.controller;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Customer;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.serlializer.CustomerSerializer;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.CreateParcelRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.data.response.ParcelResponse;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.ParcelUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.programowanieaplickacjiwebowychimobilnych.data.entity.serlializer.CustomerSerializer.mapParcelToParcelResponse;

@RestController
@RequestMapping("/api/parcel")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class ParcelController {
	private final ParcelUseCase parcelUseCase;

	@PostMapping
	public Parcel createParcel(
			@AuthenticationPrincipal Customer customer,
			@RequestBody @Validated CreateParcelRequest request) {
		return parcelUseCase.createParcel(customer.getId(), request);
	}

	@GetMapping("/{parcelId}")
	public ParcelResponse getParcel(@AuthenticationPrincipal Customer user, @PathVariable Long parcelId) {
		return mapParcelToParcelResponse(parcelUseCase.getParcel(user, parcelId));
	}

	@GetMapping
	public List<ParcelResponse> getUserParcels(@AuthenticationPrincipal Customer customer) {
		return parcelUseCase.getParcels(customer.getId()).stream().map(CustomerSerializer::mapParcelToParcelResponse).collect(Collectors.toList());
	}
}
