package com.br.placarbr_api.infra.gateways.atleta;

import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.controller.atleta.dto.AtletaAtualizaDTO;
import com.br.placarbr_api.infra.controller.atleta.dto.AtletaCadastroDTO;
import com.br.placarbr_api.infra.gateways.endereco.EnderecoEntityMapper;
import com.br.placarbr_api.infra.gateways.equipe.EquipeMapper;
import com.br.placarbr_api.infra.persistence.atleta.AtletaEntity;

public class AtletaMapper {

	private final EnderecoEntityMapper enderecoEntityMapper;
	private final EquipeMapper equipeMapper;

	public AtletaMapper(EnderecoEntityMapper enderecoEntityMapper, EquipeMapper equipeMapper) {
		this.enderecoEntityMapper = enderecoEntityMapper;
		this.equipeMapper = equipeMapper;
	}

	public Atleta toDomain(AtletaCadastroDTO dto) {
		return new Atleta(dto.cpf(), dto.rg(), dto.nome(), dto.email(), dto.apelido(), dto.dataNascimento(),
				dto.pePredominante(), dto.descricao(), dto.celular(), enderecoEntityMapper.toDomain(dto.endereco()),
				dto.equipeId() != null ? new Equipe(dto.equipeId()) : null);
	}

	public AtletaEntity toEntity(Atleta atleta) {
		return new AtletaEntity(atleta, enderecoEntityMapper.toEntity(atleta.getEndereco()));
	}

	public Atleta toDomain(AtletaEntity dto) {
		return new Atleta(dto.getId(), dto.getCpf(), dto.getRg(), dto.getNome(), dto.getEmail(), dto.getApelido(),
				dto.getDataNascimento(), dto.getPePredominante(), dto.getDescricao(), dto.getCelular(),
				enderecoEntityMapper.toDomain(dto.getEndereco()),
				dto.getEquipe() != null ? equipeMapper.toDomain(dto.getEquipe()) : null);
	}

	public Atleta toDomain(AtletaAtualizaDTO dto) {
		return new Atleta(dto.id(), dto.cpf(), dto.rg(), dto.nome(), dto.email(), dto.apelido(), dto.dataNascimento(),
				dto.pePredominante(), dto.descricao(), dto.celular(), enderecoEntityMapper.toDomain(dto.endereco()));
	}

}
