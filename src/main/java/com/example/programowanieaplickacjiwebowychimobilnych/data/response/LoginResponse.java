package com.example.programowanieaplickacjiwebowychimobilnych.data.response;

import lombok.Data;

@Data
public class LoginResponse {

	private final String jwttoken;

//	public JwtResponse(String jwttoken) {
//		this.jwttoken = jwttoken;
//	}
//
//	public String getToken() {
//		return this.jwttoken;
//	}
}