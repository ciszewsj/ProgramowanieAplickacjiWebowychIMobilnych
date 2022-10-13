package com.example.programowanieaplickacjiwebowychimobilnych.repositories;


import com.example.programowanieaplickacjiwebowychimobilnych.data.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
	Optional<Parcel> findById(Long parcelId);
}
