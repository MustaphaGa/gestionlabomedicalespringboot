package com.form.org.Services.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.form.org.Repository.UtilisateurRepository;
import com.form.org.Services.UtilisateurService;
import com.form.org.dto.UtilisateurDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Utilisateur;
import com.form.org.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class UtilisateurServiceImp implements UtilisateurService {

	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	public UtilisateurServiceImp(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository= utilisateurRepository;
	}
	
	@Override
	public UtilisateurDTO save(UtilisateurDTO dto) {
		List<String> errors= UtilisateurValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("l'utilisateur n'est pas valide {}",dto);
			throw new InvalidEntityException("l'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
		}
		return UtilisateurDTO.fromEntity(
			utilisateurRepository.save(
			UtilisateurDTO.toEntity(dto)));
	}

	@Override
	public UtilisateurDTO findById(Integer id) {
		if(id == null) {	
			log.error("utilisateur id is null");
			return null;
		}
		Optional<Utilisateur> utilisateur=utilisateurRepository.findById(id);
		
		return Optional.of(UtilisateurDTO.fromEntity(utilisateur.get())).orElseThrow(() ->
		       new EntityNotFoundException(
				"Aucun utilisateur avec l'ID ="+ id +"n'été trouve dans la BDD",
				ErrorCodes.UTILISATEUR_NOT_FOUND)
		);
	}

	@Override
	public List<UtilisateurDTO> findAll() {
		return utilisateurRepository.findAll().stream()
				.map(UtilisateurDTO :: fromEntity)
				.collect(Collectors.toList());
	}
	@Override
	public void delete(Integer id) {
		if(id == null) {	
			log.error(" utilisateur id is null");
			return ;
		}
		utilisateurRepository.deleteById(id);
		
	}
	
	 UtilisateurDTO fromEntity(Utilisateur dto) {
	    return UtilisateurDTO.builder()
	        .password(generateRandomPassword())
	        .build();
	  }
	
	private String generateRandomPassword() {
	    return "som3R@nd0mP@$$word";
	  }

	@Override
	public UtilisateurDTO findByEmail(String email) {
		
		return utilisateurRepository.findUtilisateurByEmail(email)
				.map(UtilisateurDTO :: fromEntity)
				.orElseThrow(()-> new EntityNotFoundException(
						"Aucun utilisateur avecl'email="+email+"n'ete trouve dans la BDD", 
						ErrorCodes.UTILISATEUR_NOT_FOUND)
				);
	}
	

}
