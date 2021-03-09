package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Appointment;
import com.company.repositories.interfaces.IAppointmentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository implements IAppointmentRepository {
    private final IDB db;
    public AppointmentRepository(IDB db) { this.db=db;
    }

    @Override
    public boolean createAppointment(Appointment appointment) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Appointment(doc_id,pat_id,date,room,bill) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
 /*
    some sql prepared statements to deal with database , like insert into table
      */
            st.setInt(1, appointment.getDoc_id());
            st.setInt(2, appointment.getPat_id());
            st.setString(3, appointment.getDate());
            st.setInt(4, appointment.getRoom());
            st.setInt(5, appointment.getBill());

            boolean executed = st.execute();
            return executed;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public int getRoomByAppointmentId(int app_id) {
        return 0;
    }

    //need to write method parseInt
    @Override
    public String getAppointmentByDate(String date) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT app_id FROM appointment WHERE date=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, date);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                date = rs.getString("date");

                return date;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public List<Appointment> getAllAppointments() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT app_id,doc_id,pat_id,date,room,bill FROM Appointment";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Appointment> appointments = new ArrayList<>();
            while (rs.next()) {
                Appointment appointment = new Appointment(rs.getInt("app_id"),
                        rs.getInt("doc_id"),
                        rs.getInt("pat_id"),
                        rs.getString("date"),
                        rs.getInt("room"),
                        rs.getInt("bill"));

                appointments.add(appointment);
            }

            return appointments;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}
