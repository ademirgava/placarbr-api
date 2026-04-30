package com.br.placarbr_api.infra.gateways.endereco;

import com.br.placarbr_api.application.gateways.endereco.RepositorioDeEndereco;
import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoRepository;

public class RepositorioDeEnderecoJPA implements RepositorioDeEndereco{

	private final EnderecoRepository repository;
	private final EnderecoEntityMapper mapper;

	public RepositorioDeEnderecoJPA(EnderecoRepository repository, EnderecoEntityMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
	public Endereco cadastrarEndreco(Endereco endereco) {
		EnderecoEntity entity = mapper.toEntity(endereco);
		return mapper.toDomain(repository.save(entity));
	}

	@Override
	public Endereco atualizar(Endereco endereco) {
		EnderecoEntity entity = repository.getReferenceById(endereco.getId());
		entity.update(endereco);
		return mapper.toDomain(entity);
	}

}
