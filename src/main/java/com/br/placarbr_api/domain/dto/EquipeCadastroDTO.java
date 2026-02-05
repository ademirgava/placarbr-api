package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EquipeCadastroDTO(
		@NotNull
		@Size(min = 6)
		String nome,
		@NotBlank
		@Size(min = 2, max = 2)
		String sigla,
		LocalDate dataFundacao,
		@NotBlank
		String corPrincipal,
		@NotBlank
		String corSecundaria,
		EnderecoCadastroDTO endereco
		) {

}
