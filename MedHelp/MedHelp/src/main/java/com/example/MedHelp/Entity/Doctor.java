package com.example.MedHelp.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Doctor implements Cloneable{
    private String id;
    private String name;
    private Specialization specialization;
    private List<Appointment> avaiableSlots = new ArrayList<>();
    private List<Appointment> bookedSlots=new ArrayList<>();

    public Doctor(String id, String name, Specialization specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
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

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Appointment> getAvaiableSlots() {
        return avaiableSlots;
    }

    public void setAvaiableSlots(List<Appointment> avaiableSlots) {
        this.avaiableSlots = avaiableSlots;
    }

    public List<Appointment> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(List<Appointment> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public void addAvailableSlot(Appointment slot){
        avaiableSlots.add(slot);
    }

    public void bookSlot(Appointment slot){
        avaiableSlots.remove(slot);
        bookedSlots.add(slot);
    }

    public void cancelSlot(Appointment slot){
        bookedSlots.remove(slot);
        avaiableSlots.add(slot);
    }
}
