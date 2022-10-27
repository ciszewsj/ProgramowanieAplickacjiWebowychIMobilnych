package com.example.programowanieaplickacjiwebowychimobilnych.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parcel")
@RequiredArgsConstructor
@Slf4j
public class ParcelController {

	@GetMapping
	public String getParcel() {
		return "AS";
	}
}
