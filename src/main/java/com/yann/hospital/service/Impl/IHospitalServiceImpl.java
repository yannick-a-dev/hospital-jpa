package com.yann.hospital.service.Impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.yann.hospital.entity.Consultation;
import com.yann.hospital.entity.Medecin;
import com.yann.hospital.entity.Patient;
import com.yann.hospital.entity.Rendezvous;
import com.yann.hospital.repository.ConsultationRepository;
import com.yann.hospital.repository.MedecinRepository;
import com.yann.hospital.repository.PatientRepository;
import com.yann.hospital.repository.RendezvousRepository;
import com.yann.hospital.service.IHospitalService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class IHospitalServiceImpl implements IHospitalService{

	private PatientRepository patientRepository;
	private MedecinRepository medecinRepository;
	private ConsultationRepository consultationRepository;
	private RendezvousRepository rendezvousRepository;
	@Override
	public Patient savePatient(Patient patient) {
		
		return patientRepository.save(patient);
	}

	@Override
	public Medecin saveMedecin(Medecin medecin) {
		
		return medecinRepository.save(medecin);
	}

	@Override
	public Rendezvous saveRDV(Rendezvous rendezvous) {
		rendezvous.setId(UUID.randomUUID().toString());
		return rendezvousRepository.save(rendezvous);
	}

	@Override
	public Consultation saveConsultation(Consultation consultation) {
		
		return consultationRepository.save(consultation);
	}

}
