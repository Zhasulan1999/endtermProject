package com.company.entities;

public class Patient {
        private int pat_id;
        private String name;
        private String surname;
        private boolean gender;
        private String illness;
        private boolean preference;

        public Patient() {
        }
        // create Patient
        public Patient(String name, String surname, boolean gender, String illness, boolean preference) {
            setName(name);
            setSurname(surname);
            setGender(gender);
            setIllness(illness);
            setPreference(preference);
        }
        // get Patient by Id
        public Patient(int id, String name, String surname, String illness) {
            setPat_id(id);
            setName(name);
            setSurname(surname);
            setIllness(illness);
        }
        // get all patients
        public Patient(int id, String name, String surname) {
            setPat_id(id);
            setName(name);
            setSurname(surname);
        }

    public Patient(String name) {
            setName(name);
    }


    public int getPat_id() {
            return pat_id;
        }

        public void setPat_id(int pat_id) {
            this.pat_id = pat_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public boolean isGender() {
            return gender;
        }

        public void setGender(boolean gender) {
            this.gender = gender;
        }

        public String getIllness() {
            return illness;
        }

        public void setIllness(String illness) {
            this.illness = illness;
        }

        public boolean isPreference() {
            return preference;
        }

        public void setPreference(boolean preference) {
            this.preference = preference;
        }
    }

