package com.klu.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.soa.entity.Doctor;
import java.util.List;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findByGender(String gender); // select d from doctor d where gender d.gender = :gender
}
