package com.example.RestaurantManagementSystem.services;

import com.example.RestaurantManagementSystem.models.AuthenticationToken;
import com.example.RestaurantManagementSystem.repository.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    ITokenRepository tokenRepository;

    public void saveToken(AuthenticationToken token) {
        tokenRepository.save(token);
    }
    public boolean authenticate(String userEmail, String token) {

        if(token==null && userEmail==null){
            return false;
        }

        AuthenticationToken authToken = tokenRepository.findFirstByToken(token);

        if(authToken==null){
            return false;
        }

        String expectedEmail = authToken.getUser().getEmail();


        return expectedEmail.equals(userEmail);

    }

    public void deleteToken(String token) {
        AuthenticationToken token1 = tokenRepository.findFirstByToken(token);
        tokenRepository.deleteById(token1.getTokenId());
    }

}
