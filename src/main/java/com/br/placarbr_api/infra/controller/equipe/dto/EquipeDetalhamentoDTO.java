package com.br.placarbr_api.infra.controller.equipe.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.controller.endereco.EnderecoDetalhamentoDTO;
import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;

public record EquipeDetalhamentoDTO(Long id, String nome, String sigla, byte[] logomarca, LocalDate dataFundacao,
		String corPrincipal, String corSecundaria, Boolean ativa, EnderecoDetalhamentoDTO endereco) {

	public EquipeDetalhamentoDTO(EquipeEntity equipe) {
		this(equipe.getId(), equipe.getNome(), equipe.getSigla(), equipe.getLogomarca(), equipe.getDataFundacao(),
				equipe.getCorPrincipal(), equipe.getCorSecundaria(), equipe.getAtivo(),
				new EnderecoDetalhamentoDTO(equipe.getEndereco()));
	}

	public EquipeDetalhamentoDTO(Equipe equipe) {
		this(equipe.getId(), equipe.getNome(), equipe.getSigla(), equipe.getLogomarca(), equipe.getDataFundacao(),
				equipe.getCorPrincipal(), equipe.getCorSecundaria(), equipe.getAtivo(),
				new EnderecoDetalhamentoDTO(equipe.getEndereco()));
	}

}
