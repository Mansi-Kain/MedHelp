package com.example.MedHelp.Repository.Impl;

import com.example.MedHelp.Entity.Doctor;
import com.example.MedHelp.Entity.Specialization;
import com.example.MedHelp.Repository.DoctorRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepoImpl implements DoctorRepo {
    private Map<String,Doctor> doctors=new HashMap<>();
    @Override
    public void save(Doctor doctor) {
        doctors.put(doctor.getId(),doctor);
    }

    @Override
    public Doctor findById(String Id) {
        return doctors.get(Id);
    }

    @Override
    public List<Doctor> findAll() {
        return new ArrayList<>(doctors.values());
    }

    @Override
    public List<Doctor> findBySpecialization(Specialization specialization) {
        List<Doctor> specializedDoctors = new ArrayList<>();
        for(Doctor doctor:doctors.values()){
            if(doctor.getSpecialization().equals(specialization)){
                specializedDoctors.add(doctor);
            }
        }
        return specializedDoctors;
    }
}
