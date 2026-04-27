package com.br.placarbr_api.application.usecases.comissao_tecnica_tipo;

import com.br.placarbr_api.application.gateways.comissao_tecnica_tipo.RepositorioDeComissaoTecnicaTipo;
import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;

public class CriarComissaoTecnicaTipo {

	private final RepositorioDeComissaoTecnicaTipo repositorio;

	public CriarComissaoTecnicaTipo(RepositorioDeComissaoTecnicaTipo repositorio) {
		this.repositorio = repositorio;
	}
 
	public ComissaoTecnicaTipo cadastrarComissaoTecnicaTipo(ComissaoTecnicaTipo comissaoTecnicaTipo) {
		return repositorio.cadastrar(comissaoTecnicaTipo);
	}
}
