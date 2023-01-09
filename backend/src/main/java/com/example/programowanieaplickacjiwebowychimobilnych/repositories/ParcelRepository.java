package com.example.programowanieaplickacjiwebowychimobilnych.repositories;


import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Parcel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
	Optional<Parcel> findById(Long parcelId);

	List<Parcel> findBySenderId(Long senderId);
}
