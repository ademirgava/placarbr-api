package com.br.placarbr_api.application.usecases.equipe;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.domain.entities.equipe.Equipe;

public class AdicionarLogomarcaEquipe {

	private final RepositorioDeEquipe repositorio;
	private final BuscarPorIdEquipe buscarPorIdEquipe;

	public AdicionarLogomarcaEquipe(RepositorioDeEquipe repositorio, BuscarPorIdEquipe buscarPorIdEquipe) {
		this.repositorio = repositorio;
		this.buscarPorIdEquipe = buscarPorIdEquipe;
	}
	
	public Equipe adicionar(Long equipeId, MultipartFile logomarca) throws IOException {
		Equipe equipe = buscarPorIdEquipe.buscarPorId(equipeId);
		equipe.setLogomarca(logomarca.getBytes());
		return this.repositorio.adicionarLogo(equipe);
	}
}
