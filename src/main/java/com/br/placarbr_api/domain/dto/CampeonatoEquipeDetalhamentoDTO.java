package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.CampeonatoEquipe;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeListagemDTO;

public record CampeonatoEquipeDetalhamentoDTO(Long id, CampeonatoListagemDTO campeonato, EquipeListagemDTO equipe, CampeonatoFaseListagemDTO fase) {

	public CampeonatoEquipeDetalhamentoDTO(CampeonatoEquipe campeonatoEquipe) {
		this(campeonatoEquipe.getId(), new CampeonatoListagemDTO(campeonatoEquipe.getCampeonato()), new EquipeListagemDTO(campeonatoEquipe.getEquipe()), new CampeonatoFaseListagemDTO(campeonatoEquipe.getCampeonatoFase()));
	}

}
