package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Address;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepository addressRepository;

    public String addAddress(Address address) {
        addressRepository.save(address);
        return "Address added successfully";
    }

    public List<Address> getAddress(Long addressId) {
        List<Address> addresses = new ArrayList<>();
        if ( addressId != null ) {
            addresses.add(addressRepository.findById(addressId).get()) ;
            return addresses;
        }
        return addressRepository.findAll();
    }

    public String removeAddress(Long addressId) {
        Optional<Address> addresses = addressRepository.findById(addressId);
        if (addresses.isEmpty()) {
            return "Address does not exist";
        }
        else {
            addressRepository.deleteById(addressId);
            return "Address deleted successfully...!!!";
        }
    }

    public String updateAddress(Long addressId, Address address) {
        Optional<Address> addresses = addressRepository.findById(addressId);
        if (addresses.isEmpty()) {
            return "Address does not exist";
        }
        else {
            address.setAddressId(addressId);
            addressRepository.save(address);
            return "Address updated successfully...!!!";
        }
    }
}
