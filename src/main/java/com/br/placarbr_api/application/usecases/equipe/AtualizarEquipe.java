package com.br.placarbr_api.application.usecases.equipe;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.application.usecases.endereco.AtualizarEndereco;
import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.exception.ValidacaoException;

public class AtualizarEquipe {

	private final RepositorioDeEquipe repositorio;
	private final BuscarPorIdEquipe buscarPorIdEquipe;
	private final AtualizarEndereco atualizarEndereco;
	private final ValidacaoEquipe validacaoEquipe;

	public AtualizarEquipe(RepositorioDeEquipe repositorio, BuscarPorIdEquipe buscarPorIdEquipe,
			AtualizarEndereco atualizarEndereco, ValidacaoEquipe validacaoEquipe) {
		this.repositorio = repositorio;
		this.buscarPorIdEquipe = buscarPorIdEquipe;
		this.atualizarEndereco = atualizarEndereco;
		this.validacaoEquipe = validacaoEquipe;
	}

	public Equipe atualizar(Equipe equipe) {
		if (equipe == null || equipe.getId() == null) {
			throw new ValidacaoException("Id da equipe não pode ser nulo!");
		}

		Equipe equipeAtual = this.buscarPorIdEquipe.buscarPorId(equipe.getId());		

		if (equipe.getNome() != null && !equipe.getNome().equalsIgnoreCase(equipeAtual.getNome())) {
			this.validacaoEquipe.validarNome(equipe);
		}
		
		if (equipe.getSigla() != null && !equipe.getSigla().equalsIgnoreCase(equipeAtual.getSigla())) {
			this.validacaoEquipe.validarSigla(equipe);
		}

		if (equipe.getEndereco() != null) {
			Endereco endereco = this.atualizarEndereco.atualizar(equipe.getEndereco());
			equipeAtual.setEndereco(endereco);
		}

		equipeAtual.atualizar(equipe);
		return this.repositorio.atualizar(equipeAtual);
	}
}
