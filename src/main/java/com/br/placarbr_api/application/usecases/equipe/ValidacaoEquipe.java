package com.br.placarbr_api.application.usecases.equipe;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.exception.ValidacaoException;

public class ValidacaoEquipe {
	private final RepositorioDeEquipe repositorio;

	public ValidacaoEquipe(RepositorioDeEquipe repositorio) {
		this.repositorio = repositorio;
	}
	
	public void validarNome(Equipe equipe) {
		if (this.repositorio.existsByNome(equipe.getNome())) {
			throw new ValidacaoException("Já existe uma equipe com este nome!");
		}
	}
	
	public void validarSigla(Equipe equipe) {
		if (this.repositorio.existsBySigla(equipe.getSigla())) {
			throw new ValidacaoException("Já existe uma equipe com esta sigla!");
		}
	}
	
	public void validarCadastro(Equipe equipe) {
		this.validarNome(equipe);
		this.validarSigla(equipe);
	}
}
