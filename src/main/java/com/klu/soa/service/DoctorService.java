package com.klu.soa.service;

import java.util.List;

import com.klu.soa.entity.Doctor;

public interface DoctorService {
	Doctor addDoctor(Doctor d);
	Doctor updateDoctor(Doctor d);
	List<Doctor> displayAllDoctors();
	Doctor displayDoctorById(Long id);
	String deleteDoctorById(Long id);
	List<Doctor> displayDoctorsByGender(String gender);
	Long doctorCount();
	
}
