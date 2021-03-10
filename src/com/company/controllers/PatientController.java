package com.company.controllers;

import java.util.List;

import com.company.entities.Patient;
import com.company.repositories.interfaces.IPatientRepository;


public class PatientController {
    private final IPatientRepository repo;

    public PatientController(IPatientRepository repo) {
        this.repo = repo;
    }

    public String createPatient(String name , String surname, boolean gender, String illness, boolean preference) {
        Patient Patient = new Patient(name, surname, gender, illness, preference);

        boolean created = repo.createPatient(Patient);

        return (created ? "Patient was created!" : "Patient creation was failed!");
    }

    public Patient getPatient(int id) {
        Patient Patient = repo.getPatientById(id);
        return Patient;
      //  return (Patient == null ? "Patient was not found!" : Patient.toString());
    }

    public String getAllPatients() {
        List<Patient> Patients = repo.getAllPatient();

        return Patients.toString();
    }
}
