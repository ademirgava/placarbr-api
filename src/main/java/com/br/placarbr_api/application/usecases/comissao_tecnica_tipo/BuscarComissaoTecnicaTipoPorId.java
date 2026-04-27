package com.br.placarbr_api.application.usecases.comissao_tecnica_tipo;

import com.br.placarbr_api.application.gateways.comissao_tecnica_tipo.RepositorioDeComissaoTecnicaTipo;
import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;
import com.br.placarbr_api.infra.exception.NotFoundExecption;

public class BuscarComissaoTecnicaTipoPorId {
	
	private final RepositorioDeComissaoTecnicaTipo repositorio;

	public BuscarComissaoTecnicaTipoPorId(RepositorioDeComissaoTecnicaTipo repositorio) {
		this.repositorio = repositorio;
	}

	public ComissaoTecnicaTipo buscarTipoPorId(Long id) {
		ComissaoTecnicaTipo tipo = repositorio.buscarTipoPorId(id);
		if (tipo == null) {
			throw new NotFoundExecption("Tipo de comissão técnica não encontrada");
		}
		return tipo;
	}
}
