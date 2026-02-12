package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.CampeonatoJogo;

public record CampeonatoJogoDetalhamentoDTO(Long id, EquipeListagemDTO timeVisitante, EquipeListagemDTO timeMandante, Integer rodada, CampeonatoListagemDTO campeonato) {

	public CampeonatoJogoDetalhamentoDTO(CampeonatoJogo jogo) {
		this(jogo.getId(), new EquipeListagemDTO(jogo.getTimeVisitante().getEquipe()), new EquipeListagemDTO(jogo.getTimeMandante().getEquipe()), jogo.getRodada(), new CampeonatoListagemDTO(jogo.getCampeonatoFase().getCampeonato()));
	}

}
