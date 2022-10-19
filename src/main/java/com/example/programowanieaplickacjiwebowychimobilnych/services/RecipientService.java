package com.example.programowanieaplickacjiwebowychimobilnych.services;

import com.example.programowanieaplickacjiwebowychimobilnych.data.Recipient;
import com.example.programowanieaplickacjiwebowychimobilnych.repositories.RecipientRepository;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.RecipientUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RecipientService implements RecipientUseCase {
	private final RecipientRepository recipientRepository;

	@Override
	public void changeRecipientData(Recipient recipient) {

	}
}
