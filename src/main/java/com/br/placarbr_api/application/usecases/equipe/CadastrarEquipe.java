package com.br.placarbr_api.application.usecases.equipe;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.application.usecases.endereco.CriarEndereco;
import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.exception.ValidacaoException;

public class CadastrarEquipe {

	private final RepositorioDeEquipe repositorio;
	private final CriarEndereco criarEndereco;
	private final ValidacaoEquipe validacaoEquipe;

	public CadastrarEquipe(RepositorioDeEquipe repositorio, CriarEndereco criarEndereco, ValidacaoEquipe validacaoEquipe) {
		this.repositorio = repositorio;
		this.criarEndereco = criarEndereco;
		this.validacaoEquipe = validacaoEquipe;
	}

	public Equipe cadastrar(Equipe equipe) {
		this.validacaoEquipe.validarCadastro(equipe);

		if (equipe.getEndereco().isEnderecoValido()) {
			Endereco endereco = this.criarEndereco.cadastrarEndereco(equipe.getEndereco());
			equipe.setEndereco(endereco);
			return this.repositorio.cadastrar(equipe);
		}
		throw new ValidacaoException("Endereço preenchido incorretamente");

	}
}
