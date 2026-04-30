package com.br.placarbr_api.config.equipe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.application.usecases.endereco.AtualizarEndereco;
import com.br.placarbr_api.application.usecases.endereco.CriarEndereco;
import com.br.placarbr_api.application.usecases.equipe.AdicionarLogomarcaEquipe;
import com.br.placarbr_api.application.usecases.equipe.AtivarEquipe;
import com.br.placarbr_api.application.usecases.equipe.AtualizarEquipe;
import com.br.placarbr_api.application.usecases.equipe.BuscarPorIdEquipe;
import com.br.placarbr_api.application.usecases.equipe.CadastrarEquipe;
import com.br.placarbr_api.application.usecases.equipe.InativaEquipe;
import com.br.placarbr_api.application.usecases.equipe.ListarTodasEquipes;
import com.br.placarbr_api.application.usecases.equipe.ValidacaoEquipe;
import com.br.placarbr_api.infra.gateways.endereco.EnderecoEntityMapper;
import com.br.placarbr_api.infra.gateways.equipe.EquipeMapper;
import com.br.placarbr_api.infra.gateways.equipe.RepositorioDeEquipeJPA;
import com.br.placarbr_api.infra.gateways.pageable.PageableMapper;
import com.br.placarbr_api.infra.persistence.equipe.EquipeRepository;

@Configuration
public class EquipeConfig {
	
	@Bean
	ValidacaoEquipe validacaoEquipe(RepositorioDeEquipe repositorio) {
		return new ValidacaoEquipe(repositorio);
	}
	
	@Bean
	CadastrarEquipe cadastrarEquipe(RepositorioDeEquipe repositorio, CriarEndereco criarEndereco, ValidacaoEquipe validacaoEquipe) {
		return new CadastrarEquipe(repositorio, criarEndereco, validacaoEquipe);
	}
	
	@Bean
	ListarTodasEquipes listarTodasEquipes(RepositorioDeEquipe repositorio) {
		return new ListarTodasEquipes(repositorio);
	}
	
	@Bean 
	BuscarPorIdEquipe buscarPorIdEquipe(RepositorioDeEquipe repositorio) {
		return new BuscarPorIdEquipe(repositorio);
	}
	
	@Bean
	InativaEquipe inativaEquipe(RepositorioDeEquipe repositorio, BuscarPorIdEquipe buscarPorIdEquipe) {
		return new InativaEquipe(repositorio, buscarPorIdEquipe);
	}
	
	@Bean
	AtivarEquipe ativarEquipe(BuscarPorIdEquipe buscarPorIdEquipe, RepositorioDeEquipe repositorio) {
		return new AtivarEquipe(repositorio, buscarPorIdEquipe);
	}
	
	@Bean 
	AtualizarEquipe atualizarEquipe(RepositorioDeEquipe repositorio, BuscarPorIdEquipe buscarPorIdEquipe, AtualizarEndereco atualizarEndereco, ValidacaoEquipe validacaoEquipe) {
		return new AtualizarEquipe(repositorio, buscarPorIdEquipe, atualizarEndereco, validacaoEquipe);
	}
	
	@Bean
	AdicionarLogomarcaEquipe adicionarLogomarcaEquipe(RepositorioDeEquipe repositorio, BuscarPorIdEquipe buscarPorIdEquipe) {
		return new AdicionarLogomarcaEquipe(repositorio, buscarPorIdEquipe);
	}
	
	@Bean
	RepositorioDeEquipe repositorioDeEquipe(EquipeRepository repositorio, EquipeMapper equipeMapper, PageableMapper pageableMapper) {
		return new RepositorioDeEquipeJPA(repositorio, equipeMapper, pageableMapper);
	}

	@Bean
	EquipeMapper equipeMapper(EnderecoEntityMapper enderecoMapper) {
		return new EquipeMapper(enderecoMapper);
	}
	
}
