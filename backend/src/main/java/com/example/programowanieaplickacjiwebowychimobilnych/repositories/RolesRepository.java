package com.example.programowanieaplickacjiwebowychimobilnych.repositories;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {

	Role findFirstByRole(String name);
}
