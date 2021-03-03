package com.company.repositories.interfaces;
import com.company.entities.Patient;
import java.util.List;

public interface IPatientRepository {
    boolean createPatient(Patient Patient);
    Patient getPatientById(int id);
    List<Patient> getAllPatient();
}
