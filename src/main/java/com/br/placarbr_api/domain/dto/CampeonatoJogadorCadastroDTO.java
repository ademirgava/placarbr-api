package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.TipoPosicaoJogador;

import jakarta.validation.constraints.NotNull;

public record CampeonatoJogadorCadastroDTO(
		@NotNull
		Long jogadorId, 
		@NotNull
		TipoPosicaoJogador posicao, 
		@NotNull
		Long campeonatoTimeId) {

}
