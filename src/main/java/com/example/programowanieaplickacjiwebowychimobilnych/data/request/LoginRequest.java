package com.example.programowanieaplickacjiwebowychimobilnych.data.request;

import lombok.Data;

@Data
public class LoginRequest {
	private String username;
	private String password;
}