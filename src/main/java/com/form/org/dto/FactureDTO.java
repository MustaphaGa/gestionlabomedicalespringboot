package com.form.org.dto;

import java.math.BigDecimal;

import java.time.Instant;

import com.form.org.model.Facture;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FactureDTO {

	private Integer idFacture;
	private Instant dateFacture;
	private BigDecimal montant;

	private AnalyseMedicalDTO analyseMedical;

public static FactureDTO fromEntity(Facture facture) {
		if (facture == null) {
			return null;
		}
		return FactureDTO.builder()

				.idFacture(facture.getIdFacture())
				.dateFacture(facture.getDateFacture())
				.montant(facture.getMontant())
				
				.analyseMedical(AnalyseMedicalDTO.fromEntity(facture.getAnalyseMedical()))

				.build();
	}

public static Facture toEntity(FactureDTO factureDTO) {

		if (factureDTO == null) {
			return null;
		}

		Facture facture = new Facture();

		facture.setIdFacture(factureDTO.getIdFacture());
		facture.setDateFacture(factureDTO.getDateFacture());
		facture.setMontant(factureDTO.getMontant());

		return facture;
	}

}
