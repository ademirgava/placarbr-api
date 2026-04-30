package com.br.placarbr_api.infra.controller.atleta.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.domain.entities.atleta.TipoPePredominante;
import com.br.placarbr_api.infra.controller.endereco.EnderecoDetalhamentoDTO;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeListagemDTO;
import com.br.placarbr_api.infra.persistence.atleta.AtletaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AtletaDetalhamentoDTO(Long id, String nome, String apelido, String email, String descricao, String cpf,
		String rg, TipoPePredominante pePredominante, LocalDate dataNascimento, String celular,
		@JsonProperty(value = "endereco") EnderecoDetalhamentoDTO enderecoDetalhamentoDTO,
		@JsonProperty(value = "equipe") EquipeListagemDTO equipe) {

	public AtletaDetalhamentoDTO(AtletaEntity atleta) {
		this(atleta.getId(), atleta.getNome(), atleta.getApelido(), atleta.getEmail(), atleta.getDescricao(),
				atleta.getCpf(), atleta.getRg(), atleta.getPePredominante(), atleta.getDataNascimento(),
				atleta.getCelular(), new EnderecoDetalhamentoDTO(atleta.getEndereco()),
				atleta.getEquipe() != null ? new EquipeListagemDTO(atleta.getEquipe()) : null);
	}

	public AtletaDetalhamentoDTO(Atleta domain) {
		this(domain.getId(), domain.getNome(), domain.getApelido(), domain.getEmail(), domain.getDescricao(),
				domain.getCpf(), domain.getRg(), domain.getPePredominante(), domain.getDataNascimento(),
				domain.getCelular(), new EnderecoDetalhamentoDTO(domain.getEndereco()),
				domain.getEquipe() != null ? new EquipeListagemDTO(domain.getEquipe()) : null);

	}

}
