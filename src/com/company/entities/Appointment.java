package com.company.entities;

public class Appointment {
    private int app_id;
    private int doc_id;
    private int pat_id;
    private String date;
    private int room;
    private int bill;

    public Appointment(int app_id, int doc_id, int pat_id, String date, int room, int bill) {
        this.app_id = app_id;
        this.doc_id = doc_id;
        this.pat_id = pat_id;
        this.date = date;
        this.room = room;
        this.bill = bill;
    }

    public Appointment(int doc_id, int pat_id){
        this.doc_id=doc_id;
        this.pat_id=pat_id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public int getPat_id() {
        return pat_id;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "app_id=" + app_id +
                ", doc_id=" + doc_id +
                ", pat_id=" + pat_id +
                ", date='" + date + '\'' +
                ", room=" + room +
                ", bill=" + bill +
                '}';
    }
}
