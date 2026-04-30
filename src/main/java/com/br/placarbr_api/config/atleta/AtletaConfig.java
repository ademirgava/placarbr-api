package com.br.placarbr_api.config.atleta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.application.usecases.atleta.AtualizarAtleta;
import com.br.placarbr_api.application.usecases.atleta.BuscarPorIdAtleta;
import com.br.placarbr_api.application.usecases.atleta.CadastrarAtleta;
import com.br.placarbr_api.application.usecases.atleta.DesvincularEquipeAtleta;
import com.br.placarbr_api.application.usecases.atleta.ListarAtletas;
import com.br.placarbr_api.application.usecases.atleta.ListarPorEquipeIdAtletas;
import com.br.placarbr_api.application.usecases.atleta.ListarPorNomeAtletas;
import com.br.placarbr_api.application.usecases.atleta.VincularEquipeAtleta;
import com.br.placarbr_api.application.usecases.endereco.AtualizarEndereco;
import com.br.placarbr_api.application.usecases.endereco.CriarEndereco;
import com.br.placarbr_api.infra.gateways.atleta.AtletaMapper;
import com.br.placarbr_api.infra.gateways.atleta.RepositorioDeAtletaJPA;
import com.br.placarbr_api.infra.gateways.endereco.EnderecoEntityMapper;
import com.br.placarbr_api.infra.gateways.equipe.EquipeMapper;
import com.br.placarbr_api.infra.gateways.pageable.PageableMapper;
import com.br.placarbr_api.infra.persistence.atleta.AtletaRepository;
import com.br.placarbr_api.infra.persistence.equipe.EquipeRepository;

@Configuration
public class AtletaConfig {

	@Bean
	CadastrarAtleta cadastrarAtleta(RepositorioDeAtleta repositorio, CriarEndereco criarEndereco) {
		return new CadastrarAtleta(repositorio, criarEndereco);
	}
	
	@Bean 
	ListarAtletas listarAtletas(RepositorioDeAtleta repositorio) {
		return new ListarAtletas(repositorio);
	}
	
	@Bean
	BuscarPorIdAtleta buscarPorIdAtleta(RepositorioDeAtleta repositorio) {
		return new BuscarPorIdAtleta(repositorio);
	}
	
	@Bean
	ListarPorEquipeIdAtletas listarPorEquipeIdAtletas(RepositorioDeAtleta repositorio) {
		return new ListarPorEquipeIdAtletas(repositorio);
	}
	
	@Bean
	AtualizarAtleta atualizarAtleta(RepositorioDeAtleta repositorio, AtualizarEndereco atualizarEndereco) {
		return new AtualizarAtleta(repositorio, atualizarEndereco);
	}
	
	@Bean
	ListarPorNomeAtletas listarPorNomeAtletas(RepositorioDeAtleta repositorio) {
		return new ListarPorNomeAtletas(repositorio);
	}
	
	@Bean 
	DesvincularEquipeAtleta desvincularEquipeAtleta(RepositorioDeAtleta repositorio) {
		return new DesvincularEquipeAtleta(repositorio);
	}
	
	@Bean
	VincularEquipeAtleta vincularEquipeAtleta(RepositorioDeAtleta repositorio) {
		return new VincularEquipeAtleta(repositorio);
	}
	
	@Bean 
	RepositorioDeAtleta repositorioDeAtleta(AtletaRepository repostorio, AtletaMapper mapper, PageableMapper pageableMapper, EquipeRepository equipeRepository) {
		return new RepositorioDeAtletaJPA(repostorio, mapper, pageableMapper, equipeRepository);
	}
	
	@Bean
	AtletaMapper atletaMapper(EnderecoEntityMapper enderecoMapper, EquipeMapper equipeMapper) {
		return new AtletaMapper(enderecoMapper, equipeMapper);
	}
	
}
