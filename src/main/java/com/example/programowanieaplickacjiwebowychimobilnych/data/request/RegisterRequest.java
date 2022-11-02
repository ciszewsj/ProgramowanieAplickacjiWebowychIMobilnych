package com.example.programowanieaplickacjiwebowychimobilnych.data.request;

import lombok.Data;

@Data
public class RegisterRequest {
	private String name;
	private String password;
	private String email;
	private String phone;

	public String postCode;
	public String city;
	public String street;
	public String houseNumber;
}
