package com.form.org.dto;
import java.util.List;
import com.form.org.model.Biologiste;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BiologisteDTO {

	private Integer id;
	private String nom;
	private String prenom;
	private String email;
    private String login;
	private String password;
	private String sexe;
	private String telephone;

	private String codeBiologiste;
	private String service;
	
	
	private List<DetailResultatDTO> detailResultats;
	private DepartementDTO departement;
	
public static BiologisteDTO fromEntity(Biologiste biologiste) {
		if(biologiste == null) {
		return null;
		}
		return  
				BiologisteDTO.builder()
				.id(biologiste.getId())
	    		.nom(biologiste.getNom())
	    		.prenom(biologiste.getPrenom())
	    		.email(biologiste.getEmail())
	    		.login(biologiste.getLogin())
	    		.password(biologiste.getPassword())
	    		.sexe(biologiste.getSexe())
	            .telephone(biologiste.getTelephone())
	            .codeBiologiste(biologiste.getCodeBiologiste())
	            .service(biologiste.getService())
	            .departement(DepartementDTO.fromEntity(biologiste.getDepartement()))
				.build();
	}		
	
	
public static Biologiste toEntity(BiologisteDTO biologisteDTO) {
		if(biologisteDTO == null  ) {
			return null ;
		}
		Biologiste biologiste = new Biologiste();
		
		biologiste.setId(biologisteDTO.getId());
		biologiste.setNom(biologisteDTO.getNom());
		biologiste.setPrenom(biologisteDTO.getPrenom());
		biologiste.setEmail(biologisteDTO.getEmail());
		biologiste.setLogin(biologisteDTO.getLogin());
		biologiste.setPassword(biologisteDTO.getPassword());
		biologiste.setSexe(biologisteDTO.getSexe());
		biologiste.setTelephone(biologisteDTO.getTelephone());
		
	
		
		
		return biologiste;
	}
}
