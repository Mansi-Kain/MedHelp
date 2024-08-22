package com.example.MedHelp.Services.Impl;

import com.example.MedHelp.Entity.Appointment;
import com.example.MedHelp.Entity.Patient;
import com.example.MedHelp.Entity.Specialization;
import com.example.MedHelp.Repository.DoctorRepo;
import com.example.MedHelp.Repository.PatientRepo;
import com.example.MedHelp.Services.DoctorService;
import com.example.MedHelp.Services.PatientService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
    private PatientRepo patientRepo;
    private DoctorService doctorService;

    public PatientServiceImpl(PatientRepo patientRepo,DoctorService doctorService){
        this.patientRepo=patientRepo;
        this.doctorService=doctorService;
    }

    @Override
    public Patient registerPatient(String id, String name) {
        Patient patient=new Patient(id ,name);
        patientRepo.save(patient);
        return patient;
    }

    @Override
    public List<Appointment> searchAvailableSlots(Specialization specialization) {
        return doctorService.getAvailableSlots(specialization);
    }

    @Override
    public List<Appointment> bookedSlots(Patient patient) {
        return patient.getBookedSlots();
    }
}
