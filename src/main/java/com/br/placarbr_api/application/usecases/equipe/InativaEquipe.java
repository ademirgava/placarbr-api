package com.br.placarbr_api.application.usecases.equipe;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.domain.entities.equipe.Equipe;

public class InativaEquipe {

	private final RepositorioDeEquipe repositorio;
	private BuscarPorIdEquipe buscarPorIdEquipe;

	public InativaEquipe(RepositorioDeEquipe repositorio, BuscarPorIdEquipe buscarPorIdEquipe) {
		this.repositorio = repositorio;
		this.buscarPorIdEquipe = buscarPorIdEquipe;
	}
	
	public void invativarEquipe(Long id) {
		Equipe equipe = this.buscarPorIdEquipe.buscarPorId(id);
		equipe.inativar();
		this.repositorio.atualizar(equipe);
	}
}
