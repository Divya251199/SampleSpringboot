package com.example.EcommerceAPI.service;

import com.example.EcommerceAPI.Repository.IAddressRepository;
import com.example.EcommerceAPI.Repository.IUserRepository;
import com.example.EcommerceAPI.model.Address;
import com.example.EcommerceAPI.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    IUserRepository userRepository;

    public String addAddress(Address address) {
        Users user = address.getUserId();
        Optional<Users> list =  userRepository.findById(user.getUserId());

        if ( list.isEmpty() ) {
            return "Address cannot be added";
        }
        address.setUserId(list.get());
        addressRepository.save(address);
        return "Address added successfully";
    }
}
