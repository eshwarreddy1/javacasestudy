package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dao.HospitalDaoImp;
import com.hexaware.hms.dao.IHospitalDao;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.Doctor;
import com.hexaware.hms.entity.Patient;


public class HospitalServiceImp implements IHospitalService {
	private	IHospitalDao dao;
	public HospitalServiceImp() {
		dao=new HospitalDaoImp();
	}
	@Override
	public int createPatient(Patient pat) {
		// TODO Auto-generated method stub
		return dao.createPatient(pat);
	}

	@Override
	public int createDoctor(Doctor doc) {
		// TODO Auto-generated method stub
		return dao.createDoctor(doc);
	}

	@Override
	public List<Appointment> getAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		return dao.getAppointmentById(appointmentId);
	}

	@Override
	public List<Appointment> getAppointmentsForPatient(int patientId) {
		// TODO Auto-generated method stub
		return dao.getAppointmentsForPatient(patientId);
	}

	@Override
	public List<Appointment> getAppointmentsForDoctor(int doctorId) {
		// TODO Auto-generated method stub
		return dao.getAppointmentsForDoctor(doctorId);
	}

	@Override
	public int scheduleAppointment(Appointment app) {
		// TODO Auto-generated method stub
		return dao.scheduleAppointment(app);
	}

	@Override
	public int updateAppointment(Appointment app) {
		// TODO Auto-generated method stub
		return dao.updateAppointment(app);
	}

	@Override
	public int cancelAppointment(Appointment app) {
		// TODO Auto-generated method stub
		return dao.cancelAppointment(app);
	}
	public static boolean vaildatePatient(Patient pat) {
		
		
		boolean flag=false;
		String date= "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
		if(pat.getPatientId()>100 && pat.getFirstName().length()>5 && pat.getLastName().length()>3 && pat.getDateOfBirth().matches(date)) {
			
			flag=true;
		}
		return flag;
	}
	public static boolean vaildateDoctor(Doctor doc) {
		
		
		boolean flag=false;
		if(doc.getDoctorId()>200 && doc.getFirstName().length()>5 && doc.getLastName().length()>3) {
			
			flag=true;
		}
		return flag;
	}
	public static boolean vaildateAppointment(Appointment app) {
		
		
		boolean flag=false;
		String date= "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
		if(app.getAppointmentId()>300 && app.getAppointmentDate().matches(date) && app.getDescription().length()>3) {
			
			flag=true;
		}
		return flag;
	}

}
