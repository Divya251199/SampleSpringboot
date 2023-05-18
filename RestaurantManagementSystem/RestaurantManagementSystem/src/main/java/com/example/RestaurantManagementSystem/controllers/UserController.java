package com.example.RestaurantManagementSystem.controllers;

import com.example.RestaurantManagementSystem.Dto.SignInInput;
import com.example.RestaurantManagementSystem.Dto.SignInOutput;
import com.example.RestaurantManagementSystem.Dto.SignUpInput;
import com.example.RestaurantManagementSystem.Dto.SignUpOutput;
import com.example.RestaurantManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }
}
