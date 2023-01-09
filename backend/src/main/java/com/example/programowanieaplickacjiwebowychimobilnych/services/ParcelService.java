package com.example.programowanieaplickacjiwebowychimobilnych.services;

import com.example.programowanieaplickacjiwebowychimobilnych.config.ApplicationRoles;
import com.example.programowanieaplickacjiwebowychimobilnych.data.entity.*;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.CreateParcelRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.exception.ParametrizedException;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.*;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.ParcelUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ParcelService implements ParcelUseCase {
	private final ParcelRepository parcelRepository;
	private final ParcelStatusRepository parcelStatusRepository;
	private final AddressRepository addressRepository;
	private final RecipientRepository recipientRepository;
	private final CustomerRepository customerRepository;

	@Override
	public Parcel createParcel(Long userId, CreateParcelRequest request) {
		Customer customer = customerRepository.findById(userId).orElseThrow(new ParametrizedException("User not found"));

		Address recipientAddress = new Address();
		recipientAddress.setPostCode(request.getPostCode());
		recipientAddress.setStreet(request.getStreet());
		recipientAddress.setHouseNumber(request.getHouseNumber());
		recipientAddress.setCity(request.getCity());
		recipientAddress = addressRepository.save(recipientAddress);

		Recipient recipient = new Recipient();
		recipient.setEmail(request.getEmail());
		recipient.setName(request.getName());
		recipient = recipientRepository.save(recipient);


		ParcelStatus newParcelStatus = new ParcelStatus();
		newParcelStatus = parcelStatusRepository.save(newParcelStatus);

		Parcel newParcel = new Parcel(newParcelStatus);
		newParcel.setRecipient(recipient);
		newParcel.setSender(customer);
		newParcel.setAddress(recipientAddress);
		return parcelRepository.save(newParcel);
	}


	@Override
	public Parcel getParcel(Customer customer, Long parcelId) {
		Parcel parcel = parcelRepository.findById(parcelId).orElseThrow(new ParametrizedException("Not find parcel"));
		if (parcel.getParcelStatus().stream().map(ParcelStatus::getStatus).anyMatch(p -> p.equals(ParcelStatus.Status.SENT) || p.equals(ParcelStatus.Status.DELIVERED))) {
			return parcel;
		} else if (customer.getRoles().stream().map((Function<Role, Object>) Role::getAuthority).anyMatch(p -> p.equals(ApplicationRoles.ROLE_ADMIN))) {
			return parcel;
		} else if (parcel.getSender().getUsername().equals(customer.getUsername())) {
			return parcel;
		}
		throw new ParametrizedException("Not find parcel");
	}


	@Override
	public List<Parcel> getParcels(Long userId) {
		return parcelRepository.findBySenderId(userId);
	}
}
