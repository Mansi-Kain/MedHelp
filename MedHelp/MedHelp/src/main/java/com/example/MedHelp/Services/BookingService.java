package com.example.MedHelp.Services;

import com.example.MedHelp.Entity.Appointment;
import com.example.MedHelp.Entity.Doctor;
import com.example.MedHelp.Entity.Patient;

public interface BookingService {
    boolean bookAppointment(Doctor doctor , Patient patient , Appointment slot);
    void cancelAppointment(Doctor doctor ,Patient patient,Appointment slot);
}
