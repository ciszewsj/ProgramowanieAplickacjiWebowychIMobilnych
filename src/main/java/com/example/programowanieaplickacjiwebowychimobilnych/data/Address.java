package com.example.programowanieaplickacjiwebowychimobilnych.data;

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
	public String postCode;

	@NotBlank
	public String city;

	public String street;

	@NotBlank
	public String houseNumber;

}
