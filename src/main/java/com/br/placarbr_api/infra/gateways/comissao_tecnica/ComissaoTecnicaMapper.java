package com.br.placarbr_api.infra.gateways.comissao_tecnica;

import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;
import com.br.placarbr_api.infra.controller.comissao_tecnica.ComissaoTecnicaCadastraDTO;
import com.br.placarbr_api.infra.gateways.comissao_tecnica_tipo.ComissaoTecnicaTipoEntityMapper;
import com.br.placarbr_api.infra.gateways.endereco.EnderecoEntityMapper;
import com.br.placarbr_api.infra.persistence.comissao_tecnica.ComissaoTecnicaEntity;

public class ComissaoTecnicaMapper {
	
	private final ComissaoTecnicaTipoEntityMapper mapperTipo;
	private final EnderecoEntityMapper enderecoMapper;

	
	public ComissaoTecnicaMapper(ComissaoTecnicaTipoEntityMapper mapperTipo, EnderecoEntityMapper enderecoMapper) {
		this.mapperTipo = mapperTipo;
		this.enderecoMapper = enderecoMapper;
	}


	public ComissaoTecnica toDomain(ComissaoTecnicaEntity entity) {
		return new ComissaoTecnica(entity.getId(), entity.getCpf(), entity.getRg(), entity.getRegistro(), entity.getRegistroTipo(), entity.getNome(), entity.getEmail(), entity.getApelido(), entity.getDataNascimento(), entity.getFoto(), entity.getDescricao(), entity.getCelular(), entity.getDataCriacao(), enderecoMapper.toDomain(entity.getEndereco()), mapperTipo.toDomain(entity.getComissaoTecnicaTipo()));
	}


	public ComissaoTecnica toDomain(ComissaoTecnicaCadastraDTO dto) {
		return new ComissaoTecnica(dto.cpf(), dto.rg(), dto.registro(), dto.registroTipo(), dto.nome(), dto.email(), dto.apelido(), dto.dataNascimento(), null, dto.descricao(), dto.celular(), enderecoMapper.toDomain(dto.enderecoCadastroDTO()),
				mapperTipo.toDomain(dto.comissaoTecnicaTipoId()));
	}


	public ComissaoTecnicaEntity toEntity(ComissaoTecnica domain) {
		return new ComissaoTecnicaEntity(domain.getCpf(), domain.getRg(), domain.getRegistro(), domain.getRegistroTipo(), domain.getNome(), domain.getEmail(), domain.getApelido(), domain.getDataNascimento(), domain.getFoto(), domain.getDescricao(), domain.getCelular(), domain.getDataCriacao());
	}


}
