package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.model.Atleta;
import com.br.placarbr_api.domain.model.TipoPePredominante;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AtletaDetalhamentoDTO(Long id,String nome, String apelido, String email, String descricao,String cpf, String rg,TipoPePredominante pePredominante,LocalDate dataNascimento, String celular, @JsonProperty(value = "endereco") EnderecoDetalhamentoDTO enderecoDetalhamentoDTO, @JsonProperty(value = "equipe") EquipeListagemDTO equipe ) {

	public AtletaDetalhamentoDTO(Atleta atleta) {
		this(atleta.getId(), atleta.getNome(), atleta.getApelido(), atleta.getEmail(), atleta.getDescricao(), atleta.getCpf(), atleta.getRg(), atleta.getPePredominante(), atleta.getDataNascimento(), atleta.getCelular(), new EnderecoDetalhamentoDTO(atleta.getEndereco()), new EquipeListagemDTO(atleta.getEquipe()));
	}

}
