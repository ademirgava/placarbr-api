package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.Equipe;

public record EquipeListagemDTO(
		Long id,
		String nome,
		String sigla
		) {

	public EquipeListagemDTO(Equipe equipe) {
		this(equipe.getId(), equipe.getNome(), equipe.getSigla());
	}
}
