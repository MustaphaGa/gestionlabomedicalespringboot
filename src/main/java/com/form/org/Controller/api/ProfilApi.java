package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;


import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.form.org.dto.ProfilDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT +"/profils")
public interface ProfilApi {
	
	@PostMapping(value= APP_ROOT + "/profils/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	  @ApiOperation(value = "Enregistrer un profil",notes ="Cette methode permet "
		+ "d'enregistrer ou modifier un profil ", response = ProfilDTO.class)
		@ApiResponses(value = {
		@ApiResponse(code = 2000, message = "l'objet profil cree / modifie")	
				})
	ProfilDTO save(ProfilDTO dto);
	
	@GetMapping(value= APP_ROOT + "/profils/{idProfil}", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "rechercher un profil par ID",notes = "Cette methode permet"
		+ " de rechercher  un profil par son ID ",response = ProfilDTO.class)
		@ApiResponses(value = {
		 @ApiResponse(code = 2000, message = "la profil a ete trouver dans la BDD"),	
		 @ApiResponse(code = 404, message = "Aucun profil n'existe  dans la BDD avec l'ID fourni")	
				})
	ProfilDTO findById(Integer idProfil);
	
	@GetMapping(value= APP_ROOT + "/profils/all", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "renvoi la liste de profil",notes = "Cette methode permet"
			 + " de rechercher et renvoyer la listes des profils qui existent dans la BDD",
			 responseContainer = "List<ProfilDTO>")
			@ApiResponses(value = {
			 @ApiResponse(code = 2000, message = "la liste des biologiste / une liste vide"),		
					})
	List<ProfilDTO>findAll(); 
	
	@DeleteMapping(value =APP_ROOT + "profils/delete/{idProfil}" )
	  @ApiOperation(value = "supprimer  un profil ",notes = "Cette methode permet de supprimer"
			     + " un profil par ID ",
			 	 response = ProfilDTO.class)
			 	  @ApiResponses(value = {
			 	  @ApiResponse(code = 2000, message = "profil a ete supprimer"),	
			 		})
	void delete(Integer idProfil);

}
