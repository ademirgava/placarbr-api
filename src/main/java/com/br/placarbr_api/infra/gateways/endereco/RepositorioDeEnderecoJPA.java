package com.br.placarbr_api.infra.gateways.endereco;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.br.placarbr_api.application.gateways.endereco.RepositorioDeEndereco;
import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.infra.controller.endereco.EnderecoViaCep;
import com.br.placarbr_api.infra.exception.ExternalApiException;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoRepository;

public class RepositorioDeEnderecoJPA implements RepositorioDeEndereco {

	private final EnderecoRepository repository;
	private final EnderecoEntityMapper mapper;
	private final RestTemplate restTemplate;

	public RepositorioDeEnderecoJPA(EnderecoRepository repository, EnderecoEntityMapper mapper,
			RestTemplateBuilder builder) {
		this.repository = repository;
		this.mapper = mapper;
		this.restTemplate = builder.build();
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

	@Override
	public Endereco buscarViaCep(String cep) {
		String url = "https://viacep.com.br/ws/" + cep + "/json";
		try {
			EnderecoViaCep enderecoViaCepDTO = restTemplate.getForObject(url, EnderecoViaCep.class);
			return mapper.toDomain(enderecoViaCepDTO);
		} catch (HttpClientErrorException e) {
			throw new ExternalApiException("Erro ao acessar via cep: " + e.getMessage());
		}

	}

}
