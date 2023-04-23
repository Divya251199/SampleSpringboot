package com.example.RestaurantDirectory.model;

import lombok.Data;

@Data
public class Restaurant {
    private String restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private String phoneNumber;
    private String specialty;
    private int totalStaff;
    private String cuisine;

}
