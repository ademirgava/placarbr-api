package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;
import java.util.List;

import com.br.placarbr_api.domain.model.Campeonato;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CampeonatoDetalhamentoDTO(Long id, String nome, String descricao, LocalDate dataInicio, @JsonProperty(value = "equipes") List<EquipeListagemDTO> equipeListagemDTOs) {

	public CampeonatoDetalhamentoDTO(Campeonato campeonato) {
		this(campeonato.getId(), campeonato.getNome(), campeonato.getDescricao(), campeonato.getDataInicio(), campeonato.getTimes().stream().map(v -> v.getEquipe()).toList().stream().map(EquipeListagemDTO::new).toList());
	}

}
