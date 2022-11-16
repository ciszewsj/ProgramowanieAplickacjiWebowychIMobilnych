package com.example.programowanieaplickacjiwebowychimobilnych.data.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public abstract class AddressInformationRequest {
	@NotBlank
	@Length(min = 5, max = 5)
	String postCode;

	@NotBlank
	@Length(min = 1, max = 50)
	String city;

	@Length(max = 100)
	String street;

	@NotBlank
	@Length(max = 25)
	String houseNumber;
}
