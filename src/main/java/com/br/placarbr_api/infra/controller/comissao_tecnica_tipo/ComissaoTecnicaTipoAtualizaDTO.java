package com.br.placarbr_api.infra.controller.comissao_tecnica_tipo;

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
