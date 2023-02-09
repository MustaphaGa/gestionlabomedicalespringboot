package com.form.org.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Profil;
import com.form.org.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurDTO {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String password;
	private String sexe;
	private String telephone;
	
	@JsonIgnore
	private List<Profil> profils;
	
	public static UtilisateurDTO fromEntity(Utilisateur utilisateur) {
		if (utilisateur == null) {
			return null;
		}
		return UtilisateurDTO.builder()

				.id(utilisateur.getId())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.email(utilisateur.getEmail())
				.login(utilisateur.getLogin())
				.password(utilisateur.getPassword())
				.sexe(utilisateur.getSexe())
				.telephone(utilisateur.getTelephone())
				.build();
	}

public static Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {

		if (utilisateurDTO == null) {
			return null;
		}

		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setId(utilisateurDTO.getId());
		utilisateur.setNom(utilisateurDTO.getNom());
		utilisateur.setPrenom(utilisateurDTO.getPrenom());
		utilisateur.setEmail(utilisateurDTO.getEmail());
		utilisateur.setLogin(utilisateurDTO.getLogin());
		utilisateur.setPassword(utilisateurDTO.getPassword());
		utilisateur.setSexe(utilisateurDTO.getSexe());
		utilisateur.setTelephone(utilisateurDTO.getTelephone());

		return utilisateur;
	}

}
