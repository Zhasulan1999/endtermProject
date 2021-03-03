package com.company.repositories.interfaces;

import com.company.entities.Doctor;

import java.util.List;

public interface IDoctorRepository {

    boolean createDoctor(Doctor doctor) ;
    String getDoctorByName(String name , String surname , String speciality) ;
    boolean isAvailable (boolean available);
    List<Doctor> getAllDoctors();

}
