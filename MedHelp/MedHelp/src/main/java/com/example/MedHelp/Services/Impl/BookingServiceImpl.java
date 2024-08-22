package com.example.MedHelp.Services.Impl;

import com.example.MedHelp.Entity.Appointment;
import com.example.MedHelp.Entity.Doctor;
import com.example.MedHelp.Entity.Patient;
import com.example.MedHelp.Services.BookingService;

public class BookingServiceImpl implements BookingService {
    @Override
    public boolean bookAppointment(Doctor doctor, Patient patient, Appointment slot) {
        if(doctor.getAvaiableSlots().contains(slot)){
            slot.setPatient(patient);
            doctor.bookSlot(slot);
            patient.bookSlot(slot);
            return true;
        }
        else{
            slot.addPatientToWaitlist(patient);
            patient.addToWaitlistSlot(slot);
            return false;
        }
    }

    @Override
    public void cancelAppointment(Doctor doctor, Patient patient, Appointment slot) {
        doctor.cancelSlot(slot);
        patient.cancelSlot(slot);

        if (!slot.getWaitlist().isEmpty()) {
            Patient nextPatient = slot.getWaitlist().get(0);
            slot.removePatientFromWaitlist(nextPatient);
            bookAppointment(doctor, nextPatient, slot);
        }
    }
}
