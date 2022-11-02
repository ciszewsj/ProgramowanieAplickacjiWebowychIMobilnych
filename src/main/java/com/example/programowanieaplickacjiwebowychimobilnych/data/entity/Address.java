package com.example.programowanieaplickacjiwebowychimobilnych.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String postCode;

	@NotBlank
	private String city;

	private String street;

	@NotBlank
	private String houseNumber;

}
