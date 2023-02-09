package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.form.org.dto.PreleveurDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT +"/preleveurs")
public interface PreleveurApi {
	
	@PostMapping(value= APP_ROOT + "/preleveurs/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "Enregistrer un preleveur",notes ="Cette methode permet "
		 + "d'enregistrer ou modifier un preleveur ", response = PreleveurDTO.class)
		@ApiResponses(value = {
		@ApiResponse(code = 2000, message = "l'objet preleveur cree / modifie")	
				})
	PreleveurDTO save(PreleveurDTO dto);
	
	@GetMapping(value= APP_ROOT + "/preleveurs/{idPreleveur}", produces = MediaType.APPLICATION_JSON_VALUE )
	
	@ApiOperation(value = "rechercher un preleveur par ID",notes = "Cette methode permet"
			+ " de rechercher  un preleveur par son ID ",response = PreleveurDTO.class)
			@ApiResponses(value = {
			 @ApiResponse(code = 2000, message = "la preleveur a ete trouver dans la BDD"),	
			 @ApiResponse(code = 404, message = "Aucun preleveur n'existe  dans la BDD avec l'ID fourni")	
				})
	PreleveurDTO findById(Integer id);
	
	@GetMapping(value= APP_ROOT + "/preleveurs/{specialite}", produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "rechercher un preleveur par SPECIALITE",notes = "Cette methode"
			 + " permet de rechercher un preleveur par son SPECIALITE ",
			 response = PreleveurDTO.class)
				@ApiResponses(value = {
				 @ApiResponse(code = 2000, message = "la biologiste a ete trouver dans la BDD"),	
				 @ApiResponse(code = 404, message = "Aucun biologiste n'existe  dans la BDD avec le CODE fourni")	
					})
	PreleveurDTO findBySpecialite(String specialite);
	
	@GetMapping(value= APP_ROOT + "/preleveurs/all", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "renvoi la liste de preleveur",notes = "Cette methode permet"
			 + " de rechercher et renvoyer la listes des preleveurs qui existent dans la BDD",
			 responseContainer = "List<PreleveurDTO>")
			@ApiResponses(value = {
			 @ApiResponse(code = 2000, message = "la liste des preleveur / une liste vide"),		
					})
	List<PreleveurDTO>findAll(); 
	
	@DeleteMapping(value =APP_ROOT + "preleveurs/delete/{idPreleveur}" )
	@ApiOperation(value = "supprimer  un preleveur ",notes = "Cette methode permet de supprimer"
		     + " un preleveur par ID ",
		 	 response = PreleveurDTO.class)
		 	  @ApiResponses(value = {
		 	  @ApiResponse(code = 2000, message = "preleveur a ete supprimer"),	
		 		})
	void delete(Integer id);

}
