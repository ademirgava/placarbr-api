package com.br.placarbr_api.application.usecases.atleta;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.domain.entities.atleta.Atleta;

public class DesvincularEquipeAtleta {

	private final RepositorioDeAtleta repositorio;

	public DesvincularEquipeAtleta(RepositorioDeAtleta repositorio) {
		this.repositorio = repositorio;
	}

	public Atleta desvicularEquipe(Long atletaId) {
		return this.repositorio.desvicular(atletaId);
	}
}
