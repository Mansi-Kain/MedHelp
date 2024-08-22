package com.example.MedHelp;

import com.example.MedHelp.Entity.Appointment;
import com.example.MedHelp.Entity.Doctor;
import com.example.MedHelp.Entity.Patient;
import com.example.MedHelp.Entity.Specialization;
import com.example.MedHelp.Repository.AppointmentRepo;
import com.example.MedHelp.Repository.DoctorRepo;
import com.example.MedHelp.Repository.Impl.AppointmentRepoImpl;
import com.example.MedHelp.Repository.Impl.DoctorRepoImpl;
import com.example.MedHelp.Repository.Impl.PatientRepoImpl;
import com.example.MedHelp.Repository.PatientRepo;
import com.example.MedHelp.Services.BookingService;
import com.example.MedHelp.Services.DoctorService;
import com.example.MedHelp.Services.Impl.BookingServiceImpl;
import com.example.MedHelp.Services.Impl.DoctorServiceImpl;
import com.example.MedHelp.Services.Impl.PatientServiceImpl;
import com.example.MedHelp.Services.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootApplication
public class MedHelpApplication {

	public static void main(String[] args) {
		DoctorRepo doctorRepo=new DoctorRepoImpl();
		PatientRepo patientRepo=new PatientRepoImpl();
		AppointmentRepo appointmentRepo=new AppointmentRepoImpl();

		DoctorService doctorService = new DoctorServiceImpl(doctorRepo, appointmentRepo);
		PatientService patientService = new PatientServiceImpl(patientRepo, doctorService);
		BookingService bookingService = new BookingServiceImpl();

		Doctor doctor1 = doctorService.registerDoctor("D1", "Ram", Specialization.CARDIOLOGIST);
		System.out.println("Welcome, Dr. " + doctor1.getName());

		// Declare availability
		LocalDateTime slot1Start = LocalDateTime.of(2024, 8, 20, 9, 30);
		LocalDateTime slot1End = slot1Start.plusMinutes(60);
		doctorService.declareAvailability(doctor1, slot1Start, slot1End);

		// Register patients
		Patient patient1 = patientService.registerPatient("P1", "John ");
		Patient patient2 = patientService.registerPatient("P2", "Doe");

		List<Appointment> availableSlots = patientService.searchAvailableSlots(Specialization.CARDIOLOGIST);
		System.out.println("Available slots for Cardiologist:");
		for (Appointment slot : availableSlots) {
			System.out.println("Dr. " + slot.getDoctor().getName() + " - " + slot.getStartTime() + " to " + slot.getEndTime());
		}

		// Book an appointment
		boolean isBooked = bookingService.bookAppointment(doctor1, patient1, availableSlots.get(0));
		if (isBooked) {
			System.out.println("Appointment booked successfully for " + patient1.getName());
		} else {
			System.out.println("Slot is full, added " + patient1.getName() + " to the waitlist.");
		}

		// Cancel an appointment
		bookingService.cancelAppointment(doctor1, patient1, availableSlots.get(0));
		System.out.println("Appointment cancelled for " + patient1.getName());
	}

}
