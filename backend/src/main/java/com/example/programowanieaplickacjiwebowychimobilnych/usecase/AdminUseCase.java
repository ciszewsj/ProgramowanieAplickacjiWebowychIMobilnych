package com.example.programowanieaplickacjiwebowychimobilnych.usecase;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.ParcelStatus;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminUseCase {
	List<Parcel> getParcels();

	Parcel getParcel(Long parcelId);

	void changeParcelStatus(Long parcelId, ParcelStatus.Status parcelStatus);

}
