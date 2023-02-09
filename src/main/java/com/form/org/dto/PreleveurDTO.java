package com.form.org.dto;



import com.form.org.model.Preleveur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PreleveurDTO {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
    private String login;
	private String password;
	private String sexe;
	private String telephone;
	
	private String specialite;
	
	private AnalyseMedicalDTO analyseMedical;
	

	
	public static PreleveurDTO fromEntity(Preleveur preleveur) {
		if(preleveur == null) {
			return null ;
		}
		    return
				PreleveurDTO.builder()
				.id(preleveur.getId())
	    		.nom(preleveur.getNom())
	    		.prenom(preleveur.getPrenom())
	    		.email(preleveur.getEmail())
	    		.login(preleveur.getLogin())
	    		.password(preleveur.getPassword())
	    		.sexe(preleveur.getSexe())
	            .telephone(preleveur.getTelephone())
				
	            .specialite(preleveur.getSpecialite())
	            .analyseMedical(AnalyseMedicalDTO.fromEntity(preleveur.getAnalyseMedical()))
				.build();
	}

	public static Preleveur toEntity(PreleveurDTO preleveurDTO) {
		
		if(preleveurDTO == null) {
		return null;
		}
		
		Preleveur preleveur = new Preleveur();
		
		preleveur.setId(preleveurDTO.getId());
		preleveur.setNom(preleveurDTO.getNom());
		preleveur.setPrenom(preleveurDTO.getPrenom());
		preleveur.setEmail(preleveurDTO.getEmail());
		preleveur.setLogin(preleveurDTO.getLogin());
		preleveur.setPassword(preleveurDTO.getPassword());
		preleveur.setSexe(preleveurDTO.getSexe());
		preleveur.setTelephone(preleveurDTO.getTelephone());
		
		preleveur.setSpecialite(preleveurDTO.getSpecialite());
		
		return preleveur;
	}
	
}
