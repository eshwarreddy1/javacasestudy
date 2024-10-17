package com.hexaware.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.Doctor;
import com.hexaware.hms.entity.Patient;

public class HospitalDaoImp implements IHospitalDao {
	private Connection conn;
	public HospitalDaoImp() {
		
		conn=DBUtil.getDBConnection();
	
	}
	@Override
	public int createPatient(Patient pat) {
		int count=0;
		
			String insert="insert into Patient(patientId,firstName,lastName,dateOfBirth,contactNumber,address) values(?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt=conn.prepareStatement(insert);
				
				pstmt.setInt(1, pat.getPatientId());
				pstmt.setString(2, pat.getFirstName());
				pstmt.setString(3, pat.getLastName());
				pstmt.setString(4, pat.getDateOfBirth());
				pstmt.setInt(5, pat.getContactNumber());
				pstmt.setString(6, pat.getAddress());
				
				count=pstmt.executeUpdate();
				
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return count;
	}

	@Override
	public int createDoctor(Doctor doc) {
		int count=0;
		
		String insert="insert into Doctor(doctorId,firstName,lastName,specialization,contactNumber) values(?,?,?,?,?)";
	
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(insert);
				pstmt.setInt(1, doc.getDoctorId());
				pstmt.setString(2, doc.getFirstName());
				pstmt.setString(3, doc.getLastName());
				pstmt.setString(4, doc.getSpecialization());
				pstmt.setInt(5, doc.getContactNumber());
				
				count=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		

		
		return count;
	}

	@Override
	public List<Appointment> getAppointmentById(int appointmentId) {
		List<Appointment> list=new ArrayList<Appointment>();
		
		String selectAll="select *from Appointment where appointmentId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.setInt(1, appointmentId);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int appointmentID=rs.getInt("appointmentID");
				int patientID=rs.getInt("patientId");
				int doctorID=rs.getInt("doctorId");
				String appointmentDate=rs.getString("appointmentDate");
				String description=rs.getString("description");
				
				Appointment applist=new Appointment(appointmentID,patientID,doctorID,appointmentDate,description);
		
				list.add(applist);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

	@Override
	public List<Appointment> getAppointmentsForPatient(int patientId) {
		List<Appointment> list=new ArrayList<Appointment>();
		
		String selectAll="select *from Appointment where patientId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.setInt(1, patientId);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int appointmentID=rs.getInt("appointmentID");
				int patientID=rs.getInt("patientId");
				int doctorID=rs.getInt("doctorId");
				String appointmentDate=rs.getString("appointmentDate");
				String description=rs.getString("description");
				
				Appointment applist=new Appointment(appointmentID,patientID,doctorID,appointmentDate,description);
		
				list.add(applist);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Appointment> getAppointmentsForDoctor(int doctorId) {
		List<Appointment> list=new ArrayList<Appointment>();
		
		String selectAll="select *from Appointment where doctorId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(selectAll);
			pstmt.setInt(1, doctorId);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int appointmentID=rs.getInt("appointmentID");
				int patientID=rs.getInt("patientId");
				int doctorID=rs.getInt("doctorId");
				String appointmentDate=rs.getString("appointmentDate");
				String description=rs.getString("description");
				
				Appointment applist=new Appointment(appointmentID,patientID,doctorID,appointmentDate,description);
		
				list.add(applist);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int scheduleAppointment(Appointment app) {
		int count=0;
		
		String insert="insert into appointment(appointmentId,patientId,doctorId,appointmentDate,description) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			
			pstmt.setInt(1, app.getAppointmentId());
			pstmt.setInt(2, app.getPatientId());
			pstmt.setInt(3, app.getDoctorId());
			pstmt.setString(4, app.getAppointmentDate());
			pstmt.setString(5, app.getDescription());
			
			count=pstmt.executeUpdate();
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int updateAppointment(Appointment app) {
		int count=0;
		
		String update="update Appointment set patientId = ?, doctorId = ?, appointmentDate = ?, description = ? where appointmentId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
			
			pstmt.setInt(1, app.getPatientId());
			pstmt.setInt(2, app.getDoctorId());
			pstmt.setString(3, app.getAppointmentDate());
			pstmt.setString(4, app.getDescription());
			pstmt.setInt(5, app.getAppointmentId());
			
			count=pstmt.executeUpdate();
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;	
	}

	@Override
	public int cancelAppointment(Appointment app) {
		int count=0;
		
		String delete="delete from Appointment where appointmentId=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(delete);
			
			pstmt.setInt(1, app.getAppointmentId());
			
			count=pstmt.executeUpdate();
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}
