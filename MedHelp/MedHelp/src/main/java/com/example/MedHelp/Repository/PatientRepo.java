package com.example.MedHelp.Repository;

import com.example.MedHelp.Entity.Patient;

import java.util.List;

public interface PatientRepo {
    void save(Patient patient);
    List<Patient> findAll();
    Patient findById(String id);
}
