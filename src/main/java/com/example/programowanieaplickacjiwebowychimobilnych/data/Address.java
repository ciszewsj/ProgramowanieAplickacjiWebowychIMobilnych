package com.example.programowanieaplickacjiwebowychimobilnych.data;

import javax.persistence.*;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String city;

	public String street;

	public String houseNumber;

	public String postCode;

}
