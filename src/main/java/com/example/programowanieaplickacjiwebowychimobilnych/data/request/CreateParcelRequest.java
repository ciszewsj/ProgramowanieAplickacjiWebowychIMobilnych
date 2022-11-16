package com.example.programowanieaplickacjiwebowychimobilnych.data.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateParcelRequest {
	@NotEmpty
	private AddressInformationRequest recipientAddress;
	@NotEmpty
	private RecipientInformationRequest recipientInfo;
}
