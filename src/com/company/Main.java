package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.AppointmentRepository;
import com.company.repositories.DoctorRepository;
import com.company.repositories.PatientRepository;
import com.company.repositories.interfaces.IAppointmentRepository;
import com.company.repositories.interfaces.IDoctorRepository;
import com.company.repositories.interfaces.IPatientRepository;

public class Main {

    public static void main(String[] args) {
	// write your code here
        IDB db = new PostgresDB() ;
        IDoctorRepository doctorRepository = new DoctorRepository(db);
        IAppointmentRepository appointmentRepository = new AppointmentRepository(db);
        DoctorFrontend app = new DoctorFrontend(appointmentRepository, doctorRepository, appointmentRepository);

        app.start();
        /**
         * Application for Patients
         */
//        IDB db = new PostgresDB() ;
//        IPatientRepository patientRepository = new PatientRepository(db);
//        IAppointmentRepository appRepository = new AppointmentRepository(db);
//        IDoctorRepository doctorRepository = new DoctorRepository(db);
//
//        PatientFrontend app = new PatientFrontend(patientRepository, doctorRepository , appRepository);
//        app.start();
    }
}
