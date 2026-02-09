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
		CampeonatoTime campeonatoTime = new CampeonatoTime();
		campeonatoTime.setCampeonato(campeonatoService.buscarCampeonatoPorId(dto.campeonatoId()));
		campeonatoTime.setEquipe(equipeService.buscarEquipePeloIdReference(dto.equipeId()));
		CampeonatoTime novoCampeonatoTime = repository.save(campeonatoTime);
		return new CampeonatoTimeDetalhamentoDTO(novoCampeonatoTime);
	}

	public CampeonatoTime cadastrarTimeReference(Long campeonatoTimeId) {
		return repository.getReferenceById(campeonatoTimeId);
	}

	public CampeonatoTimeJogadoresDTO listarJogadoresTime(Long id) {
		CampeonatoTime campeonatoTime = repository.getReferenceById(id);
		EquipeListagemDTO equipeListagemDTO = new EquipeListagemDTO(campeonatoTime.getEquipe());
		List<CampeonatoJogadoresDetalhamentoDTO> listaJogadores = campeonatoJogadoresService.buscarJogadores(campeonatoTime);
		return new CampeonatoTimeJogadoresDTO(equipeListagemDTO, listaJogadores);
	}
}
