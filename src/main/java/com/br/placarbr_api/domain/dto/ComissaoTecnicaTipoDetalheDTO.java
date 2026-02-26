package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.ComissaoTecnicaTipo;

public record ComissaoTecnicaTipoDetalheDTO(Long id, String nome,String descricao) {

	public ComissaoTecnicaTipoDetalheDTO(ComissaoTecnicaTipo comissaoTecnicaTipo) {
		this(comissaoTecnicaTipo.getId(), comissaoTecnicaTipo.getNome(), comissaoTecnicaTipo.getDescricao());
	}


}
