package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.CampeonatoJogador;
import com.br.placarbr_api.domain.model.TipoPosicaoJogador;

public record CampeonatoJogadoresDetalhamentoDTO(AtletaListagemDTO jogador, TipoPosicaoJogador posicao) {

	public CampeonatoJogadoresDetalhamentoDTO(CampeonatoJogador campeonatoJogador) {
		this(new AtletaListagemDTO(campeonatoJogador.getAtleta()), campeonatoJogador.getPosicao());
	}

}
