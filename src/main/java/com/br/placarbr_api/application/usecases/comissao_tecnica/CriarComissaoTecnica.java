package com.br.placarbr_api.application.usecases.comissao_tecnica;

import java.time.LocalDateTime;

import com.br.placarbr_api.application.gateways.comissao_tecnica.RepositorioDeComissaoTecnica;
import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;

public class CriarComissaoTecnica {

	private final RepositorioDeComissaoTecnica repositorio;

	public CriarComissaoTecnica(RepositorioDeComissaoTecnica repositorio) {
		this.repositorio = repositorio;
	}
	
	public ComissaoTecnica cadastrarComissaoTecnica(ComissaoTecnica comissaoTecnica) {
		comissaoTecnica.setDataCriacao(LocalDateTime.now());
		return repositorio.cadastrarComissaoTecnica(comissaoTecnica);
	}
}
