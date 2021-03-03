package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Patient;
import com.company.repositories.interfaces.IPatientRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements IPatientRepository {
    private final IDB db;

    public PatientRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createPatient(Patient patient) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Patient(name, surname,gender, illness, preference) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, patient.getName());
            st.setString(2, patient.getSurname());
            st.setBoolean(3, patient.isGender());
            st.setString(4, patient.getIllness());
            st.setBoolean(5, patient.isPreference());

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
    public Patient getPatientById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, illness FROM Patient WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("illness"));

                return patient;
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
    public List<Patient> getAllPatient() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname FROM Patient";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Patient> patients = new ArrayList<>();
            while (rs.next()) {
                Patient patient = new Patient(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"));


                patients.add(patient);
            }

            return patients;
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
