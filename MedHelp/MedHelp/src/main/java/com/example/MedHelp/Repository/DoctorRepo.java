package com.example.MedHelp.Repository;

import com.example.MedHelp.Entity.Doctor;
import com.example.MedHelp.Entity.Specialization;

import java.util.List;

public interface DoctorRepo {
    void save(Doctor doctor);
    Doctor findById(String Id);
    List<Doctor> findAll();
    List<Doctor> findBySpecialization(Specialization specialization);
}
