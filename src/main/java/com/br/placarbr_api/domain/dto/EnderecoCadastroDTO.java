package com.br.placarbr_api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoCadastroDTO(	
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
