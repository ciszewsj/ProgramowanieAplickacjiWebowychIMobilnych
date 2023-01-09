package com.example.programowanieaplickacjiwebowychimobilnych.data.entity;

import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Setter
@Table(name = "role_table")
public class Role implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Length(max = 100)
	@Column(name = "role_name")
	private String role;

	@Override
	public String getAuthority() {
		return role;
	}

	public Role() {

	}

	public Role(String role) {
		this.role = role;
	}
}
