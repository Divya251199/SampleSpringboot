package com.example.UserManagement.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty(message = "Why is id empty")
    private String userId;
    @NotNull
    private String name;
    @Email
    private String email;
    @NotBlank
    private String userName;
    private String address;
//    @Size(min = 10, max = 12)
//    @Pattern(regexp = "[0-9]+")
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String phoneNumber;
}
