package com.example.programowanieaplickacjiwebowychimobilnych.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

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
	@Length(min = 5, max = 5)
	private String postCode;

	@NotBlank
	@Length(min = 1, max = 50)
	private String city;

	@Length(max = 100)
	private String street;

	@NotBlank
	@Length(max = 25)
	private String houseNumber;

}
