package com.br.placarbr_api.infra.controller.comissao_tecnica;

import java.time.LocalDate;

import com.br.placarbr_api.domain.dto.EnderecoDetalhamentoDTO;
import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;
import com.br.placarbr_api.infra.controller.comissao_tecnica_tipo.ComissaoTecnicaTipoDetalheDTO;
import com.br.placarbr_api.infra.persistence.comissao_tecnica.ComissaoTecnicaEntity;

public record ComissaoTecnicaDetalheDTO(
		Long id,
		String cpf,
		String rg,
		String registro,
		String registroTipo,
		String nome,
		String email,
		String apelido,
		LocalDate dataNascimento,
		String descricao,
		String celular,
		EnderecoDetalhamentoDTO endereco,
		ComissaoTecnicaTipoDetalheDTO comissaoTecnicaTipo
		) {

	public ComissaoTecnicaDetalheDTO(ComissaoTecnicaEntity comissaoTecnica) {
		this(comissaoTecnica.getId(), comissaoTecnica.getCpf(), comissaoTecnica.getRg(), comissaoTecnica.getRegistro(), comissaoTecnica.getRegistroTipo(), comissaoTecnica.getNome(), comissaoTecnica.getEmail(), comissaoTecnica.getApelido(), comissaoTecnica.getDataNascimento(), comissaoTecnica.getDescricao(), comissaoTecnica.getCelular(), new EnderecoDetalhamentoDTO(comissaoTecnica.getEndereco()), new ComissaoTecnicaTipoDetalheDTO(comissaoTecnica.getComissaoTecnicaTipo()));
	}

	public ComissaoTecnicaDetalheDTO(ComissaoTecnica comissaoTecnica) {
		this(comissaoTecnica.getId(), comissaoTecnica.getCpf(), comissaoTecnica.getRg(), comissaoTecnica.getRegistro(), comissaoTecnica.getRegistroTipo(), comissaoTecnica.getNome(), comissaoTecnica.getEmail(), comissaoTecnica.getApelido(), comissaoTecnica.getDataNascimento(), comissaoTecnica.getDescricao(), comissaoTecnica.getCelular(), new EnderecoDetalhamentoDTO(comissaoTecnica.getEndereco()), new ComissaoTecnicaTipoDetalheDTO(comissaoTecnica.getComissaoTecnicaTipo()));
	}

}
