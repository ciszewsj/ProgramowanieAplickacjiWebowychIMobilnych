package com.example.programowanieaplickacjiwebowychimobilnych.usecase;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.ParcelStatus;
import org.springframework.data.domain.Page;

public interface AdminUseCase {
    Page<Parcel> getParcels();

    void changeParcelStatus(Long parcelId, ParcelStatus parcelStatus);

}
