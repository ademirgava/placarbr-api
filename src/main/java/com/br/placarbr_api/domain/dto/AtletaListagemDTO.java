package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.Atleta;

public record AtletaListagemDTO(Long id, String nome, String apelido) {
	public AtletaListagemDTO(Atleta atleta) {
		this(atleta.getId(), atleta.getNome(), atleta.getApelido());
	}
}
