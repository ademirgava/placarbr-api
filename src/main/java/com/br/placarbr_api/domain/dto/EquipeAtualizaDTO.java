package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record EquipeAtualizaDTO(
		@NotNull
		Long id,
		String nome,
		String sigla,
		LocalDate dataFundacao,
		String corPrincipal,
		String corSecundaria,
		EnderecoCadastroDTO endereco
		) {

}
