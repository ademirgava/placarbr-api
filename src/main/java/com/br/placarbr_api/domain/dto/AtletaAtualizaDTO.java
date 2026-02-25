package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.model.TipoPePredominante;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtletaAtualizaDTO(
		@NotNull
		Long id,
		String nome, 
		String apelido, 
		@NotBlank(message = "E-mail obrigatório!")
		@Email
		String email, 
		String descricao, 
		@Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$")
		String cpf, 
		String rg,
		TipoPePredominante pePredominante,
		LocalDate dataNascimento,
		@Pattern(regexp = "^\\(\\d{2}\\)9?\\d{4}-\\d{4}$")
		String celular,
		EnderecoCadastroDTO endereco) {

}
