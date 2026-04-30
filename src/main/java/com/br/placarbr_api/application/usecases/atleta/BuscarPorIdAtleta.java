package com.br.placarbr_api.application.usecases.atleta;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.domain.entities.atleta.Atleta;

public class BuscarPorIdAtleta {

	private final RepositorioDeAtleta repositorio;

	public BuscarPorIdAtleta(RepositorioDeAtleta repositorio) {
		this.repositorio = repositorio;
	}
	
	public Atleta buscar(Long id) {
		return repositorio.buscarPorId(id);
	}
}
