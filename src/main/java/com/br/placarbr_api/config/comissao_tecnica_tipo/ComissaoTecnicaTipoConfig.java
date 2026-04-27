package com.br.placarbr_api.config.comissao_tecnica_tipo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.placarbr_api.application.gateways.comissao_tecnica_tipo.RepositorioDeComissaoTecnicaTipo;
import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.AtualizarComissaoTecnicaTipo;
import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.BuscarComissaoTecnicaTipoPorId;
import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.CriarComissaoTecnicaTipo;
import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.ListarComissaoTecnicaTipo;
import com.br.placarbr_api.infra.gateways.comissao_tecnica_tipo.ComissaoTecnicaTipoEntityMapper;
import com.br.placarbr_api.infra.gateways.comissao_tecnica_tipo.RepositorioDeComissaoTecnicaTipoJPA;
import com.br.placarbr_api.infra.persistence.comissao_tecnica_tipo.ComissaoTecnicaTipoRepository;

@Configuration
public class ComissaoTecnicaTipoConfig {

	@Bean
	CriarComissaoTecnicaTipo criarComissaoTecnicaTipo(RepositorioDeComissaoTecnicaTipo repositorio) {
		return new CriarComissaoTecnicaTipo(repositorio);
	}
	
	@Bean
	BuscarComissaoTecnicaTipoPorId buscarComissaoTecnicaTipoPorId(RepositorioDeComissaoTecnicaTipo repositorio) {
		return new BuscarComissaoTecnicaTipoPorId(repositorio);
	}
	
	@Bean 
	AtualizarComissaoTecnicaTipo atualizarComissaoTecnicaTipo(RepositorioDeComissaoTecnicaTipo repositorio) {
		return new AtualizarComissaoTecnicaTipo(repositorio);
	}
	
	@Bean
	ListarComissaoTecnicaTipo listarComissaoTecnicaTipo(RepositorioDeComissaoTecnicaTipo repositorio) {
		return new ListarComissaoTecnicaTipo(repositorio);
	}
	
	@Bean
	RepositorioDeComissaoTecnicaTipoJPA criarRepositorioDeComissaoTecnicaTipoJPA(ComissaoTecnicaTipoRepository repository, ComissaoTecnicaTipoEntityMapper mapper) {
		return new RepositorioDeComissaoTecnicaTipoJPA(repository, mapper);
	}
	
	@Bean
	ComissaoTecnicaTipoEntityMapper criarComissaoTecnicaTipoEntityMapper() {
		return new ComissaoTecnicaTipoEntityMapper();
	}

}
