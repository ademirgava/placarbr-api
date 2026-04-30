package com.br.placarbr_api.application.usecases.equipe;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.domain.entities.equipe.Equipe;

public class AtivarEquipe {
	private final RepositorioDeEquipe repositorio;
	private final BuscarPorIdEquipe buscarPorIdEquipe;

	public AtivarEquipe(RepositorioDeEquipe repositorio, BuscarPorIdEquipe buscarPorIdEquipe) {
		this.repositorio = repositorio;
		this.buscarPorIdEquipe = buscarPorIdEquipe;
	}
	
	public Equipe ativar(Long id) {
		Equipe equipe = this.buscarPorIdEquipe.buscarPorId(id);
		equipe.ativarEquipe();
		return this.repositorio.ativarEquipe(equipe);
	}
}
