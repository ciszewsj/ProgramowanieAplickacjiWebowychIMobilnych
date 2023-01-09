package com.example.programowanieaplickacjiwebowychimobilnych.data.entity.serlializer;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.Parcel;
import com.example.programowanieaplickacjiwebowychimobilnych.data.response.ParcelResponse;

public class CustomerSerializer {

	public static ParcelResponse mapParcelToParcelResponse(Parcel parcel) {
		return ParcelResponse.builder()
				.id(parcel.getId())
				.address(parcel.getAddress())
				.parcelStatus(parcel.getParcelStatus())
				.recipient(parcel.getRecipient().getName())
				.sender(parcel.getSender().getName())
				.build();
	}
}
