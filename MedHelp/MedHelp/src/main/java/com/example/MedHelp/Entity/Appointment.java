package com.example.MedHelp.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Appointment {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Doctor doctor;
    private Patient patient;
    private List<Patient> waitlist=new ArrayList<>();

    public Appointment(LocalDateTime startTime, LocalDateTime endTime, Doctor doctor) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor = doctor;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Patient> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(List<Patient> waitlist) {
        this.waitlist = waitlist;
    }

    public void addPatientToWaitlist(Patient patient){
        waitlist.add(patient);
    }
    public void removePatientFromWaitlist(Patient patient){
        waitlist.remove(patient);
    }
}
