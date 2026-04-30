package com.br.placarbr_api.application.usecases.atleta;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.atleta.Atleta;

public class ListarAtletas {

	private final RepositorioDeAtleta repositorio;

	public ListarAtletas(RepositorioDeAtleta repositorio) {
		this.repositorio = repositorio;
	}
	
	public Pagina<Atleta> listar(Paginacao paginacao) {
		return this.repositorio.listar(paginacao);
	}
}
