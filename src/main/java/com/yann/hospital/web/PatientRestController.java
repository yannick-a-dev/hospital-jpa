package com.yann.hospital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yann.hospital.entity.Patient;
import com.yann.hospital.repository.PatientRepository;

@RestController
public class PatientRestController {

	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping("/patients")
	public List<Patient> patientList(){
		return patientRepository.findAll();
		
	}
}
