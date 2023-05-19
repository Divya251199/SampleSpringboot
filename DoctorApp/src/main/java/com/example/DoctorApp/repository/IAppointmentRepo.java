package com.example.DoctorApp.repository;


import com.example.DoctorApp.model.Appointment;
import com.example.DoctorApp.model.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<Appointment, AppointmentKey> {

//    public String findByIdAppId(Long id);
}
