package com.example.programowanieaplickacjiwebowychimobilnych.data;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String name;

	public CustomerType customerType;

	@OneToOne
	public Address address;

	enum CustomerType{
		SENDER, recipient
	}
}
