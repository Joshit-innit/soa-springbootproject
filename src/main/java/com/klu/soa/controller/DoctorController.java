package com.klu.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.klu.soa.entity.Doctor;
import com.klu.soa.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	private final DoctorService service;

	DoctorController(DoctorService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String demo() {
		return "orey project pani chesthundhi!!!!!";
	}
	
	@PostMapping("/add")
	public ResponseEntity<Doctor> addoctor(@RequestBody Doctor d) {
		Doctor doctor = service.addDoctor(d);
		return ResponseEntity.status(201).body(doctor);
		
		
	}
	
	@GetMapping("/displayAll")
	public ResponseEntity<List<Doctor>> displayalldoctors() {
		List<Doctor> doctors = service.displayAllDoctors();
		return ResponseEntity.status(200).body(doctors);
	}
	
	// Display doctor by id
	
	@GetMapping("/display")
	public ResponseEntity<?> displayDoctorById(@RequestParam Long id) {
		
		Doctor doctor = service.displayDoctorById(id);
		
		if (doctor != null) {
			return ResponseEntity.status(200).body(doctor);
		}
		return ResponseEntity.status(404).body("Doctor not there");
		
	}
	
	// Update Doctor
		@PutMapping("/update")
		public ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor)
		{
			Doctor d = service.updateDoctor(doctor);

			if (d != null)
			{
				return ResponseEntity.ok(d);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor ID Not Found");
			}
		}

		// Delete Doctor By ID
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteDoctorById(@PathVariable Long id)
		{
			String message = service.deleteDoctorById(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}

		// Display Doctors By Gender
		@GetMapping("/displaybygender/{gender}")
		public ResponseEntity<List<Doctor>> displayDoctorsByGender(@PathVariable String gender)
		{
			List<Doctor> doctors = service.displayDoctorsByGender(gender);
			return ResponseEntity.status(200).body(doctors);
		}
		
		
		//counting doctors
		@GetMapping("/count")
		public ResponseEntity<String> doctorCount() {
			Long count = service.doctorCount();
			String msg = "Total Count : " + count;
			return ResponseEntity.ok(msg);
		}
	
	
}
