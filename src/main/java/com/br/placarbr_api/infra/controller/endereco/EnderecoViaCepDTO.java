package com.br.placarbr_api.infra.controller.endereco;

import com.br.placarbr_api.domain.entities.Endereco;

public record EnderecoViaCepDTO(String logradouro, String bairro, String cidade, String cep,
		String uf) {

	public EnderecoViaCepDTO(Endereco endereco) {
		this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCidade(), endereco.getCep(), endereco.getUf());
	}

}
