package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.form.org.dto.BiologisteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT +"/biologistes")
public interface BiologisteApi {
	
	@PostMapping(value= APP_ROOT + "/biologistes/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	
    @ApiOperation(value = "Enregistrer un biologiste",notes ="Cette methode permet "
    + "d'enregistrer ou modifier un biologiste ", response = BiologisteDTO.class)
	@ApiResponses(value = {
	@ApiResponse(code = 2000, message = "l'objet biologiste cree / modifie")	
	})
	
	BiologisteDTO save(@RequestBody BiologisteDTO dto);
		
	@GetMapping(value= APP_ROOT + "/biologistes/{idBiologiste}", produces = MediaType.APPLICATION_JSON_VALUE )
	
	@ApiOperation(value = "rechercher un biologiste par ID",notes = "Cette methode permet"
	+ " de rechercher  un biologiste par son ID ",response = BiologisteDTO.class)
	@ApiResponses(value = {
	 @ApiResponse(code = 2000, message = "la biologiste a ete trouver dans la BDD"),	
	 @ApiResponse(code = 404, message = "Aucun biologiste n'existe  dans la BDD avec l'ID fourni")	
		})
	
	 BiologisteDTO findById(@PathVariable("idBiologiste") Integer id);
	
	 @GetMapping(value= APP_ROOT + "/biologistes/{codeBiologiste}", produces = MediaType.APPLICATION_JSON_VALUE )	
	 
	 @ApiOperation(value = "rechercher un biologiste par CODE",notes = "Cette methode"
	 + " permet de rechercher un biologiste par son CODE ",
	 response = BiologisteDTO.class)
		@ApiResponses(value = {
		 @ApiResponse(code = 2000, message = "la biologiste a ete trouver dans la BDD"),	
		 @ApiResponse(code = 404, message = "Aucun biologiste n'existe  dans la BDD avec le CODE fourni")	
			})
	 BiologisteDTO findByCodeBiologiste(@PathVariable("codeBiologiste") String codeBiologiste); 
		
	@GetMapping(value= APP_ROOT + "/biologistes/all", produces = MediaType.APPLICATION_JSON_VALUE )
	 
	@ApiOperation(value = "renvoi la liste de biologiste",notes = "Cette methode permet"
	 + " de rechercher et renvoyer la listes des biologistes qui existent dans la BDD",
	 responseContainer = "List<BiologisteDTO>")
	@ApiResponses(value = {
	 @ApiResponse(code = 2000, message = "la liste des biologiste / une liste vide"),		
			})
	 List<BiologisteDTO>findAll(); 
		
     @DeleteMapping(value =APP_ROOT + "biologistes/delete/{idBiologiste}" )
     
     @ApiOperation(value = "supprimer  un biologiste ",notes = "Cette methode permet de supprimer"
     + " un biologiste par ID ",
 	 response = BiologisteDTO.class)
 	  @ApiResponses(value = {
 	  @ApiResponse(code = 2000, message = "biologiste a ete supprimer"),	
 		})
	 void delecte(@PathVariable("idBiologiste") Integer id);

}
