package com.yann.hospital.service;

import com.yann.hospital.entity.Consultation;
import com.yann.hospital.entity.Medecin;
import com.yann.hospital.entity.Patient;
import com.yann.hospital.entity.Rendezvous;

public interface IHospitalService {

	public Patient savePatient(Patient patient);
	Medecin saveMedecin(Medecin medecin);
	Rendezvous saveRDV(Rendezvous rendezvous);
	Consultation saveConsultation(Consultation consultation);
}
