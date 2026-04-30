package com.br.placarbr_api.infra.controller.atleta.dto;

import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.infra.persistence.atleta.AtletaEntity;

public record AtletaListagemDTO(Long id, String nome, String apelido) {
	public AtletaListagemDTO(AtletaEntity atleta) {
		this(atleta.getId(), atleta.getNome(), atleta.getApelido());
	}
	
	public AtletaListagemDTO(Atleta atleta) {
		this(atleta.getId(), atleta.getNome(), atleta.getApelido());
	}
}
