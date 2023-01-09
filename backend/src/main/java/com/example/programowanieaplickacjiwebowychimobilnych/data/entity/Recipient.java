package com.example.programowanieaplickacjiwebowychimobilnych.data.entity;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.serlializer.CustomerSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Recipient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Length(min = 4, max = 50)
	private String name;

	@Email
	@NotBlank
	@Length(min = 4, max = 50)
	private String email;
}
