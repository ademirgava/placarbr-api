package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.model.Equipe;

public record EquipeDetalhamentoDTO(
		Long id,
		String nome,
		String sigla,
		byte[] logomarca,
		LocalDate dataFundacao,
		String corPrincipal,
		String corSecundaria,
		Boolean ativa,
		EnderecoDetalhamentoDTO endereco
		) {

	public EquipeDetalhamentoDTO(Equipe equipe) {
		this(equipe.getId(), equipe.getNome(), equipe.getSigla(), equipe.getLogomarca(), equipe.getDataFundacao(), equipe.getCorPrincipal(), equipe.getCorSecundaria(), equipe.getAtivo(), new EnderecoDetalhamentoDTO(equipe.getEndereco()));
	}

}
