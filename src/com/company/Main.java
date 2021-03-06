package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.AppointmentRepository;
import com.company.repositories.DoctorRepository;
import com.company.repositories.interfaces.IAppointmentRepository;
import com.company.repositories.interfaces.IDoctorRepository;

public class Main {

    public static void main(String[] args) {
	// write your code here
        IDB db = new PostgresDB() ;
        IDoctorRepository doctorRepository = new DoctorRepository(db);
        DoctorFrontend app = new DoctorFrontend(doctorRepository);
        app.start();
    }
}
