package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Doctor;
import com.company.repositories.interfaces.IDoctorRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository implements IDoctorRepository {
    private final IDB db;

    public DoctorRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createDoctor(Doctor doctor) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Employee(name,surname,gender,speciality,available) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
 /*
    some sql prepared statements to deal with database , like insert into table
      */
            st.setString(1, doctor.getName());
            st.setString(2, doctor.getSurname());
            st.setBoolean(3, doctor.isGender());
            st.setString(4,doctor.getSpeciality());
            st.setBoolean(5,doctor.isAvailable());

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
    public String getDoctorByName(String name, String surname, String speciality) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT speciality FROM doctor WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");

                return name;
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
    public boolean isAvailable(boolean available) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name,surname,gender,speciality FROM doctor WHERE available=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setBoolean(5 , available);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                available = rs.getBoolean("available");

                return available;
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
        return false;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,email,gender,occupancy,experience,salary FROM Employee";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Doctor> doctors = new ArrayList<>();
            while (rs.next()) {
                Doctor doctor = new Doctor(rs.getInt("doc_id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("speciality"),
                        rs.getBoolean("available"));

                doctors.add(doctor);
            }

            return doctors;
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