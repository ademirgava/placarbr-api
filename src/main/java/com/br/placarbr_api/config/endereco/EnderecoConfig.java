package com.br.placarbr_api.config.endereco;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.placarbr_api.application.gateways.endereco.RepositorioDeEndereco;
import com.br.placarbr_api.application.usecases.endereco.AtualizarEndereco;
import com.br.placarbr_api.application.usecases.endereco.CriarEndereco;
import com.br.placarbr_api.infra.gateways.endereco.EnderecoEntityMapper;
import com.br.placarbr_api.infra.gateways.endereco.RepositorioDeEnderecoJPA;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoRepository;

@Configuration
public class EnderecoConfig {

	@Bean
	CriarEndereco criarEndereco(RepositorioDeEndereco repositorio) {
		return new CriarEndereco(repositorio);
	}
	
	@Bean
	AtualizarEndereco atualizarEndereco(RepositorioDeEndereco repositorio) {
		return new AtualizarEndereco(repositorio);
	}
	
	@Bean
	RepositorioDeEndereco repositorioDeEndereco(EnderecoRepository repository, EnderecoEntityMapper mapper) {
		return new RepositorioDeEnderecoJPA(repository, mapper);
	}
	
	@Bean
	EnderecoEntityMapper enderecoEntityMapper() {
		return new EnderecoEntityMapper();
	}
}
