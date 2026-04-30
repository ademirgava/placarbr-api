package com.br.placarbr_api.infra.controller.equipe.dto;

import java.time.LocalDate;

import com.br.placarbr_api.infra.controller.endereco.EnderecoAtualizaDTO;

public record EquipeAtualizaDTO(
		Long id,
		String nome,
		String sigla,
		LocalDate dataFundacao,
		String corPrincipal,
		String corSecundaria,
		EnderecoAtualizaDTO endereco
		) {

}
