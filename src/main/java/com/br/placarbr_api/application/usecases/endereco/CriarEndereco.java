package com.br.placarbr_api.application.usecases.endereco;

import com.br.placarbr_api.application.gateways.endereco.RepositorioDeEndereco;
import com.br.placarbr_api.domain.entities.Endereco;

public class CriarEndereco {

	private final RepositorioDeEndereco repositorio;

	public CriarEndereco(RepositorioDeEndereco repositorio) {
		this.repositorio = repositorio;
	}
	
	
	public Endereco cadastrarEndereco(Endereco endereco) {
		return this.repositorio.cadastrarEndreco(endereco);
	}
}
