package com.br.placarbr_api.infra.controller.comissao_tecnica;

import java.time.LocalDate;

import com.br.placarbr_api.domain.dto.EnderecoCadastroDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ComissaoTecnicaCadastraDTO(
		@NotBlank
		String cpf,
		String rg,
		String registro,
		String registroTipo,
		@NotBlank
		String nome,
		@NotBlank
		@Email
		String email,
		String apelido,
		@NotNull
		LocalDate dataNascimento,
		String descricao,
		@NotBlank
		String celular,
		EnderecoCadastroDTO enderecoCadastroDTO,
		@NotNull
		Long comissaoTecnicaTipoId
		) {

}
