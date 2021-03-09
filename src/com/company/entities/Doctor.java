package com.company.entities;

public class Doctor {

    private int doc_id ;
    private String name ;
    private String surname ;
    private boolean gender ;
    private String speciality ;
    private boolean available ;

    public Doctor(){

    }

    public Doctor(int doc_id, String name, String surname, boolean gender, String speciality, boolean available) {
      setDoc_id(doc_id);
      setName(name);
      setSurname(surname);
      setGender(gender);
      setSpeciality(speciality);
      setAvailable(available);
    }

    public Doctor(String name, String surname, boolean gender, String speciality, boolean available) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setSpeciality(speciality);
        setAvailable(available);
    }




    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }




    @Override
    public String toString() {
        return "Doctor{" +
                "doc_id=" + doc_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", speciality='" + speciality + '\'' +
                ", available=" + available +
                '}' + '\n';
    }

}
