package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.Doctor;
import com.hexaware.hms.entity.Patient;

public interface IHospitalService {
	int createPatient(Patient pat);
	int createDoctor(Doctor doc);
	List<Appointment> getAppointmentById(int appointmentId);
	List<Appointment> getAppointmentsForPatient(int patientId);
	List<Appointment> getAppointmentsForDoctor(int doctorId);
	int scheduleAppointment(Appointment app);
	int updateAppointment(Appointment app);
	int cancelAppointment(Appointment app);
	
	
	
	
	

}
