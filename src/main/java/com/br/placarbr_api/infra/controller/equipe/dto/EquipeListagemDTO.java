package com.br.placarbr_api.infra.controller.equipe.dto;

import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;

public record EquipeListagemDTO(
		Long id,
		String nome,
		String sigla, 
		byte[] logomarca
		) {

	public EquipeListagemDTO(EquipeEntity equipe) {
		this(equipe.getId(), equipe.getNome(), equipe.getSigla(), equipe.getLogomarca());
	}
	
	public EquipeListagemDTO(Equipe equipe) {
		this(equipe.getId(), equipe.getNome(), equipe.getSigla(), equipe.getLogomarca());
	}
}
