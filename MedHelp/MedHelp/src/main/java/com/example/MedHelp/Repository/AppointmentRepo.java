package com.example.MedHelp.Repository;

import com.example.MedHelp.Entity.Appointment;
import com.example.MedHelp.Entity.Doctor;

import java.util.List;

public interface AppointmentRepo {
    void save(Appointment slot);
    List<Appointment> findByDoctor(Doctor doctor);
    List<Appointment> findAll();
}
