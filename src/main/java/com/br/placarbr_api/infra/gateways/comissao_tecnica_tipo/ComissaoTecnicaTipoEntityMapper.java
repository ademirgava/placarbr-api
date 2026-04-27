package com.br.placarbr_api.infra.gateways.comissao_tecnica_tipo;

import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;
import com.br.placarbr_api.infra.controller.comissao_tecnica_tipo.ComissaoTecnicaTipoAtualizaDTO;
import com.br.placarbr_api.infra.controller.comissao_tecnica_tipo.ComissaoTecnicaTipoCadastraDTO;
import com.br.placarbr_api.infra.persistence.comissao_tecnica_tipo.ComissaoTecnicaTipoEntity;

public class ComissaoTecnicaTipoEntityMapper {

	public ComissaoTecnicaTipoEntity toEntity(ComissaoTecnicaTipo comissaoTecnicaTipo) {
		return new ComissaoTecnicaTipoEntity(comissaoTecnicaTipo.getId(), comissaoTecnicaTipo.getNome(),
				comissaoTecnicaTipo.getDescricao(), comissaoTecnicaTipo.getDataCriacao());
	}

	public ComissaoTecnicaTipo toDomain(ComissaoTecnicaTipoEntity tipoEntity) {
		if (tipoEntity == null) {
			return null;
		}
		return new ComissaoTecnicaTipo(tipoEntity.getId(), tipoEntity.getNome(), tipoEntity.getDescricao());
	}

	public ComissaoTecnicaTipo toDomain(ComissaoTecnicaTipoCadastraDTO dto) {
		return new ComissaoTecnicaTipo(dto.nome(), dto.descricao());
	}

	public ComissaoTecnicaTipo toDomain(ComissaoTecnicaTipoAtualizaDTO dto) {
		return new ComissaoTecnicaTipo(dto.id(), dto.nome(), dto.descricao());
	}

	public ComissaoTecnicaTipo toDomain(Long comissaoTecnicaTipoId) {
		return new ComissaoTecnicaTipo(comissaoTecnicaTipoId);
	}
}
