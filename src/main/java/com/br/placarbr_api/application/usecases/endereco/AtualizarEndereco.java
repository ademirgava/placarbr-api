package com.br.placarbr_api.application.usecases.endereco;

import com.br.placarbr_api.application.gateways.endereco.RepositorioDeEndereco;
import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.infra.exception.ValidacaoException;

public class AtualizarEndereco {

	private final RepositorioDeEndereco repositorio;

	public AtualizarEndereco(RepositorioDeEndereco repositorio) {
		this.repositorio = repositorio;
	}

	public Endereco atualizar(Endereco endereco) {
		if (endereco.getId() == null) {
			throw new ValidacaoException("Id do endereço não pode ser nulo!");
		}
		return this.repositorio.atualizar(endereco);
	}

}
