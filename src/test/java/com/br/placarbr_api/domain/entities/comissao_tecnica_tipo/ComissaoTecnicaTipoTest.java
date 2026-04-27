package com.br.placarbr_api.domain.entities.comissao_tecnica_tipo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComissaoTecnicaTipoTest {

	private static final String DESCRICAO = "descricao";
	private static final String NOME = "Tipo nome";

	@Test
	public void nãoDeveCadastrarTipoComNomeVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new ComissaoTecnicaTipo(null, DESCRICAO));
	}

	@Test
	public void nãoDeveCadastrarTipoComNomeEmBranco() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new ComissaoTecnicaTipo("", DESCRICAO));
	}

	@Test
	public void deveCadastrarTipo() {
		ComissaoTecnicaTipo comissaoTecnicaTipo = new ComissaoTecnicaTipo(NOME, DESCRICAO);
		Assertions.assertEquals(NOME, comissaoTecnicaTipo.getNome());
		Assertions.assertEquals(DESCRICAO, comissaoTecnicaTipo.getDescricao());
	}
}
