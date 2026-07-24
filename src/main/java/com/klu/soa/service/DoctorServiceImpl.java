package com.klu.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.soa.entity.Doctor;
import com.klu.soa.repository.DoctorRepository;

import jdk.javadoc.doclet.Reporter;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorrepository;



	@Override
	public Doctor addDoctor(Doctor d) {
		return doctorrepository.save(d);
		
	}

	@Override
	public Doctor updateDoctor(Doctor d) {
		Optional<Doctor> optional = doctorrepository.findById(d.getId());
		if (!optional.isEmpty()) {
			Doctor doctor = optional.get();
			doctor.setName(d.getName());
			doctor.setSalary(d.getSalary());
			doctor.setExperience(d.getExperience());
			doctor.setContact(d.getContact());
			
			return doctorrepository.save(doctor);
			
		}
		return null;
	}

	@Override
	public List<Doctor> displayAllDoctors() {
		List<Doctor> doctors = doctorrepository.findAll();
		return doctors;
	}

	@Override
	public Doctor displayDoctorById(Long id) {
		return doctorrepository.findById(id).orElse(null);
	}

	@Override
	public String deleteDoctorById(Long id) {
		if (doctorrepository.existsById(id)) {
			doctorrepository.deleteById(id);
			return "Doctor Deleted Successfuly";
		}
		
		return "Doctor Id not Found";
	}

	@Override
	public List<Doctor> displayDoctorsByGender(String gender) {
		return doctorrepository.findByGender(gender);
	}
	
}
