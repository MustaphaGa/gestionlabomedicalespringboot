package com.form.org.Services;

import java.util.List;

import com.form.org.dto.PatientDTO;

public interface PatientSecvice {
	
    PatientDTO save(PatientDTO dto);
	
	PatientDTO findById(Integer id);
	
	PatientDTO findByCodePatient(String codePatient);
	
	List<PatientDTO>findAll(); 
	
	void delete(Integer id);

	
	

}
