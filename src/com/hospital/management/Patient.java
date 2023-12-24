package com.hospital.management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Patient {

	private Connection con;
	private Scanner sc;
	
	public Patient(Connection con, Scanner sc) {
		this.con = con;
		this.sc = sc;
	}

	
	public void addPatient() {
		
		sc.nextLine();
		System.out.print("Enter Patient Name:");
		String patientName = sc.nextLine();
		System.out.print("Enter Patient Age:");
		int patientAge = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Patient Gender:");
		String patientGender = sc.nextLine();
		String query = "insert into patients(patient_name,patient_age,patient_gender)"
				+ "values ('" + patientName + "' , " + patientAge + ", '" + patientGender + "' )"; 
		
		
		try {
			Statement statement = con.createStatement();
			int affectedRows = statement.executeUpdate(query);
			if(affectedRows>0)
				System.out.println("Patient Added Successfully!!!");
			else
				System.out.println("Failed To Add Patient!!!");
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void viewPatients() {
		
		String query = "select * from patients";
		
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			System.out.println("Patients: ");
            System.out.println("+------------+--------------------+----------+------------+");
            System.out.println("| Patient Id | Name               | Age      | Gender     |");
            System.out.println("+------------+--------------------+----------+------------+");
            while(result.next()){
                int patient_id = result.getInt(1);
                String patient_name = result.getString(2);
                int patient_age = result.getInt(3);
                String patient_gender = result.getString(4);
                System.out.printf("| %-10s | %-18s | %-8s | %-10s |\n", patient_id , patient_name, patient_age, patient_gender);
                System.out.println("+------------+--------------------+----------+------------+");
            }
		}

		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public boolean getPatientById(int patientId) {
		
		String query = "select * from patients where patient_id=" + patientId;
		
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
