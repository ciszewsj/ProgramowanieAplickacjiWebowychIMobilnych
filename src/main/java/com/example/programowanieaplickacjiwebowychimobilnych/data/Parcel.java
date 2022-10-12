package com.example.programowanieaplickacjiwebowychimobilnych.data;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Parcel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public final Date creationDate;

	@OneToOne
	public Customer sender;

	@OneToOne
	public Customer recipient;

	@OneToMany
	public List<ParcelStatus> parcelStatus;

	public Parcel() {
		creationDate = new Date();
	}
}
