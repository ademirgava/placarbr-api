package com.br.placarbr_api.domain.dto;

import jakarta.validation.constraints.NotNull;

public record CampeonatoEquipeCadastraDTO(
		@NotNull
		Long campeonatoId, 
		@NotNull
		Long equipeId, 
		@NotNull
		Long campeonatoFaseId) {

}
