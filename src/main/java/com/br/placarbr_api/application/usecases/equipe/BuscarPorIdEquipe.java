package com.br.placarbr_api.application.usecases.equipe;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.exception.NotFoundExecption;

public class BuscarPorIdEquipe {

	private final RepositorioDeEquipe repositorio;

	public BuscarPorIdEquipe(RepositorioDeEquipe repositorio) {
		this.repositorio = repositorio;
	}
	
	public Equipe buscarPorId(Long equipeId) {
		Equipe equipe = this.repositorio.buscarPorId(equipeId);
		
		if (equipe == null) {
			throw new NotFoundExecption("Equipe não encontrada!");
		}
		
		return equipe;
	}
}
