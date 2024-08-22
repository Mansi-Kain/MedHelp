package com.example.MedHelp.Services;

import com.example.MedHelp.Entity.Appointment;
import com.example.MedHelp.Entity.Patient;
import com.example.MedHelp.Entity.Specialization;

import java.util.List;

public interface PatientService {
    Patient registerPatient(String id , String name);
    List<Appointment> searchAvailableSlots(Specialization specialization );
    List<Appointment> bookedSlots(Patient patient);
}
