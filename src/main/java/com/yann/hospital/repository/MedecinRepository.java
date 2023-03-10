package com.yann.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yann.hospital.entity.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

	Medecin findByNom(String nom);
}
