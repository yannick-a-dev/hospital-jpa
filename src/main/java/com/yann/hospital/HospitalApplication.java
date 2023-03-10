package com.yann.hospital;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yann.hospital.entity.Consultation;
import com.yann.hospital.entity.Medecin;
import com.yann.hospital.entity.Patient;
import com.yann.hospital.entity.Rendezvous;
import com.yann.hospital.entity.StatusRDV;
import com.yann.hospital.repository.MedecinRepository;
import com.yann.hospital.repository.PatientRepository;
import com.yann.hospital.repository.RendezvousRepository;
import com.yann.hospital.service.IHospitalService;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService iHospitalService,
			PatientRepository patientRepository, RendezvousRepository rendezvousRepository, MedecinRepository medecinRepository) {
		return args -> {
			
			Stream.of("Essola","Azegue","Nouma").forEach(name -> {
				  Patient patient = new Patient();
		           patient.setNom(name);
		           patient.setDateNaissance(new Date());
		           patient.setMalade(false);
		           iHospitalService.savePatient(patient);
			});
			
			Stream.of("Ntsama","Eloundou","Ngamesi").forEach(name -> {
				  Medecin medecin = new Medecin();
				  medecin.setNom(name);
				  medecin.setEmail(name+"@gmail.com");
				  medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				  iHospitalService.saveMedecin(medecin);
			});
			
			Patient patient = patientRepository.findById(1L).orElse(null);
			
			Medecin medecin = medecinRepository.findByNom("Ngamesi");
			
			Rendezvous rendezvous = new Rendezvous();
			rendezvous.setDate(new Date());
			rendezvous.setStatus(StatusRDV.PENDING);
			rendezvous.setMedecin(medecin);
			rendezvous.setPatient(patient);
			Rendezvous saveDRDV = iHospitalService.saveRDV(rendezvous);
			System.out.println(saveDRDV.getId());
			
			Rendezvous rendezvous1 = rendezvousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezvous(rendezvous1);
			consultation.setRapport("Rapport de la consultation...");
		    iHospitalService.saveConsultation(consultation);
		};	
	}

}
