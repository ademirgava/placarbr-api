package com.br.placarbr_api.domain.dto;

import jakarta.validation.constraints.NotNull;

public record CampeonatoFaseReordenarItemDTO(
		@NotNull
		Long campeonatoFaseId,
		@NotNull
		int ordem
		) {

}
