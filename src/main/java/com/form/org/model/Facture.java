package com.form.org.model;
import java.math.BigDecimal;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Facture")

  public class Facture  {
	
	@Id
    @GeneratedValue
	@Column(name="idFacture")
	private Integer idFacture;
	
	@Column(name="dateFacture")
	private Instant dateFacture;
	
	@Column(name="montant")
	private BigDecimal montant;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name ="idAnalyseMedical")
	private AnalyseMedical analyseMedical;
	
	
	
}
