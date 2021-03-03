package com.company.controllers;

import java.util.List;

import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.repositories.interfaces.IDoctorRepository;
import com.company.repositories.interfaces.IPatientRepository;


public class DoctorController {
    private final IDoctorRepository repo;

    public DoctorController(IDoctorRepository repo) {
        this.repo = repo;
    }

    public String createDoctor(String name, String surname,  String gender ,String occupancy,int experience , int salary) {
        boolean male = (gender.toLowerCase().equals("male"));
        Employee employee = new Employee(name, surname,email , male ,  occupancy ,experience ,salary );
        boolean created = repo.createEmployee(employee);

        return (created ? "Employee was created!" : "Employee creation was failed!");
    }

    public Doctor getDoctorByName(String name) {
        Doctor doctor = repo.getDoctorByName(name);
        return doctor;
    }
    /*
 This used for getting all employees of our DB , with implementing array list we are capable to do that
  */
    public String getAllDoctors() {
        List<Doctor> Doctors = repo.getAllDoctors();

        return Doctors.toString();
    }
    /*
Is used for searching salary of employee by id
  */

    public boolean isAvailable(boolean available) {

        int salary = repo.isAvailable(available);
        return (salary == -1 ? "Salary by id was not found!" : String.valueOf(salary));

    }
    /*
    Is used for searching occupancy of employee by id
      */

}