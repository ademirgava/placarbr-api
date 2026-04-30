package com.br.placarbr_api.infra.gateways.endereco;

import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.infra.controller.endereco.EnderecoAtualizaDTO;
import com.br.placarbr_api.infra.controller.endereco.EnderecoCadastroDTO;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;

public class EnderecoEntityMapper {

	public Endereco toDomain(EnderecoEntity entity) {
		return new Endereco(entity.getId(), entity.getLogradouro(), entity.getNumero(), entity.getBairro(),
				entity.getCidade(), entity.getUf(), entity.getCep(), entity.getComplemento());
	}

	public Endereco toDomain(EnderecoCadastroDTO entity) {
		return new Endereco(entity.logradouro(), entity.numero(), entity.bairro(), entity.cidade(), entity.uf(),
				entity.cep(), entity.complemento());
	}

	public EnderecoEntity toEntity(Endereco domain) {
		return new EnderecoEntity(domain.getId(), domain.getLogradouro(), domain.getNumero(), domain.getBairro(), domain.getCidade(), domain.getUf(), domain.getCep(), domain.getComplemento());
	}

	public Endereco toDomain(EnderecoAtualizaDTO domain) {
		return new Endereco(domain.id(), domain.logradouro(), domain.numero(), domain.bairro(), domain.cidade(), domain.uf(), domain.cep(), domain.complemento());
	}
}
