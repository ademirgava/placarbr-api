package com.br.placarbr_api.application.usecases.atleta;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.application.usecases.endereco.AtualizarEndereco;
import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.infra.exception.ValidacaoException;

public class AtualizarAtleta {

	private final RepositorioDeAtleta repositorio;
	private final AtualizarEndereco atualizarEndereco;

	public AtualizarAtleta(RepositorioDeAtleta repositorio, AtualizarEndereco atualizarEndereco) {
		this.repositorio = repositorio;
		this.atualizarEndereco = atualizarEndereco;
	}
	
	public Atleta atualizar(Atleta atleta) {
		if (atleta == null || atleta.getId() == null) {
			throw new ValidacaoException("Por favor informar o id do Atleta a ser atualizado!");
		}		
		Atleta atletaAtualizado = repositorio.atualizar(atleta);
		Endereco enderecoAtualizado = atualizarEndereco.atualizar(atleta.getEndereco());
		atleta.setEndereco(enderecoAtualizado);
		return atletaAtualizado;
	}
}
