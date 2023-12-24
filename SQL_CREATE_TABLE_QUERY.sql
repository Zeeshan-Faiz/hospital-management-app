##create database hospital;

##use hospital;


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