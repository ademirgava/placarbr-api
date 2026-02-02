package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.Jogador;

public record JogadorListagemDTO(Long id, String nome, String apelido) {
	public JogadorListagemDTO(Jogador jogador) {
		this(jogador.getId(), jogador.getNome(), jogador.getApelido());
	}
}
