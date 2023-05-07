package com.example.EcommerceAPI.Repository;

import com.example.EcommerceAPI.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {


}
