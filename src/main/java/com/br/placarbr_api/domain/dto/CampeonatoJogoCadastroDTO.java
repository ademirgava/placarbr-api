package com.br.placarbr_api.domain.dto;

import jakarta.validation.constraints.NotNull;

public record CampeonatoJogoCadastroDTO(
		@NotNull
		Long campeonatoId,
		@NotNull
		Long cameponatoTimeVisitanteId, 
		@NotNull
		Long cameponatoTimeMandateId, 
		@NotNull
		Integer rodada, 
		@NotNull
		Long campeonatoFaseId) {

}
