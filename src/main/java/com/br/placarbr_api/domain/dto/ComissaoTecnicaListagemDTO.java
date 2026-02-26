package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.ComissaoTecnica;

public record ComissaoTecnicaListagemDTO(
		Long id,
		String nome,
		String apelido,
		ComissaoTecnicaTipoDetalheDTO comissaoTecnicaTipo
		) {

	public ComissaoTecnicaListagemDTO(ComissaoTecnica comissaoTecnica) {
		this(comissaoTecnica.getId(), comissaoTecnica.getNome(), comissaoTecnica.getApelido(), new ComissaoTecnicaTipoDetalheDTO(comissaoTecnica.getComissaoTecnicaTipo()));
	}
}
