package com.br.placarbr_api.application.usecases.equipe;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.equipe.Equipe;

public class ListarTodasEquipes {

	private RepositorioDeEquipe repositorio;

	public ListarTodasEquipes(RepositorioDeEquipe repositorio) {
		this.repositorio = repositorio;
	}
	
	public Pagina<Equipe> listar(Paginacao paginacao) {
		return this.repositorio.listarTodas(paginacao);
	}
}
