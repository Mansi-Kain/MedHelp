package com.example.MedHelp.Repository.Impl;

import com.example.MedHelp.Entity.Patient;
import com.example.MedHelp.Repository.PatientRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientRepoImpl implements PatientRepo {
    private Map<String, Patient> patients = new HashMap<>();
    @Override
    public void save(Patient patient) {
        patients.put(patient.getId(),patient);
    }

    @Override
    public List<Patient> findAll() {
        return new ArrayList<>(patients.values());
    }

    @Override
    public Patient findById(String id) {
        return patients.get(id);
    }
}
