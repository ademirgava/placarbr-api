package com.br.placarbr_api.domain.dto;

import com.br.placarbr_api.domain.model.CampeonatoFase;
import com.br.placarbr_api.domain.model.TipoFase;

public record CampeonatoFaseListagemDTO(Long id, String nome,String descricao,TipoFase fase,Integer classificados, Integer quantidadeGrupos, Integer quantidadeTimes, Boolean idaVolta, Integer ordemFase) {

	public CampeonatoFaseListagemDTO(CampeonatoFase fase) {
		this(fase.getId(), fase.getNome(), fase.getDescricao(), fase.getTipoFase(), fase.getClassificados() == null ? 0: fase.getClassificados() , fase.getQuantidadeGrupos() == null ? 0: fase.getQuantidadeGrupos(), fase.getQuantidadeTimes() == null ? 0: fase.getQuantidadeTimes(), fase.getIdaVolta(), fase.getOrdemFase());
	}
}
