package com.br.placarbr_api.application.usecases.atleta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.infra.exception.ValidacaoException;

@ExtendWith(MockitoExtension.class)
public class VincularEquipeAtletaTest {

	private static final String NOME = "Nome";

	@Mock
	private RepositorioDeAtleta repositorioDeAtletaMock;

	@InjectMocks
	private VincularEquipeAtleta vincularEquipeAtleta;

	@Test
	public void naoDeverVincularAtletaComAtletaIdNulo() {
		Assertions.assertThrows(ValidacaoException.class, () -> this.vincularEquipeAtleta.vincular(1l, null));
	}

	@Test
	public void naoDeverVincularAtletaComEquipeIdNulo() {
		Assertions.assertThrows(ValidacaoException.class, () -> this.vincularEquipeAtleta.vincular(null, 2l));
	}

	@Test
	public void deveVincularAtleta() {
		Atleta atleta = new Atleta();
		atleta.setId(1l);
		atleta.setNome(NOME);

		Mockito.when(this.repositorioDeAtletaMock.vincularEquipeAtleta(1l, 1l)).thenReturn(atleta);

		Atleta atletaVinculado = this.vincularEquipeAtleta.vincular(1l, 1l);

		Assertions.assertEquals(1l, atletaVinculado.getId());
		Assertions.assertEquals(NOME, atletaVinculado.getNome());

	}
}
