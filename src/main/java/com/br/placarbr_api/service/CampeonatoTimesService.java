package com.br.placarbr_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.CampeonatoJogadoresDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.CampeonatoTimeDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.CampeonatoTimeJogadoresDTO;
import com.br.placarbr_api.domain.dto.CampeonatoTimesCadastroDTO;
import com.br.placarbr_api.domain.dto.EquipeListagemDTO;
import com.br.placarbr_api.domain.model.CampeonatoTime;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.repository.CameponatoTimesRepository;

@Service
public class CampeonatoTimesService {

	@Autowired
	private CameponatoTimesRepository repository;

	@Autowired
	private CampeonatoService campeonatoService;
	
	@Autowired
	private EquipeService equipeService;
	
	@Autowired
	private CampeonatoJogadoresService campeonatoJogadoresService;
	
	public CampeonatoTimeDetalhamentoDTO cadastrarTime(CampeonatoTimesCadastroDTO dto) {
		if (repository.existsByCampeonatoIdAndEquipeId(dto.campeonatoId(), dto.equipeId())) {
			throw new ValidacaoException("Equipe já cadastrada para este campeonato!");
		}
		
		CampeonatoTime campeonatoTime = new CampeonatoTime();
		campeonatoTime.setCampeonato(campeonatoService.buscarCampeonatoPorId(dto.campeonatoId()));
		campeonatoTime.setEquipe(equipeService.buscarEquipePeloIdReference(dto.equipeId()));
		CampeonatoTime novoCampeonatoTime = repository.save(campeonatoTime);
		return new CampeonatoTimeDetalhamentoDTO(novoCampeonatoTime);
	}

	public CampeonatoTime buscarCampeonatoTimePorId(Long campeonatoTimeId) {
		return repository.findById(campeonatoTimeId).orElseThrow(()-> new NotFoundExecption("Time com id: "+campeonatoTimeId+" não encontrado!"));
	}

	public CampeonatoTimeJogadoresDTO listarJogadoresTime(Long id) {
		CampeonatoTime campeonatoTime = buscarCampeonatoTimePorId(id);
		EquipeListagemDTO equipeListagemDTO = new EquipeListagemDTO(campeonatoTime.getEquipe());
		List<CampeonatoJogadoresDetalhamentoDTO> listaJogadores = campeonatoJogadoresService.buscarJogadores(campeonatoTime);
		return new CampeonatoTimeJogadoresDTO(equipeListagemDTO, listaJogadores);
	}

	public void deletarTime(Long id) {
		CampeonatoTime campeonatoTime = buscarCampeonatoTimePorId(id);
		campeonatoJogadoresService.deletarJogadoresPorCampeonatoTimeId(id);
		repository.delete(campeonatoTime);
	}
}
