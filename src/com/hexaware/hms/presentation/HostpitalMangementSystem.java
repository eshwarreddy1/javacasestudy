package com.hexaware.hms.presentation;

import java.util.List;
import java.util.Scanner;
import com.hexaware.hms.service.HospitalServiceImp;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.Doctor;
import com.hexaware.hms.entity.Patient;
public class HostpitalMangementSystem {
	static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag=true;
		HospitalServiceImp services=new HospitalServiceImp();
		while(flag) {
			System.out.println("***Wlecome To Hexaware Hospital***");
			System.out.println("1.Add patient");
			System.out.println("2.Add Doctor");
			System.out.println("3.Schedule Appointment");
			System.out.println("4.Update Appointment");
			System.out.println("5.Cancel Appointment");
			System.out.println("6.List of Appointment by appointmentID");
			System.out.println("7.List of Appointment by doctorID");
			System.out.println("8.List of Appointment by patientID");
			System.out.println("0.EXIT");
			
			int choice=scanner.nextInt();
			switch (choice) {
				case 1:
					Patient pat=readPatData(); 
					
					boolean isValidP = HospitalServiceImp.vaildatePatient(pat);
					
					if(isValidP) {
						int count =	services.createPatient(pat);
						
						if(count>0) {
							System.out.println("Patient Added Successfully");
						}
						else{
							System.err.println("Patient Add failed");
							
						}	
						
					}
					else {
						System.err.println("Invalid Data");
					}
					
					
					break;
				case 2:
					Doctor doc=readDocData(); 
					
					boolean isValidD = HospitalServiceImp.vaildateDoctor(doc);
					
					if(isValidD) {
						int count =	services.createDoctor(doc);
						
						if(count>0) {
							System.out.println("Doctor Added Successfully");
						}
						else{
							System.err.println("Doctor Add failed");
							
						}	
						
					}
					else {
						System.err.println("Invalid Data");
					}
					
					break;
				case 3:
					Appointment appt=readApptData(); 
					
					boolean isValidA = HospitalServiceImp.vaildateAppointment(appt);
					
					if(isValidA) {
						int count =	services.scheduleAppointment(appt);
						
						if(count>0) {
							System.out.println("Appointment Scheduled Successfully");
						}
						else{
							System.err.println("Appointment Schedule failed");
							
						}	
						
					}
					else {
						System.err.println("Invalid Data");
					}
					break;
				case 4:
					Appointment apptu=readApptData(); 
						int count =	services.updateAppointment(apptu);
						
						if(count>0) {
							System.out.println("Appointment Schedule updated Successfully");
						}
						else{
							System.err.println("Appointment Schedule update failed");
							
						}
					break;
				case 5:
					Appointment apptrm=new Appointment();
					
					System.out.println("Enter AppointmentID=");
						apptrm.setAppointmentId(scanner.nextInt());
						int countr=services.cancelAppointment(apptrm);
						
						if(countr>0) {
							System.out.println("Appointment cancelled");
						}
						else {
							System.err.println("Appointment not cancelled");
						}
					
					break;
				case 6:
					System.out.println("Enter the AppointmentID ");
					int appointmentId =scanner.nextInt();
					List<Appointment> list=services.getAppointmentById(appointmentId);
					for(Appointment appts:list) {
						
						System.out.println(appts);
						
					}
					
					break;
				case 7:
					System.out.println("Enter the doctorID=");
					int doctorId=scanner.nextInt();
					List<Appointment> list2=services.getAppointmentsForDoctor(doctorId);
					for(Appointment appts:list2) {
						
						System.out.println(appts);
						
					}
					
					break;
				case 8:
					System.out.println("Enter the patientID=");
					int patientId=scanner.nextInt();
					List<Appointment> list3=services.getAppointmentsForPatient(patientId);
					for(Appointment appts:list3) {
						
						System.out.println(appts);
						
					}
					
					break;
				case 0:
					System.out.println("*****Exit******");
					break;
		

			default:
				break;
			}
			

		}
		}
	public static Appointment readApptData(){
		Appointment appt=new Appointment();
		
		System.out.println("Enter AppointmentID=");
			appt.setAppointmentId(scanner.nextInt());
		System.out.println("Enter PatientID=");
			appt.setPatientId(scanner.nextInt());
		System.out.println("Enter DoctorID=");
			appt.setDoctorId(scanner.nextInt());
		System.out.println("Enter Appointment Date(yyyy-mm-dd)");
			appt.setAppointmentDate(scanner.next());
		System.out.println("Desripation=");
			appt.setDescription(scanner.next());
		
		
		return appt;
	}
	public static Patient readPatData(){
		Patient pat=new Patient();
		
		System.out.println("Enter PatientID=");
			pat.setPatientId(scanner.nextInt());
		System.out.println("Enter FirstName=");
			pat.setFirstName(scanner.next());
		System.out.println("Enter LastName=");
			pat.setLastName(scanner.next());
		System.out.println("Enter DateOfBrith(yyyy-mm-dd)");
			pat.setDateOfBirth(scanner.next());
		System.out.println("Enter the ContactNumber=");
			pat.setContactNumber(scanner.nextInt());
		System.out.println("Address=");
			pat.setAddress(scanner.next());
		
		
		return pat;
	}
	public static Doctor readDocData(){
		Doctor doc=new Doctor();
		
		System.out.println("Enter DoctorID=");
			doc.setDoctorId(scanner.nextInt());
		System.out.println("Enter FirstName=");
			doc.setFirstName(scanner.next());
		System.out.println("Enter LastName=");
			doc.setLastName(scanner.next());
		System.out.println("specialization=");
			doc.setSpecialization(scanner.next());
		System.out.println("Enter the ContactNumber=");
			doc.setContactNumber(scanner.nextInt());
		

		
		
		return doc;
	}
}
