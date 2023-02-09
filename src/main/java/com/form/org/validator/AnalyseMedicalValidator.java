package com.form.org.validator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
import com.form.org.dto.AnalyseMedicalDTO;

public class AnalyseMedicalValidator {
	
	public static List<String> validate(AnalyseMedicalDTO analyseMedicalDTO){
		List<String> errors = new ArrayList<String>();
		
		if(analyseMedicalDTO == null) {
			errors.add("veuillez renseigner la date d'analyse!!");
			errors.add("veuillez renseigner la description !!");
			errors.add("veuillez renseigner la prix d'analyse !!");
			errors.add("veuillez renseigner le  type d'analyse !!");
		    errors.add("veuillez renseigner la reservation !!");
			errors.add("veuillez renseigner la  facture !!");
			
			return errors;
		}
		
		 if(analyseMedicalDTO.getDateAnalyse()==null) {
			  errors.add("veuillez renseigner la date d'analyse!!");;
		 }
		
		  if(!StringUtils.hasLength(analyseMedicalDTO.getDescriprtion())) {
			  errors.add("veuillez renseigner la description !!");
			}
		  
		  if(analyseMedicalDTO.getPrixAnalyse()==null) {
			  errors.add("veuillez renseigner le  prix d'analyse !!");
			}
		  
		  if(analyseMedicalDTO.getTypeAnalyse()==null) {
			  errors.add("veuillez renseigner le  type d'analyse !!");
			}
		  
		  if(analyseMedicalDTO.getReservation()==null) {
			  errors.add("veuillez renseigner la reservation !!");
			}
		  
		  if(analyseMedicalDTO.getFacture()==null) {
			  errors.add("veuillez renseigner la  facture !!");
			}
		  
		  
		  
		 
		  return errors;
	}
}
