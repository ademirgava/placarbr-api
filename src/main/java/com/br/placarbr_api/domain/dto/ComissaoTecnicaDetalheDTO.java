package com.br.placarbr_api.domain.dto;

import java.time.LocalDate;

import com.br.placarbr_api.domain.model.ComissaoTecnica;

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

	public ComissaoTecnicaDetalheDTO(ComissaoTecnica comissaoTecnica) {
		this(comissaoTecnica.getId(), comissaoTecnica.getCpf(), comissaoTecnica.getRg(), comissaoTecnica.getRegistro(), comissaoTecnica.getRegistroTipo(), comissaoTecnica.getNome(), comissaoTecnica.getEmail(), comissaoTecnica.getApelido(), comissaoTecnica.getDataNascimento(), comissaoTecnica.getDescricao(), comissaoTecnica.getCelular(), new EnderecoDetalhamentoDTO(comissaoTecnica.getEndereco()), new ComissaoTecnicaTipoDetalheDTO(comissaoTecnica.getComissaoTecnicaTipo()));
	}

}
