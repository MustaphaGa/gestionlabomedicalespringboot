package com.form.org.Services;

import java.util.List;

import com.form.org.dto.PreleveurDTO;

public interface PreleveurService {

	PreleveurDTO save(PreleveurDTO dto);
		
	PreleveurDTO findById(Integer id);
		
	PreleveurDTO findBySpecialite(String specialite);
		
	List<PreleveurDTO>findAll(); 
		
    void delete(Integer id);

}
