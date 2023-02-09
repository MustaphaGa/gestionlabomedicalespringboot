package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.form.org.dto.TypeAnalyseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT +"/typeAnalyse")
public interface TypeAnalyseApi {
	
	 @PostMapping(value= APP_ROOT + "/typeAnalyse/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "Enregistrer un typeAnalyse",notes ="Cette methode permet "
		+ "d'enregistrer ou modifier un typeAnalyse ", response = TypeAnalyseDTO.class)
	  @ApiResponses(value = {
	  @ApiResponse(code = 2000, message = "l'objet typeAnalyse cree / modifie")	
				})
	 TypeAnalyseDTO save(TypeAnalyseDTO dto);
	 
	 @GetMapping(value= APP_ROOT + "/typeAnalyse/{idTypeAnalyse}", produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "rechercher un typeAnalyse par ID",notes = "Cette methode permet"
				+ " de rechercher  un typeAnalyse par son ID ",response = TypeAnalyseDTO.class)
				@ApiResponses(value = {
				 @ApiResponse(code = 2000, message = "la typeAnalyse a ete trouver dans la BDD"),	
				 @ApiResponse(code = 404, message = "Aucun typeAnalyse n'existe  dans la BDD avec l'ID fourni")	
					})
	 TypeAnalyseDTO findById(Integer idTypeAnalyse);
	 
	 @GetMapping(value= APP_ROOT + "/typeAnalyse/{typeAnalyse}", produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "rechercher un typeAnalyse par TYPEANALYSE",notes = "Cette methode"
			 + " permet de rechercher un typeAnalyse par son TYPEANALYSE ",
			 response = TypeAnalyseDTO.class)
				@ApiResponses(value = {
				 @ApiResponse(code = 2000, message = "la typeAnalyse a ete trouver dans la BDD"),	
				 @ApiResponse(code = 404, message = "Aucun typeAnalyse n'existe  dans la BDD avec le CODE fourni")	
					})
	 TypeAnalyseDTO findByTypeAnalyse(String typeAnalyse);
	 
	 @GetMapping(value= APP_ROOT + "/typeAnalyse/all", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value = "renvoi la liste de typeAnalyse",notes = "Cette methode permet"
			 + " de rechercher et renvoyer la listes des typeAnalyses qui existent dans la BDD",
			 responseContainer = "List<TypeAnalyseDTO>")
			@ApiResponses(value = {
			 @ApiResponse(code = 2000, message = "la liste des typeAnalyse / une liste vide"),		
					})
	 List<TypeAnalyseDTO>findAll(); 
	 
	 @DeleteMapping(value =APP_ROOT + "typeAnalyse/delete/{idTypeAnalyse}" )
	 @ApiOperation(value = "supprimer  un typeAnalyse ",notes = "Cette methode permet de supprimer"
		     + " un typeAnalyse par ID ",
		 	 response = TypeAnalyseDTO.class)
		 	  @ApiResponses(value = {
		 	  @ApiResponse(code = 2000, message = "typeAnalyse a ete supprimer"),	
		 		})
	 void delecte(Integer idTypeAnalyse);

}
