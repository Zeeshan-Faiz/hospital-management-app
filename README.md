# Hospital Management Application Documentation

![image.info](hospital-management-snapshot.png)

## Overview

Welcome to the Hospital Management Application, a Java-based solution for managing patient details, viewing doctors, and booking appointments. This application utilizes JDBC with MySQL as the backend database, offering seamless connectivity and efficient data management.

## Features

### 1. Adding Patient Details

Users can add patient details to the database by providing essential information such as name, age, gender. The application ensures accurate and secure storage of patient records.

### 2. Viewing Doctors

The "View Doctors" feature allows users to access a list of doctors available in the hospital. Information such as the doctor's name, specialization is displayed to assist patients in making informed choices.

### 3. Booking an Appointment

Patients can book appointments based on the availability of doctors. The application checks the doctor's schedule, ensuring that appointments are booked only during their free slots. The booking process includes selecting a preferred doctor and specifying the desired appointment time.

## Installation

1. **Java Development Kit (JDK):** Ensure you have Java installed on your system.
2. **MySQL Connector/J:** Download and install the MySQL Connector/J from [MySQL Downloads](https://dev.mysql.com/downloads/connector/j/).
3. **Add Connector to Classpath:** Add the MySQL Connector/J JAR file to your project's classpath.

## Database Setup

1. **Create Database:** Run the SQL script provided to create the necessary database and tables.
2. **Configure Connection:** Update the JDBC connection details in your Java code.

## Running the Application

1. Compile and run the Java application.
2. Follow the on-screen prompts to navigate through the functionalities.

## Dependencies

- Java
- MySQL Database
- MySQL Connector/J



```SQL
// Sample query to create doctor and patient schemas.

create database hospital;
use hospital;

create table patients(
patient_id INT AUTO_INCREMENT PRIMARY KEY,
patient_name VARCHAR(255) NOT NULL,
patient_age INT NOT NULL,
patient_gender VARCHAR(10) NOT NULL);


create table doctors(
doctor_id INT AUTO_INCREMENT PRIMARy KEY,
doctor_name VARCHAR(255) NOT NULL,
specialization VARCHAR(255) NOT NULL);

create table appointments(
id INT AUTO_INCREMENT PRIMARY KEY,
patient_id INT NOT NULL,
doctor_id INT NOT NULL,
appointment_date DATE NOT NULL,
FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id));

insert into hospital.doctors(doctor_name,specialization)
values ('Dr George', 'General Physician'); 

insert into hospital.doctors(doctor_name,specialization)
values ('Dr Michael', 'Neuro Surgeon'); 

```

```Java
// Sample code snippet for connecting to MySQL database using JDBC and mysql connector.
public static Connection createDBconnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			final String url = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
			final String username = "root";
			final String password = "password";
			
			con = DriverManager.getConnection(url,username,password);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

// Sample code snippet from the code
while(true){
            System.out.println("HOSPITAL MANAGEMENT SYSTEM ");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    // Add Patient
                    patient.addPatient();
                    System.out.println();
                    break;
                case 2:
                    // View Patient
                    patient.viewPatients();
                    System.out.println();
                    break;
                case 3:
                    // View Doctors
                    doctor.viewDoctors();
                    System.out.println();
                    break;
                case 4:
                    // Book Appointment
                    bookAppointment(patient, doctor, con, sc);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("THANK YOU!!! FOR USING HOSPITAL MANAGEMENT SYSTEM!!");
                    return;
                default:
                    System.out.println("Enter valid choice!!!");
                    break;
            }
}
