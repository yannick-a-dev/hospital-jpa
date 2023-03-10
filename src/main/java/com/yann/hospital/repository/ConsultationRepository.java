package com.yann.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yann.hospital.entity.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
