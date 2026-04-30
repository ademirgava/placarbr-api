package com.br.placarbr_api.infra.controller.atleta.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.entities.atleta.TipoPePredominante;
import com.br.placarbr_api.infra.controller.endereco.EnderecoCadastroDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AtletaCadastroDTO(
		@NotBlank(message = "Nome obrigatório!")
		String nome, 
		String apelido, 
		String descricao, 
		@NotBlank(message = "E-mail obrigatório!")
		@Email
		String email, 
		@NotBlank
		@Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$")
		String cpf, 
		String rg,
		TipoPePredominante pePredominante,
		LocalDate dataNascimento,
		@Pattern(regexp = "^\\(\\d{2}\\)9?\\d{5}-\\d{4}$")
		String celular,
		EnderecoCadastroDTO endereco,
		Long equipeId) {

}
