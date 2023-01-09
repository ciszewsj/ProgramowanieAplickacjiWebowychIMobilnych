package com.example.programowanieaplickacjiwebowychimobilnych.data.response;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Address;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.ParcelStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParcelResponse {
	private Long id;
	private Address address;
	private List<ParcelStatus> parcelStatus;
	private String recipient;
	private String sender;
}
