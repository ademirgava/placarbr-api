package com.br.placarbr_api.application.usecases.comissao_tecnica;

import com.br.placarbr_api.application.gateways.comissao_tecnica.RepositorioDeComissaoTecnica;
import com.br.placarbr_api.application.usecases.endereco.AtualizarEndereco;
import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;

public class AtualizarComissaoTecnica {

	private final RepositorioDeComissaoTecnica repositorioDeComissaoTecnica;
	private final AtualizarEndereco atualizarEndereco;

	public AtualizarComissaoTecnica(RepositorioDeComissaoTecnica repositorioDeComissaoTecnica, AtualizarEndereco atualizarEndereco) {
		this.repositorioDeComissaoTecnica = repositorioDeComissaoTecnica;
		this.atualizarEndereco = atualizarEndereco;
	}
	
	public ComissaoTecnica atualizar(ComissaoTecnica comissaoTecnica) {
		atualizarEndereco.atualizar(comissaoTecnica.getEndereco());
		return this.repositorioDeComissaoTecnica.atualizar(comissaoTecnica);
	}
}
