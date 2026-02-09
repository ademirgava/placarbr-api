package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.TipoFase;

import jakarta.validation.constraints.NotNull;

public record CampeonatoFaseAtualizaDTO(
		@NotNull
		Long id, 
		String nome,
		String descricao,
		TipoFase fase,
		Integer classificados,
		Integer quantidadeGrupos,
		Integer quantidadeTimes,
		Boolean idaVolta) {

}
