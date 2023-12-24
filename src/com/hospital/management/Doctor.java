package com.hospital.management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Doctor {

	private Connection con;
	
	public Doctor(Connection con) {
		this.con = con;
	}
	
	
	public void viewDoctors() {
		
		String query = "select * from doctors";
		
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			System.out.println("Doctors: ");
            System.out.println("+------------+--------------------------+------------------+");
            System.out.println("| Doctor Id  | Doctor Name              | Specialization   |");
            System.out.println("+------------+--------------------------+------------------+");
            while(result.next()){
                int doctor_id = result.getInt(1);
                String doctor_name = result.getString(2);
                String doctor_specialization = result.getString(3);
                System.out.printf("| %-10s | %-24s | %-16s |\n", doctor_id , doctor_name, doctor_specialization);
                System.out.println("+------------+--------------------------+------------------+");
            }
		}

		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public boolean getDoctorById(int doctorId) {
		
		String query = "select * from doctors where doctor_id=" + doctorId;
		
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			if(result.next()){
                return true;
                }
            else
            	return false;
		}

		catch(SQLException ex) {
			ex.printStackTrace();
		}	
		return false;
	}	
	
}
