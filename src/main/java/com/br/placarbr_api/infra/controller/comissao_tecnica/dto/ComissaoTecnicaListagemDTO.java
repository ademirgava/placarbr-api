package com.br.placarbr_api.infra.controller.comissao_tecnica.dto;

import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;
import com.br.placarbr_api.infra.controller.comissao_tecnica_tipo.dto.ComissaoTecnicaTipoDetalheDTO;
import com.br.placarbr_api.infra.persistence.comissao_tecnica.ComissaoTecnicaEntity;

public record ComissaoTecnicaListagemDTO(
		Long id,
		String nome,
		String apelido,
		ComissaoTecnicaTipoDetalheDTO comissaoTecnicaTipo
		) {

	public ComissaoTecnicaListagemDTO(ComissaoTecnicaEntity comissaoTecnica) {
		this(comissaoTecnica.getId(), comissaoTecnica.getNome(), comissaoTecnica.getApelido(), new ComissaoTecnicaTipoDetalheDTO(comissaoTecnica.getComissaoTecnicaTipo()));
	}
	
	public ComissaoTecnicaListagemDTO(ComissaoTecnica comissaoTecnica) {
		this(comissaoTecnica.getId(), comissaoTecnica.getNome(), comissaoTecnica.getApelido(), new ComissaoTecnicaTipoDetalheDTO(comissaoTecnica.getComissaoTecnicaTipo()));
	}
}
