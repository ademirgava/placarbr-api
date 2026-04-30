package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.CampeonatoJogo;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeListagemDTO;

public record CampeonatoJogoDetalhamentoDTO(Long id, EquipeListagemDTO timeVisitante, EquipeListagemDTO timeMandante, Integer rodada, CampeonatoListagemDTO campeonato) {

	public CampeonatoJogoDetalhamentoDTO(CampeonatoJogo jogo) {
		this(jogo.getId(), new EquipeListagemDTO(jogo.getEquipeVisitante()), new EquipeListagemDTO(jogo.getEquipeMandante()), jogo.getRodada(), new CampeonatoListagemDTO(jogo.getCampeonatoFase().getCampeonato()));
	}

}
