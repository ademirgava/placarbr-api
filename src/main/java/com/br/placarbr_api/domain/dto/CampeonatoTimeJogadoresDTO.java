package com.br.placarbr_api.domain.dto;

import java.util.List;

public record CampeonatoTimeJogadoresDTO(EquipeListagemDTO equipe, List<CampeonatoJogadoresDetalhamentoDTO> jogadores) {

}
