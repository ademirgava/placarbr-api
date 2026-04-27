package com.br.placarbr_api.application.usecases.comissao_tecnica_tipo;

import com.br.placarbr_api.application.gateways.comissao_tecnica_tipo.RepositorioDeComissaoTecnicaTipo;
import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;

public class AtualizarComissaoTecnicaTipo {

	private final RepositorioDeComissaoTecnicaTipo repositorio;

	public AtualizarComissaoTecnicaTipo(RepositorioDeComissaoTecnicaTipo repositorio) {
		this.repositorio = repositorio;
	}

	public ComissaoTecnicaTipo atualizarTipo(ComissaoTecnicaTipo comissaoTecnicaTipo) {
		if (comissaoTecnicaTipo.getId() == null) {
			throw new IllegalArgumentException("Id do tipo não deve ser nulo!");
		}
		return this.repositorio.atualizarTipo(comissaoTecnicaTipo);
	};
}
