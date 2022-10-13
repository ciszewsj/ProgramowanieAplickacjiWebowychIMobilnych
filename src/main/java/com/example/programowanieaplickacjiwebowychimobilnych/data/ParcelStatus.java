package com.example.programowanieaplickacjiwebowychimobilnych.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
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
