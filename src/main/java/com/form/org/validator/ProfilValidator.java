package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.form.org.dto.ProfilDTO;

public class ProfilValidator {
	
	public static List<String>validate(ProfilDTO profilDTO){
		List<String> errors = new ArrayList<String>();
		
		if(profilDTO == null) {
			
		  errors.add("veuillez renseigner le nom de profil!!");
		  errors.add("veuillez renseigner le droit de profil!!");
		  errors.add("veuillez renseigner l'utilisateur!!");
		  
		  return errors;	
		}
		
		  if(!StringUtils.hasLength(profilDTO.getNomProfil())) {
        	  errors.add("veuillez renseigner le nom de preleveur!!");
		}
		  
		  if(!StringUtils.hasLength(profilDTO.getDroit())) {
        	  errors.add("veuillez renseigner le nom de preleveur!!");
		}
		  
		  if(profilDTO.getUtilisateur()==null) {
			 errors.add("veuillez renseigner l'utilisateur!!");
			}
		 return errors;
	}

}
