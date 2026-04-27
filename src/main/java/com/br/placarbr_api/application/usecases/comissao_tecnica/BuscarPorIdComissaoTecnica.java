package com.br.placarbr_api.application.usecases.comissao_tecnica;

import com.br.placarbr_api.application.gateways.comissao_tecnica.RepositorioDeComissaoTecnica;
import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;

public class BuscarPorIdComissaoTecnica {

	private final RepositorioDeComissaoTecnica repositorio;

	public BuscarPorIdComissaoTecnica(RepositorioDeComissaoTecnica repositorio) {
		this.repositorio = repositorio;
	}
	
	public ComissaoTecnica buscarPorIdComissaoTecnica(Long id) {
		return repositorio.buscarPorIdComissaoTecnica(id);
	}
}
