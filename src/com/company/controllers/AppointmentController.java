package com.company.controllers;

import com.company.entities.Appointment;
import com.company.repositories.interfaces.IAppointmentRepository;

import java.util.List;

public class AppointmentController {
    private final IAppointmentRepository repo;

    public AppointmentController(IAppointmentRepository repo) {
        this.repo = repo;
    }

    public String createAppointment(int app_id, int doc_id, int pat_id, String date, int room, int bill) {
        Appointment appointment = new Appointment(app_id, doc_id, pat_id, date, room, bill);

        boolean created = repo.createAppointment(appointment);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getAppointmentByDate(String date) {
        String appointment = repo.getAppointmentByDate(date);

        return (appointment == null ? "User was not found!" : appointment.toString());
    }

    public String getAllAppointments() {
        List<Appointment> appointments = repo.getAllAppointments();

        return appointments.toString();
    }

}
