package com.geekster.EmployeeManagement.controller;

import com.geekster.EmployeeManagement.model.Addresses;
import com.geekster.EmployeeManagement.model.Employees;
import com.geekster.EmployeeManagement.services.AddressServices;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressServices addressServices;

    @PostMapping(value = "/addresses")
    public String addAddresses(@RequestBody List<Addresses> addresses) {
        return addressServices.addAddresses(addresses);
    }

    @GetMapping(value = "/addresses")
    public List<Addresses> getAddresses(@Nullable @RequestParam Long addressId) {
        return addressServices.getAddresses(addressId);
    }

    @DeleteMapping(value = "addresses/addressId")
    public String removeAddress(@PathVariable Long addressId) {
        return addressServices.removeAddress(addressId);
    }

    @PutMapping(value = "address/{addressId}")
    public String updateAddress(@PathVariable Long addressId, @RequestBody Addresses addresses) {
        return addressServices.updateAddress(addressId, addresses);
    }
}
