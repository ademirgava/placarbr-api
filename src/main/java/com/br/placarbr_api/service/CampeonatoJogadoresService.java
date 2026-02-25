package com.br.placarbr_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.CampeonatoJogadorCadastroDTO;
import com.br.placarbr_api.domain.dto.CampeonatoJogadoresDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.CampeonatoTimeDetalhamentoDTO;
import com.br.placarbr_api.domain.model.CampeonatoJogador;
import com.br.placarbr_api.domain.model.CampeonatoTime;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.repository.CampeonatoJogadoresRepository;

@Service
public class CampeonatoJogadoresService {

	@Autowired
	private CampeonatoJogadoresRepository repository;

	@Autowired
	@Lazy
	private CampeonatoTimesService campeonatoTimesService;
	
	@Autowired
	private AtletaService atletaService;
	
	public CampeonatoTimeDetalhamentoDTO cadastrarCampeonatoJogador(CampeonatoJogadorCadastroDTO dto) {
		if (repository.existsByAtletaIdAndCampeonatoTimeId(dto.jogadorId(), dto.campeonatoTimeId())) {
			throw new ValidacaoException("Jogador já cadastrado para este time!");
		};
		
		CampeonatoJogador campeonatoJogador = new CampeonatoJogador(dto);
		campeonatoJogador.setAtleta(atletaService.buscarAtletaReference(dto.jogadorId()));
		campeonatoJogador.setCampeonatoTime(campeonatoTimesService.buscarCampeonatoTimePorId(dto.campeonatoTimeId()));
		repository.save(campeonatoJogador);
		return new CampeonatoTimeDetalhamentoDTO(campeonatoJogador.getCampeonatoTime());
	}

	public List<CampeonatoJogadoresDetalhamentoDTO> buscarJogadores(CampeonatoTime campeonatoTime) {
		List<CampeonatoJogador> jogadores = repository.findAllByCampeonatoTime(campeonatoTime);
		return jogadores.stream().map(CampeonatoJogadoresDetalhamentoDTO::new).toList();
	} 
	
	public void deletarJogadoresPorCampeonatoTimeId(Long id) {
		repository.deleteByCampeonatoTimeId(id);
	}
}
