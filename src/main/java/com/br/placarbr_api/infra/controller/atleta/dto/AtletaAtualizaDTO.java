package com.br.placarbr_api.infra.controller.atleta.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.entities.atleta.TipoPePredominante;
import com.br.placarbr_api.infra.controller.endereco.EnderecoCadastroDTO;

public record AtletaAtualizaDTO(Long id, String nome, String apelido, String email, String descricao, String cpf,
		String rg, TipoPePredominante pePredominante, LocalDate dataNascimento, String celular,
		EnderecoCadastroDTO endereco) {

}
