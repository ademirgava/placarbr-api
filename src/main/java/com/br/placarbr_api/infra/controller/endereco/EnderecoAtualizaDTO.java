package com.br.placarbr_api.infra.controller.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoAtualizaDTO(
		@NotNull
		Long id,
		@NotBlank
		String logradouro,
		@NotBlank
		String numero,
		@NotBlank
		String bairro,
		@NotBlank
		String cidade,
		@NotBlank
		@Pattern(regexp = "^\\d{5}-?\\d{3}$")
		String cep,
		@NotBlank
		String uf,
		String complemento) {

}
