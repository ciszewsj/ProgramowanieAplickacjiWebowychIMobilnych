package com.example.programowanieaplickacjiwebowychimobilnych.data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ParcelStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Status status;

	public Date date;

	@OneToOne
	public Address address;

	enum Status {
		NEW, RECEIVED, ROUTE, READY, DELIVERED
	}
}
