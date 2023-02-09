package com.form.org.model;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="Preleveur")
public class Preleveur extends Utilisateur{


	private static final long serialVersionUID = 1L;

	@Column(name="specialite")
	private String specialite;
	
	@ManyToOne
	@JoinColumn(name="idAnalyseMedical")
	private AnalyseMedical analyseMedical;
	
	
	
	

}
