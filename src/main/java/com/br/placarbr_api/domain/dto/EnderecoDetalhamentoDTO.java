package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;

public record EnderecoDetalhamentoDTO(String logradouro, String numero, String bairro, String cidade, String cep,
		String uf, String complemento) {

	public EnderecoDetalhamentoDTO(EnderecoEntity endereco) {
		this(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getCep(), endereco.getUf(), endereco.getComplemento());
	}

	public EnderecoDetalhamentoDTO(Endereco endereco) {
		this(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getCep(), endereco.getUf(), endereco.getComplemento());
	}

}
