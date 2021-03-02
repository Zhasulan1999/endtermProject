package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.AppointmentRepository;
import com.company.repositories.interfaces.IAppointmentRepository;

public class Main {

    public static void main(String[] args) {
	// write your code here
        IDB db = new PostgresDB();
        IAppointmentRepository repo = new AppointmentRepository(db);
        MyApplication app = new MyApplication();
        app.start();
    }
}
