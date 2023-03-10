package com.yann.hospital.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Rendezvous {

	@Id
	private String id;
	private Date date;
	@Enumerated(EnumType.STRING)
	private StatusRDV status;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Patient patient;
	@ManyToOne
	private Medecin medecin;
	@OneToOne(mappedBy = "rendezvous")
	private Consultation consultation;
}
