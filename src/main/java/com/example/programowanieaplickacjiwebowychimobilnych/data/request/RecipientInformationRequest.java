package com.example.programowanieaplickacjiwebowychimobilnych.data.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RecipientInformationRequest {
	@NotBlank
	@Length(min = 4, max = 50)
	private String name;

	@Email
	@NotBlank
	@Length(min = 4, max = 50)
	private String email;
}
