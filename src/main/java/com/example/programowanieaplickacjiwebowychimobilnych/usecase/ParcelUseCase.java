package com.example.programowanieaplickacjiwebowychimobilnych.usecase;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Parcel;

public interface ParcelUseCase {

	Parcel createParcel(Parcel parcel);

	Parcel updateParcel(Parcel parcel);

	Parcel changeParcelStatus(Parcel parcel);

	Parcel getParcelInfo(Long parcelId);
}
