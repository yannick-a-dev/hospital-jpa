package com.yann.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yann.hospital.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findByNom(String nom);
}
