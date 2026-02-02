package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.model.Jogador;
import com.br.placarbr_api.domain.model.TipoPePredominante;
import com.fasterxml.jackson.annotation.JsonProperty;

public record JogadorDetalhamentoDTO(Long id,String nome, String apelido, String descricao,String cpf, String rg,TipoPePredominante pePredominante,LocalDate dataNascimento, String celular, @JsonProperty(value = "endereco") EnderecoDetalhamentoDTO enderecoDetalhamentoDTO) {

	public JogadorDetalhamentoDTO(Jogador jogador) {
		this(jogador.getId(), jogador.getNome(), jogador.getApelido(), jogador.getDescricao(), jogador.getCpf(), jogador.getRg(), jogador.getPePredominante(), jogador.getDataNascimento(), jogador.getCelular(), new EnderecoDetalhamentoDTO(jogador.getEndereco()));
	}

}
