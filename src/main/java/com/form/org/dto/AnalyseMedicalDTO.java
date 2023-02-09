package com.form.org.dto;

import java.math.BigDecimal;
import java.time.Instant;
import com.form.org.model.AnalyseMedical;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AnalyseMedicalDTO {
	
	private Integer idAnalyse;
	private Instant dateAnalyse;
	private String descriprtion;
	private BigDecimal prixAnalyse;
	private Boolean resultat;
	
	private TypeAnalyseDTO typeAnalyse;
	private ReservationDTO reservation;
	private FactureDTO facture;
	

	
	   public static AnalyseMedicalDTO fromEntity(AnalyseMedical analyseMedical) {
		if(analyseMedical == null) {
			return null;
		}
		return   AnalyseMedicalDTO.builder()
				.idAnalyse(analyseMedical.getIdAnalyse())
				.dateAnalyse(analyseMedical.getDateAnalyse())
				.descriprtion(analyseMedical.getDescription())
				.prixAnalyse(analyseMedical.getPrixAnalyse())
				.resultat(analyseMedical.getResultat())
				.typeAnalyse(TypeAnalyseDTO.fromEntity(analyseMedical.getTypeAnalyse()))
				.reservation(ReservationDTO.fromEntity(analyseMedical.getReservation()))
				.facture(FactureDTO.fromEntity(analyseMedical.getFacture()))
				.build();
	}
	
	
	    public static AnalyseMedical toEntity(AnalyseMedicalDTO analyseMedicalDTO) {
		
		if(analyseMedicalDTO== null) {
			return null;
		
		}		
		AnalyseMedical analyseMedical = new AnalyseMedical();
		
		analyseMedical.setIdAnalyse(analyseMedicalDTO.getIdAnalyse());
		analyseMedical.setDateAnalyse(analyseMedicalDTO.getDateAnalyse());
		analyseMedical.setDescription(analyseMedicalDTO.getDescriprtion());
		analyseMedical.setPrixAnalyse(analyseMedicalDTO.getPrixAnalyse());
		analyseMedical.setResultat(analyseMedicalDTO.getResultat());
		
		
		return analyseMedical;
	}
	
}
