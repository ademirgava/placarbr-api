package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.model.Campeonato;

public record CampeonatoListagemDTO(Long id, String nome, LocalDate dataInicio) {
	public CampeonatoListagemDTO(Campeonato campeonato) {
		this(campeonato.getId(), campeonato.getNome(), campeonato.getDataInicio());
	}
}
