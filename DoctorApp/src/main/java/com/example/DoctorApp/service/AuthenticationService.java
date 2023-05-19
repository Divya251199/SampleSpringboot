package com.example.DoctorApp.service;

import com.example.DoctorApp.model.AuthenticationToken;
import com.example.DoctorApp.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    ITokenRepo tokenRepo;
    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }


    public boolean authenticate(String userEmail, String token) {
        AuthenticationToken authToken = tokenRepo.findFirstByToken(token);
        String expectedEmail = authToken.getPatient().getPatientEmail();
        return expectedEmail.equals(userEmail);
    }
}
