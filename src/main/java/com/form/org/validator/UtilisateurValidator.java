package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.form.org.dto.UtilisateurDTO;

public class UtilisateurValidator {

	
	public static List<String> validate(UtilisateurDTO utilisateurDTO){
		List<String> errors = new ArrayList<String>();
		
		if(utilisateurDTO == null) {
			errors.add("veuillez renseigner le nom de utilisateur!!");
			errors.add("veuillez renseigner le prénom de utilisateur !!");
			errors.add("veuillez renseigner l'email de utilisateur !!");
			errors.add("veuillez renseigner login de utilisateur !!");
			errors.add("veuillez renseigner password de utilisateur !!");
			errors.add("veuillez renseigner le sexe de utilisateur !!");
			errors.add("veuillez renseigner le telephone de utilisateur !!");
			
			return errors;
		}
		
		  if(!StringUtils.hasLength(utilisateurDTO.getNom())) {
			  errors.add("veuillez renseigner le nom de utilisateur!!");
			}
		  if(!StringUtils.hasLength(utilisateurDTO.getPrenom())) {
			  errors.add("veuillez renseigner le prénom de utilisateur !!");
			}
		  if(!StringUtils.hasLength(utilisateurDTO.getEmail())) {
			  errors.add("veuillez renseigner l'email de utilisateur !!");
			}
		  if(!StringUtils.hasLength(utilisateurDTO.getLogin())) {
			  errors.add("veuillez renseigner login de utilisateur !!");
			}
		  if(!StringUtils.hasLength(utilisateurDTO.getPassword())) {
			  errors.add("veuillez renseigner password de utilisateur !!");
			}
		  if(!StringUtils.hasLength(utilisateurDTO.getSexe())) {
			  errors.add("veuillez renseigner le sexe de utilisateur !!");
			}
		  if(!StringUtils.hasLength(utilisateurDTO.getTelephone())) {
			  errors.add("veuillez renseigner le telephone de utilisateur !!");
			}
		  	
		return errors;
	}
}
