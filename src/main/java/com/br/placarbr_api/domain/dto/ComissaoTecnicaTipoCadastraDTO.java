package com.br.placarbr_api.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record ComissaoTecnicaTipoCadastraDTO(
		@NotBlank
		String nome,
		String descricao
		) {

}
