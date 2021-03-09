package com.company.repositories.interfaces;

import com.company.entities.Appointment;

import java.util.List;

public interface IAppointmentRepository {
    boolean createAppointment(Appointment appointment);
    int getRoomByAppointmentId(int app_id);
    String getAppointmentByDate(String date);
    List<Appointment> getAllAppointments();
}
