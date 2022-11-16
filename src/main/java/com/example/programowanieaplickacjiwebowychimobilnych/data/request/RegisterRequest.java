package com.example.programowanieaplickacjiwebowychimobilnych.data.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
public class RegisterRequest {
	@Length(min = 6, max = 32)
	private String name;
	@Length(min = 6, max = 32)
	private String password;
	@Email
	private String email;

	private AddressInformationRequest address;
}
