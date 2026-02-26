package com.br.placarbr_api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ComissaoTecnicaTipoAtualizaDTO(
		@NotNull
		Long id,
		@NotBlank
		String nome,
		String descricao
		) {

}
