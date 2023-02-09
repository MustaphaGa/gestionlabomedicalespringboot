package com.form.org.model;


import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="typeAnalyse")

public class TypeAnalyse  {
	
	@Id
    @GeneratedValue
	@Column(name="idTypeAnalyse")
	private Integer idTypeAnalyse;

	@Column(name="typeAnalyse")
	private String typeAnalyse;
	
	
	@OneToMany(mappedBy="typeAnalyse")
	private List<AnalyseMedical> analyseMedicals;
}