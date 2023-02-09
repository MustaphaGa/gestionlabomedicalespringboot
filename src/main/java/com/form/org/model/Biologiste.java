package com.form.org.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Biologiste")

public class Biologiste extends Utilisateur {
	private static final long serialVersionUID = 1L;

	@Column(name ="codeBiologiste")
	private String codeBiologiste;
	
	@Column(name = "service")
	private String service;

	@OneToMany(mappedBy="biologiste")
	private List<DetailResultat> detailResultats;

	@ManyToOne
	@JoinColumn(name="idDepartement")
	private Departement departement;

}
