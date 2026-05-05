package com.br.placarbr_api.application.usecases.equipe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.exception.ValidacaoException;

@ExtendWith(MockitoExtension.class)
public class ValidacaoEquipeTest {

	private static final String NOME = "Nome";

	private static final String SIGLA = "SIG";

	@Mock
	private RepositorioDeEquipe repositorio;
	
	@InjectMocks
	private ValidacaoEquipe validacaoEquipe;

	@Test
	public void naoDeveValidarEnderecoComNomeExistente() {
		Mockito.when(this.repositorio.existsByNome(NOME)).thenReturn(true);
		
		Assertions.assertThrows(ValidacaoException.class, () -> this.validacaoEquipe.validarCadastro(getEquipe()));
	}

	@Test
	public void naoDeveValidarEnderecoComSiglaExistente() {
		Mockito.when(this.repositorio.existsByNome(NOME)).thenReturn(false);
		Mockito.when(this.repositorio.existsBySigla(SIGLA)).thenReturn(true);
		Assertions.assertThrows(ValidacaoException.class, () -> this.validacaoEquipe.validarCadastro(getEquipe()));
	}

	@Test
	public void deveValidarEndereco() {
		Mockito.when(this.repositorio.existsByNome(NOME)).thenReturn(false);
		Mockito.when(this.repositorio.existsBySigla(SIGLA)).thenReturn(false);
		this.validacaoEquipe.validarCadastro(getEquipe());
	}

	
	private Equipe getEquipe() {
		Equipe equipe = new Equipe();
		equipe.setNome(NOME);
		equipe.setSigla(SIGLA);
		return equipe;
	}
}
