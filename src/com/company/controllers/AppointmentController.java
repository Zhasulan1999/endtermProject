package com.company.controllers;

import com.company.entities.Appointment;
import com.company.entities.Doctor;
import com.company.repositories.interfaces.IAppointmentRepository;

import java.util.List;

public class AppointmentController {
    private final IAppointmentRepository repo;

    public AppointmentController(IAppointmentRepository repo) {
        this.repo = repo;
    }

    public String createAppointment(int doc_id, int pat_id, String date, int room, int bill) {
            Appointment appointment = new Appointment(doc_id,pat_id,date,room,bill);
            boolean created = repo.createAppointment(appointment);
            return (created ? "Appointment was created!" : "Appointment creation was failed!");
    }

    public String getAppointmentByDate(String date) {
        String appointment = repo.getAppointmentByDate(date);

        //  12/2/2021 // dd/mm/yyyy
        return (appointment == null ? "Appointment was not found!" : appointment.toString());
    }

    public Appointment getAppointment(int app_id) {
        Appointment appointment = repo.getAppointmentById(app_id);
        return appointment;
    }

    public String getAllAppointments() {
        List<Appointment> appointments = repo.getAllAppointments();

        return appointments.toString();
    }

//    public String getBillForPatient(int pat_id){
//        Appointment appointment = new Appointment(pat_id);
//
//        return (appointment == null ? "Appointment was not found!" : appointment.toString());
//    }

}
