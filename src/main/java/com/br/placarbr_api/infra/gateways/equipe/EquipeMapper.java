package com.br.placarbr_api.infra.gateways.equipe;

import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeAtualizaDTO;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeCadastroDTO;
import com.br.placarbr_api.infra.gateways.endereco.EnderecoEntityMapper;
import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;

public class EquipeMapper {

	private final EnderecoEntityMapper enderecoEntityMapper;

	public EquipeMapper(EnderecoEntityMapper enderecoEntityMapper) {
		this.enderecoEntityMapper = enderecoEntityMapper;
	}

	public Equipe toDomain(EquipeEntity entity) {
		return new Equipe(entity.getId(), entity.getNome(), entity.getSigla(), entity.getAtivo(), entity.getLogomarca(),
				entity.getDataFundacao(), entity.getDataCriacao(), entity.getCorPrincipal(), entity.getCorSecundaria(),
				enderecoEntityMapper.toDomain(entity.getEndereco()));
	}

	public Equipe toDomain(EquipeCadastroDTO entity) {
		return new Equipe(entity.nome(), entity.sigla(), entity.dataFundacao(), entity.corPrincipal(),
				entity.corSecundaria(), enderecoEntityMapper.toDomain(entity.endereco()));
	}

	public EquipeEntity toEntity(Equipe equipe) {
		return new EquipeEntity(equipe.getNome(), equipe.getSigla(), equipe.getAtivo(), equipe.getDataFundacao(),
				equipe.getDataCriacao(), equipe.getCorPrincipal(), equipe.getCorSecundaria(),
				enderecoEntityMapper.toEntity(equipe.getEndereco()));
	}

	public Equipe toDomain(EquipeAtualizaDTO dto) {
		return new Equipe(dto.id(), dto.nome(), dto.sigla(), dto.dataFundacao(), dto.corPrincipal(), dto.corSecundaria(),
				dto.endereco() != null ? enderecoEntityMapper.toDomain(dto.endereco()) : null);
	}
}
