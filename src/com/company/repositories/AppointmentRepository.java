package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.repositories.interfaces.IAppointmentRepository;

public class AppointmentRepository implements IAppointmentRepository {
    private final IDB db;
    public AppointmentRepository(IDB db) { this.db=db;
    }
}
