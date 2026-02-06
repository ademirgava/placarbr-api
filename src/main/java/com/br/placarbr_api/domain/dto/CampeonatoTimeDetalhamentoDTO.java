package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.CampeonatoTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CampeonatoTimeDetalhamentoDTO(Long cameponatoTimeId, @JsonProperty(value = "campeonato") CampeonatoListagemDTO campeonatoListagemDTO, @JsonProperty(value = "equipes") EquipeListagemDTO equipeListagemDTO) {

	public CampeonatoTimeDetalhamentoDTO(CampeonatoTime time) {
		this(time.getId(), new CampeonatoListagemDTO(time.getCampeonato()), new EquipeListagemDTO(time.getEquipe()));
	}

}
