package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.TipoFase;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CampeonatoFaseCadastroDTO(
		@NotNull
		Long campeonatoId,
		@NotBlank
		@Size(min = 2, max = 70)
		String nome,
		String descricao,
		@NotNull
		TipoFase tipoFase,
		@NotNull
		Integer ordemFase,
		Integer classificados,
		Integer quantidadeGrupos,
		@NotNull
		Integer quantidadeTimes,
		@NotNull
		Boolean idaVolta
		) {

}
