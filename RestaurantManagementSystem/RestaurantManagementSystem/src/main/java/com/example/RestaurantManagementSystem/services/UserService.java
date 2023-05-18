package com.example.RestaurantManagementSystem.services;

import com.example.RestaurantManagementSystem.Dto.SignInInput;
import com.example.RestaurantManagementSystem.Dto.SignInOutput;
import com.example.RestaurantManagementSystem.Dto.SignUpInput;
import com.example.RestaurantManagementSystem.Dto.SignUpOutput;
import com.example.RestaurantManagementSystem.models.AuthenticationToken;
import com.example.RestaurantManagementSystem.models.User;
import com.example.RestaurantManagementSystem.repository.IUserRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    TokenService tokenService;

    public SignUpOutput signUp(SignUpInput signUpDto) {
        User user = userRepository.findFirstByEmail(signUpDto.getEmail());

        if(user!=null){
            throw new IllegalStateException("User already exists!!!!...sign in instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if(!(roleService.validateUserRole(signUpDto.getEmail() , signUpDto.getRole()))){
            throw new IllegalStateException("Enter valid Details");
        }

        user = new User(signUpDto.getUserName(), encryptedPassword , signUpDto.getEmail(),
                signUpDto.getRole());

        userRepository.save(user);

        return new SignUpOutput("Restaurant User registered","Restaurant user account created successfully");

    }



    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);

        return hash;
    }



    public SignInOutput signIn(SignInInput signInDto) {
        User user = userRepository.findFirstByEmail(signInDto.getEmail());

        if(user==null){
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        //set up output response
        return new SignInOutput("Authentication Successful !!!", token.getToken());
    }
}
