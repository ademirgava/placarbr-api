package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CampeonatoCadastroDTO(
		@NotBlank
		@Size(max = 120)
		String nome,
		@NotBlank
		@Size(max = 255)
		String descricao,
		LocalDate dataInicio
		) {

}
