package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.Endereco;

public record EnderecoDetalhamentoDTO(String logradouro, String numero, String bairro, String cidade, String cep,
		String uf, String complemento) {

	public EnderecoDetalhamentoDTO(Endereco endereco) {
		this(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getCep(), endereco.getUf(), endereco.getComplemento());
	}

}
