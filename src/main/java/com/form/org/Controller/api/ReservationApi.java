package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;
import java.time.Instant;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.form.org.dto.ReservationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT +"/reservations")
public interface ReservationApi {

	@PostMapping(value= APP_ROOT + "/reservations/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	  @ApiOperation(value = "Enregistrer un reservation",notes ="Cette methode permet "
			    + "d'enregistrer ou modifier un reservation ", response = ReservationDTO.class)
				@ApiResponses(value = {
				@ApiResponse(code = 2000, message = "l'objet reservation cree / modifie")	
				})
	ReservationDTO save(ReservationDTO dto);
	
	@GetMapping(value= APP_ROOT + "/reservations/{idReservation}", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "rechercher un reservation par ID",notes = "Cette methode permet"
			+ " de rechercher  un reservation par son ID ",response = ReservationDTO.class)
			@ApiResponses(value = {
			 @ApiResponse(code = 2000, message = "la reservation a ete trouver dans la BDD"),	
			 @ApiResponse(code = 404, message = "Aucun reservation n'existe  dans la BDD avec l'ID fourni")	
				})
	ReservationDTO findById(Integer idReservation);
	
	@GetMapping(value= APP_ROOT + "/reservations/{dateReservation}", produces = MediaType.APPLICATION_JSON_VALUE )	
	 @ApiOperation(value = "rechercher un reservation par date de Reservation",notes = "Cette methode"
			 + " permet de rechercher un reservation par date de Reservation  ",
			 response = ReservationDTO.class)
				@ApiResponses(value = {
				 @ApiResponse(code = 2000, message = "la reservation a ete trouver dans la BDD"),	
				 @ApiResponse(code = 404, message = "Aucun reservation n'existe  dans la BDD avec le CODE fourni")	
					})
	ReservationDTO findByDateReservation(Instant dateReservation);
		
	@GetMapping(value= APP_ROOT + "/reservations/all", produces = MediaType.APPLICATION_JSON_VALUE )
	
	@ApiOperation(value = "renvoi la liste de biologiste",notes = "Cette methode permet"
			 + " de rechercher et renvoyer la listes des reservation qui existent dans la BDD",
			 responseContainer = "List<ReservationDTO>")
			@ApiResponses(value = {
			 @ApiResponse(code = 2000, message = "la liste des reservation / une liste vide"),		
					})
	List<ReservationDTO>findAll(); 
	
	@DeleteMapping(value =APP_ROOT + "reservations/delete/{idReservation}" )
	 @ApiOperation(value = "supprimer  un reservation ",notes = "Cette methode permet de supprimer"
		     + " un reservation par ID ",
		 	 response = ReservationDTO.class)
		 	  @ApiResponses(value = {
		 	  @ApiResponse(code = 2000, message = "reservation a ete supprimer"),	
		 		})
	void delete(Integer idReservation);
}
