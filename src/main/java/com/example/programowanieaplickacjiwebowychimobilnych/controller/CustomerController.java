package com.example.programowanieaplickacjiwebowychimobilnych.controller;

import com.example.programowanieaplickacjiwebowychimobilnych.data.request.LoginRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.data.request.RegisterRequest;
import com.example.programowanieaplickacjiwebowychimobilnych.data.response.LoginResponse;
import com.example.programowanieaplickacjiwebowychimobilnych.usecase.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerUseCase customerUseCase;

    @PostMapping(value = "/login")
    public LoginResponse createAuthenticationToken(@RequestBody LoginRequest request)
            throws Exception {
        return customerUseCase.loginCustomer(request);
    }

    @PostMapping("/register")
    public void registerCustomer(@RequestBody RegisterRequest request) {
        customerUseCase.createCustomer(request);
    }
}
