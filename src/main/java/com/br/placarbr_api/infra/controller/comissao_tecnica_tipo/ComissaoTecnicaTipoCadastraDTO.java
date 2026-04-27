package com.br.placarbr_api.infra.controller.comissao_tecnica_tipo;

import jakarta.validation.constraints.NotBlank;

public record ComissaoTecnicaTipoCadastraDTO(
		@NotBlank
		String nome,
		String descricao
		) {

}
