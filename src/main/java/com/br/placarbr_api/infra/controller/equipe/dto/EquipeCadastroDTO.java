package com.br.placarbr_api.infra.controller.equipe.dto;

import java.time.LocalDate;

import com.br.placarbr_api.infra.controller.endereco.EnderecoCadastroDTO;

public record EquipeCadastroDTO(String nome, String sigla, LocalDate dataFundacao, String corPrincipal,
		String corSecundaria, EnderecoCadastroDTO endereco) {

}
