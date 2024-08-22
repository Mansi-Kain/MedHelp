package com.example.MedHelp.Services.Impl;

import com.example.MedHelp.Entity.Appointment;
import com.example.MedHelp.Entity.Doctor;
import com.example.MedHelp.Entity.Specialization;
import com.example.MedHelp.Repository.AppointmentRepo;
import com.example.MedHelp.Repository.DoctorRepo;
import com.example.MedHelp.Services.DoctorService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorServiceImpl implements DoctorService {
    private DoctorRepo doctorRepo;
    private AppointmentRepo appointmentRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo, AppointmentRepo appointmentRepo) {
        this.doctorRepo = doctorRepo;
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public Doctor registerDoctor(String id, String name, Specialization specialization) {
        Doctor doctor = new Doctor(id,name ,specialization);
        doctorRepo.save(doctor);
        return doctor;
    }

    @Override
    public void declareAvailability(Doctor doctor, LocalDateTime startTime, LocalDateTime endTime) {
        Appointment slot=new Appointment(startTime,endTime,doctor);
        doctor.addAvailableSlot(slot);
        appointmentRepo.save(slot);
    }

    @Override
    public List<Appointment> getAvailableSlots(Specialization specialization) {
        List<Doctor> specializedDoctors = doctorRepo.findBySpecialization(specialization);
        List<Appointment> availableSlots = new ArrayList<>();
        for (Doctor doctor : specializedDoctors) {
            availableSlots.addAll(appointmentRepo.findByDoctor(doctor));
        }
        return availableSlots;
    }

    @Override
    public List<Appointment> getBookedSlots(Doctor doctor) {
        return appointmentRepo.findByDoctor(doctor);
    }
}
