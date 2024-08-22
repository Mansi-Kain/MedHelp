package com.example.MedHelp.Entity;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String id;
    private String name;
    private List<Appointment> bookedSlots=new ArrayList<>();
    private List<Appointment> waitlist=new ArrayList<>();

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Appointment> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(List<Appointment> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public List<Appointment> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(List<Appointment> waitlist) {
        this.waitlist = waitlist;
    }

    public void bookSlot(Appointment slot){
        bookedSlots.add(slot);
    }

    public void cancelSlot(Appointment slot){
        bookedSlots.remove(slot);
    }

    public void addToWaitlistSlot(Appointment slot){
        waitlist.add(slot);
    }
}
