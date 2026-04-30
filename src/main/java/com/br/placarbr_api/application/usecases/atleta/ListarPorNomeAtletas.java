package com.br.placarbr_api.application.usecases.atleta;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.atleta.Atleta;

public class ListarPorNomeAtletas {

	private RepositorioDeAtleta repositorio;

	public ListarPorNomeAtletas(RepositorioDeAtleta repositorio) {
		this.repositorio = repositorio;
	}
	
	public Pagina<Atleta> listar(String nome, Paginacao paginacao){
		return this.repositorio.listarPorNomeAtletas(nome, paginacao);
	}
}
