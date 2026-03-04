package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.model.Campeonato;

public record CampeonatoDetalhamentoDTO(Long id, String nome, String descricao, LocalDate dataInicio) {

	public CampeonatoDetalhamentoDTO(Campeonato campeonato) {
		this(campeonato.getId(), campeonato.getNome(), campeonato.getDescricao(), campeonato.getDataInicio());
	}

}
