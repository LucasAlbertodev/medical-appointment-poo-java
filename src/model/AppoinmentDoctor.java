package model;

import java.util.Date;

public class AppoinmentDoctor implements ISchedulable {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;


    public AppoinmentDoctor(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time + " Hrs.";
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void schedule(Date date, String time) {
        // TODO Auto-generated method stub
        this.time = time;
        this.date = date;
        // throw new UnsupportedOperationException("Unimplemented method 'schedule'");
    }

}
