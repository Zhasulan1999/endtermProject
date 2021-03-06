package com.company.repositories.interfaces;

import com.company.entities.Doctor;

import java.util.List;

public interface IDoctorRepository {

    boolean createDoctor(Doctor doctor) ;
    Doctor getDoctor(int doc_id) ;
    Doctor isAvailable (boolean available);
    List<Doctor> getAllDoctors();

}
