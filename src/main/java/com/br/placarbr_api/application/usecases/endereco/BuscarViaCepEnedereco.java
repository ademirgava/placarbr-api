package com.br.placarbr_api.application.usecases.endereco;

import com.br.placarbr_api.application.gateways.endereco.RepositorioDeEndereco;
import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.infra.exception.ValidacaoException;

public class BuscarViaCepEnedereco {

	private RepositorioDeEndereco repositorio;

	public BuscarViaCepEnedereco(RepositorioDeEndereco repositorio) {
		this.repositorio = repositorio;
	}
	
	public Endereco buscar(String cep) {
		if (cep != null && cep.length() != 8) {
			throw new ValidacaoException("Por favor, enviar um CEP valida!");
		}
		
		try {
			Integer.parseInt(cep);
		} catch (NumberFormatException e) {
			throw new ValidacaoException("Por favor, enviar um CEP com apenas numeros!");
		}
		
		return this.repositorio.buscarViaCep(cep);
	}
}
