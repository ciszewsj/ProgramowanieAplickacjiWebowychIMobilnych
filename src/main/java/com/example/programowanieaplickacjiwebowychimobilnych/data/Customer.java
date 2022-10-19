package com.example.programowanieaplickacjiwebowychimobilnych.data;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String name;

	@OneToOne
	public Address address;
}
