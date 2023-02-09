package com.form.org.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Patient;
import com.form.org.model.Reservation;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class PatientDTO {
	
	
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
    private String login;
	private String password;
	private String sexe;
	private String telephone;
	
	private String codePatient;
	private String cni;
	private Instant dateNaissance;
	private String adressse;
	
	@JsonIgnore
	private List<Reservation> reservations;
	
	
public static PatientDTO fromEntity(Patient patient) {
		
	if(patient == null) {
		return null;
		}
		return
		    		PatientDTO.builder()
		    		.id(patient.getId())
		    		.nom(patient.getNom())
		    		.prenom(patient.getPrenom())
		    		.email(patient.getEmail())
		    		.login(patient.getLogin())
		    		.password(patient.getPassword())
		    		.sexe(patient.getSexe())
		            .telephone(patient.getTelephone())
		            
                    .codePatient(patient.getCodePatient())
                    .cni(patient.getCni())
                    .dateNaissance(patient.getDateNaissance())
		    		.adressse(patient.getAdressse())
		    		.build();
	}
	
	 public static Patient toEntity(PatientDTO patientdto) {
		 
		 if(patientdto == null) {
			 return null;
		 }
		 
		 Patient patient = new Patient();
		 patient.setId(patientdto.getId());
		 patient.setNom(patientdto.getNom());
		 patient.setPrenom(patientdto.getPrenom());
		 patient.setEmail(patientdto.getEmail());
		 patient.setLogin(patientdto.getLogin());
		 patient.setPassword(patientdto.getPassword());
		 patient.setSexe(patientdto.getSexe());
		 patient.setTelephone(patientdto.getTelephone());
		 
		 patient.setCodePatient(patientdto.getCodePatient());
		 patient.setCni(patientdto.getCni());
		 patient.setDateNaissance(patientdto.getDateNaissance());
		 patient.setAdressse(patientdto.getAdressse());
		 
		     return patient;
		 
	 }
	 

}
