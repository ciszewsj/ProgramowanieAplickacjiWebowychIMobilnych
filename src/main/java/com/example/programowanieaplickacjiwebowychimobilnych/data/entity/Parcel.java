package com.example.programowanieaplickacjiwebowychimobilnych.data.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Parcel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public final Date creationDate;

	@OneToOne
	public Customer sender;

	@OneToOne
	public Recipient recipient;

	@OneToOne
	public Address address;

	@OneToMany
	public List<ParcelStatus> parcelStatus;

	public Parcel() {
		creationDate = new Date();
	}
}
