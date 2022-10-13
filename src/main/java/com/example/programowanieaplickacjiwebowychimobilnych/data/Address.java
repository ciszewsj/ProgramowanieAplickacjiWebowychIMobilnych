package com.example.programowanieaplickacjiwebowychimobilnych.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String city;

	public String street;

	public String houseNumber;

	public String postCode;

}
