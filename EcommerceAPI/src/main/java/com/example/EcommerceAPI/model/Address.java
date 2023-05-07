package com.example.EcommerceAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String name;
    private String landmark;
    private String phoneNumber;
    private String zipcode;
    private String state;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users userId;
}
