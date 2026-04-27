package com.br.placarbr_api.infra.controller.comissao_tecnica_tipo;

import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;
import com.br.placarbr_api.infra.persistence.comissao_tecnica_tipo.ComissaoTecnicaTipoEntity;

public record ComissaoTecnicaTipoDetalheDTO(Long id, String nome,String descricao) {

	public ComissaoTecnicaTipoDetalheDTO(ComissaoTecnicaTipoEntity comissaoTecnicaTipo) {
		this(comissaoTecnicaTipo.getId(), comissaoTecnicaTipo.getNome(), comissaoTecnicaTipo.getDescricao());
	}

	public ComissaoTecnicaTipoDetalheDTO(ComissaoTecnicaTipo comissaoTecnicaTipo) {
		this(comissaoTecnicaTipo.getId(), comissaoTecnicaTipo.getNome(), comissaoTecnicaTipo.getDescricao());
	}


}
