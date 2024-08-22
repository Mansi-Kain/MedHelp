package com.example.MedHelp.Repository.Impl;

import com.example.MedHelp.Entity.Appointment;
import com.example.MedHelp.Entity.Doctor;
import com.example.MedHelp.Repository.AppointmentRepo;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepoImpl implements AppointmentRepo {


    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public void save(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public List<Appointment> findByDoctor(Doctor doctor) {
        List<Appointment> doctorAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDoctor().equals(doctor)) {
                doctorAppointments.add(appointment);
            }
        }
        return doctorAppointments;
    }

    @Override
    public List<Appointment> findAll() {
        return new ArrayList<>(appointments);
    }
}
