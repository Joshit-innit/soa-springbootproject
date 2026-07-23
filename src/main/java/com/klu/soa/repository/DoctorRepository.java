package com.klu.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.soa.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
}
