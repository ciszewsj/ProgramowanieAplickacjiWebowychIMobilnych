package com.example.programowanieaplickacjiwebowychimobilnych.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ParametrizedException extends RuntimeException {

	@Getter
	private HttpStatus status;

	@Getter
	private String message;

	@Getter
	private List<String> errors;

	public ParametrizedException(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		this.errors = Arrays.asList(error);
	}
}
