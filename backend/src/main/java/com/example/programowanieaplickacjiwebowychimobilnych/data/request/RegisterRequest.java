package com.example.programowanieaplickacjiwebowychimobilnych.data.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterRequest {

	@Length(min = 4, max = 32, message = "Name must contain between 4 and 32 characters")
	@NotEmpty
	private String name;

	@NotEmpty
	@Length(min = 4, max = 32)
	private String password;

	@NotEmpty
	@Email
	private String email;
}
