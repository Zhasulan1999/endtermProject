package com.company.controllers;

import java.util.List;

import com.company.entities.Doctor;
import com.company.repositories.interfaces.IAppointmentRepository;
import com.company.repositories.interfaces.IDoctorRepository;


public class DoctorController {
    private final IDoctorRepository repo;
    private IAppointmentRepository appointmentRepository ;

    public DoctorController(IDoctorRepository repo, IAppointmentRepository appointmentRepository) {
        this.repo = repo;
        this.appointmentRepository=appointmentRepository;
    }

    public String createDoctor(String name, String surname,  boolean gender ,String speciality,boolean available ) {
        Doctor doctor = new Doctor(name, surname, gender , speciality ,available );
        boolean created = repo.createDoctor(doctor);
        return (created ? "Doctor was created!" : "Doctor creation was failed!");
    }

    public Doctor getDoctor(int doc_id) {
        Doctor doctor = repo.getDoctor(doc_id);
        return doctor;
    }
    /*
 This used for getting all employees of our DB , with implementing array list we are capable to do that
  */
    public String getAllDoctors() {
        List<Doctor> Doctors = repo.getAllDoctors();
        return Doctors.toString();
    }


    public String isAvailable(boolean available) {

        Doctor doctor = repo.isAvailable(available) ;
        return (doctor == null ? "Available doctor was not found!" : doctor.toString());
    }


}