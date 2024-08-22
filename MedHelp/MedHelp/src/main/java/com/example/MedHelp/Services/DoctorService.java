package com.example.MedHelp.Services;

import com.example.MedHelp.Entity.Appointment;
import com.example.MedHelp.Entity.Doctor;
import com.example.MedHelp.Entity.Specialization;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

public interface DoctorService{
    Doctor registerDoctor(String id , String name , Specialization specialization);
    void declareAvailability(Doctor doctor , LocalDateTime startTime ,LocalDateTime endTime);
    List<Appointment> getAvailableSlots(Specialization specialization);
    List<Appointment> getBookedSlots(Doctor doctor);
}
