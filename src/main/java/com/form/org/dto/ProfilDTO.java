
package com.form.org.dto;

import com.form.org.model.Profil;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ProfilDTO {
	
	private Integer idProfil;
	private String nomProfil;
	private String droit;
	
	private UtilisateurDTO utilisateur;

	
	

 public static ProfilDTO fromEntity(Profil profil) {
	       if(profil == null) {
		   return null;
	   }
	       return ProfilDTO.builder()
	    		   .idProfil(profil.getIdProfil())
	    		   .nomProfil(profil.getNomProfil())
	    		   .droit(profil.getDroit())
	    		   .utilisateur(UtilisateurDTO.fromEntity(profil.getUtilisateur()))
	    		   .build();
	    		   
}
  public static Profil toEntity(ProfilDTO profilDTO) {
    	
    	if(profilDTO == null) {
    		return null;
    	}
    	Profil profil = new Profil();
    	
    	profil.setIdProfil(profilDTO.getIdProfil());
    	profil.setNomProfil(profilDTO.getNomProfil());
    	profil.setDroit(profilDTO.getDroit());
    	
    	    return profil;
    	
    }
}
