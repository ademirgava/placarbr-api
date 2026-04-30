package com.br.placarbr_api.application.usecases.atleta;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.application.usecases.endereco.CriarEndereco;
import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.infra.exception.ValidacaoException;

public class CadastrarAtleta {
	
	private final RepositorioDeAtleta repositorio;
	private final CriarEndereco criarEndereco;

	public CadastrarAtleta(RepositorioDeAtleta repositorio, CriarEndereco criarEndereco) {
		this.repositorio = repositorio;
		this.criarEndereco = criarEndereco;
	}
	
	public Atleta cadastrar(Atleta atleta) {
		if (repositorio.existsByCpf(atleta.getCpf())) {
			throw new ValidacaoException("Já existe um atleta cadastro com o CPF: " + atleta.getCpf());
		}
		
		Endereco endereco = criarEndereco.cadastrarEndereco(atleta.getEndereco());
		atleta.setEndereco(endereco);
		if (atleta.getEquipe() != null && atleta.getEquipe().getId() != null) {
			//TODO implementar set de equipe para o atleta
		//	Equipe equipe = equipeService.buscarEquipePeloIdReference(dto.equipeId());
		//	atleta.setEquipe(equipe);
		}
		return this.repositorio.cadastrar(atleta);
	}
}
