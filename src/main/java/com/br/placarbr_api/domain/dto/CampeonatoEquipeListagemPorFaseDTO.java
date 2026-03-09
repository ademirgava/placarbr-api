package com.br.placarbr_api.domain.dto;

import java.util.List;

import com.br.placarbr_api.domain.model.CampeonatoEquipe;

public record CampeonatoEquipeListagemPorFaseDTO(CampeonatoListagemDTO campeonato, CampeonatoFaseListagemDTO campeonatoFase ,List<EquipeListagemDTO> equipes) {

	public CampeonatoEquipeListagemPorFaseDTO(List<CampeonatoEquipe> campeonatoEquipes) {
		this(new CampeonatoListagemDTO(campeonatoEquipes.get(1).getCampeonato()), new CampeonatoFaseListagemDTO(campeonatoEquipes.get(1).getCampeonatoFase()), campeonatoEquipes.stream().map(c -> c.getEquipe()).map(EquipeListagemDTO::new).toList());
	}

}
