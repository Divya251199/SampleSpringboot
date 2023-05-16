package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Address;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.service.AddressService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping()
    public String addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @GetMapping()
    public List<Address> getAddress(@Nullable @RequestParam Long addressId) {
        return addressService.getAddress(addressId);
    }

    @DeleteMapping("/{addressId}")
    public String removeAddress(@PathVariable Long addressId) {
        return addressService.removeAddress(addressId);
    }

    @PutMapping("/{addressId}")
    public String updateStudent(@PathVariable Long addressId , @RequestBody Address address) {
        return addressService.updateAddress(addressId, address);
    }
}
