
package com.br.placarbr_api.application.usecases.atleta;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.atleta.Atleta;

public class ListarPorEquipeIdAtletas {

	private final RepositorioDeAtleta repositorio;

	public ListarPorEquipeIdAtletas(RepositorioDeAtleta repositorio) {
		this.repositorio = repositorio;
	}
	
	public Pagina<Atleta> listar(Paginacao paginacao, Long equipeId) {
		return this.repositorio.listarPorEquipeIdAtletas(paginacao, equipeId);
	}
}
