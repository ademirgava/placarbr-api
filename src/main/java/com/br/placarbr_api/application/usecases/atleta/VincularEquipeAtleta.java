package com.br.placarbr_api.application.usecases.atleta;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.infra.exception.ValidacaoException;

public class VincularEquipeAtleta {
	
	private RepositorioDeAtleta repositorio;

	public VincularEquipeAtleta(RepositorioDeAtleta repositorio) {
		this.repositorio = repositorio;
	}

	public Atleta vincular(Long equipeId, Long atletaId) {
		if (equipeId == null) {
			throw new ValidacaoException("Equipe id não pode ser nulo!");
		}
		if (atletaId == null) {
			throw new ValidacaoException("Atleta id não pode ser nulo!");
		}
		return this.repositorio.vincularEquipeAtleta(equipeId, atletaId);
	}
}
