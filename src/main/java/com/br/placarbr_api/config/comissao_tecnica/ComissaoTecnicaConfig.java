package com.br.placarbr_api.config.comissao_tecnica;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.placarbr_api.application.gateways.comissao_tecnica.RepositorioDeComissaoTecnica;
import com.br.placarbr_api.application.usecases.comissao_tecnica.AtualizarComissaoTecnica;
import com.br.placarbr_api.application.usecases.comissao_tecnica.BuscarPorIdComissaoTecnica;
import com.br.placarbr_api.application.usecases.comissao_tecnica.CriarComissaoTecnica;
import com.br.placarbr_api.application.usecases.comissao_tecnica.ListarTodoComissaoTecnica;
import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.BuscarComissaoTecnicaTipoPorId;
import com.br.placarbr_api.application.usecases.endereco.AtualizarEndereco;
import com.br.placarbr_api.application.usecases.endereco.CriarEndereco;
import com.br.placarbr_api.infra.gateways.comissao_tecnica.ComissaoTecnicaMapper;
import com.br.placarbr_api.infra.gateways.comissao_tecnica.RepositorioDeComissaoTecnicaJPA;
import com.br.placarbr_api.infra.gateways.comissao_tecnica_tipo.ComissaoTecnicaTipoEntityMapper;
import com.br.placarbr_api.infra.gateways.endereco.EnderecoEntityMapper;
import com.br.placarbr_api.infra.persistence.comissao_tecnica.ComissaoTecnicaRepository;

@Configuration
public class ComissaoTecnicaConfig {

	@Bean
	CriarComissaoTecnica criarComissaoTecnica(RepositorioDeComissaoTecnica repositorio) {
		return new CriarComissaoTecnica(repositorio);
	}

	@Bean
	BuscarPorIdComissaoTecnica buscarPorIdComissaoTecnica(RepositorioDeComissaoTecnica repositorio) {
		return new BuscarPorIdComissaoTecnica(repositorio);
	}

	@Bean
	ListarTodoComissaoTecnica listarTodoComissaoTecnica(RepositorioDeComissaoTecnica repositorio) {
		return new ListarTodoComissaoTecnica(repositorio);
	}

	@Bean
	AtualizarComissaoTecnica atualizarComissaoTecnica(RepositorioDeComissaoTecnica repositorio, AtualizarEndereco atualizarEndereco) {
		return new AtualizarComissaoTecnica(repositorio, atualizarEndereco);
	}

	@Bean
	RepositorioDeComissaoTecnica repositorioDeComissaoTecnica(ComissaoTecnicaRepository repository,
			ComissaoTecnicaMapper mapper, ComissaoTecnicaTipoEntityMapper tipoMapper,
			BuscarComissaoTecnicaTipoPorId buscarComissaoTecnicaTipoPorId, CriarEndereco criarEndereco,
			EnderecoEntityMapper enderecoMapper) {
		return new RepositorioDeComissaoTecnicaJPA(repository, mapper, tipoMapper, buscarComissaoTecnicaTipoPorId,
				criarEndereco, enderecoMapper);
	}

	@Bean
	ComissaoTecnicaMapper comissaoTecnicaMapper(ComissaoTecnicaTipoEntityMapper mapperTipo,
			EnderecoEntityMapper mapperEndereco) {
		return new ComissaoTecnicaMapper(mapperTipo, mapperEndereco);
	}
}
