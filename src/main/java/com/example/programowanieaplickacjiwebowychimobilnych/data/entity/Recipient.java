package com.example.programowanieaplickacjiwebowychimobilnych.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Recipient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String name;

	public String email;

	public String phone;
}
