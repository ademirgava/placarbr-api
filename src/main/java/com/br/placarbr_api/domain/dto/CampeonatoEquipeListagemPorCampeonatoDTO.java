package com.br.placarbr_api.domain.dto;

import java.util.List;

import com.br.placarbr_api.domain.model.Campeonato;

public record CampeonatoEquipeListagemPorCampeonatoDTO(CampeonatoListagemDTO campeonato, List<CampeonatoFaseListagemDTO> fases) {

	public CampeonatoEquipeListagemPorCampeonatoDTO(Campeonato campeonato) {
		this(new CampeonatoListagemDTO(campeonato), campeonato.getFases().stream().map(CampeonatoFaseListagemDTO::new).toList());
	}

}
