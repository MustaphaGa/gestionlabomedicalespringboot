package com.form.org.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Reservation")

public class Reservation {
	
	@Id
    @GeneratedValue
	@Column(name="idReservation")
	private Integer  idReservation;
	
	@Column(name="dateReservation")
	private Instant dateReservation;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="idPatient")
	private Patient patient;
	
	@OneToMany(mappedBy="reservation")
	private List<AnalyseMedical> analyseMedicals;
	
	

}
