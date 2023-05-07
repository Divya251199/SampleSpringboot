package com.geekster.EmployeeManagement.services;

import com.geekster.EmployeeManagement.model.Addresses;
import com.geekster.EmployeeManagement.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServices {
    @Autowired
    IAddressRepository addressRepository;

    public String addAddresses(List<Addresses> addresses) {
        List<Addresses> addressList = addressRepository.saveAll(addresses);
        if ( addressList == null ) {
            return "Addresses cannot be added";
        }
        return "Addresses Added SuccessFully";
    }

    public List<Addresses> getAddresses(Long addressId) {
        if ( addressId == null ) {
            return addressRepository.findAll();
        }
        else {
            List<Addresses> addresses = new ArrayList<>();
            addresses.add(addressRepository.findById(addressId).get());
            return addresses;
        }
    }

    public String removeAddress(Long addressId) {
        Optional<Addresses> addresses = addressRepository.findById(addressId);
        if (addresses.isEmpty()) {
            return "Address with address Id: " + addressId + " not found";
        }
        else  {
            addressRepository.deleteById(addressId);
            return "Address with address Id: " + addressId + " deleted successfully";
        }
    }

    public String updateAddress(Long addressId, Addresses addresses) {
        Optional<Addresses> addressList = addressRepository.findById(addressId);
        addresses.setAddressId(addressId);
        if (addressList.isEmpty()) {
            return "Address with address Id: " + addressId + " not found";
        }
        else  {
            addressRepository.save(addresses);
            return "Address with address Id: " + addressId + " deleted successfully";
        }
    }
}
