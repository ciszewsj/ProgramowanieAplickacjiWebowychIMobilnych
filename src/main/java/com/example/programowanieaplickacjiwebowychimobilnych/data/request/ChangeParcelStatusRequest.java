package com.example.programowanieaplickacjiwebowychimobilnych.data.request;

import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.ParcelStatus;
import lombok.Data;

@Data
public class ChangeParcelStatusRequest {
	private Long parcelId;
	private ParcelStatus parcelStatus;
}
