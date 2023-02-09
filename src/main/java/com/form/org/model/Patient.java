package com.form.org.model;

import java.time.Instant;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="Patient")

public class Patient extends Utilisateur{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "codePatient")
	private String codePatient;
	
	@Column(name = "cni")
	private String cni;
	
	@Column(name = "dateNaissance")
	private Instant dateNaissance;
	
	@Column(name = "adressse")
	private String adressse;
	
	@OneToMany(mappedBy="patient")
	private List<Reservation> reservations;

}
