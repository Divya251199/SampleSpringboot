package com.geekster.EmployeeManagement.repository;

import com.geekster.EmployeeManagement.model.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Addresses,Long> {

}
