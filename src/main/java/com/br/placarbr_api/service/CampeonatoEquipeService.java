package com.br.placarbr_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.CampeonatoEquipeCadastraDTO;
import com.br.placarbr_api.domain.dto.CampeonatoEquipeDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.CampeonatoEquipeListagemPorCampeonatoDTO;
import com.br.placarbr_api.domain.model.Campeonato;
import com.br.placarbr_api.domain.model.CampeonatoEquipe;
import com.br.placarbr_api.domain.model.CampeonatoFase;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;
import com.br.placarbr_api.repository.CampeonatoEquipeRepository;

@Service
public class CampeonatoEquipeService {

	@Autowired
	private CampeonatoEquipeRepository repository;

	@Autowired
	private CampeonatoService campeonatoService;
	
	@Autowired
	private EquipeService equipeService;
	
	@Autowired
	private CampeonatoFaseService campeonatoFaseService;
	
	public CampeonatoEquipeDetalhamentoDTO cadastrar(CampeonatoEquipeCadastraDTO dto) {
		Campeonato campeonato = campeonatoService.buscarCampeonatoPorId(dto.campeonatoId());
		EquipeEntity equipe = equipeService.buscarEquipePeloIdReference(dto.equipeId());
		CampeonatoFase campeonatoFase = campeonatoFaseService.buscarCampeonatoFasePorIdECampeonatoId(dto.campeonatoFaseId(), dto.campeonatoId());
		
		if (repository.existsByCampeonatoAndCampeonatoFaseAndEquipe(campeonato, campeonatoFase, equipe)) {
			throw new ValidacaoException("Equipe: "+equipe.getNome()+ " já esta cadastrado para este campeonato e fase!");
		}
		
		CampeonatoEquipe campeonatoEquipe = new CampeonatoEquipe();
		campeonatoEquipe.setCampeonato(campeonato);
		campeonatoEquipe.setEquipe(equipe);
		campeonatoEquipe.setCampeonatoFase(campeonatoFase);
		
		CampeonatoEquipe campeonatoEquipeSalvo = repository.save(campeonatoEquipe);
		
		return new CampeonatoEquipeDetalhamentoDTO(campeonatoEquipeSalvo);
	}

	public Page<CampeonatoEquipeDetalhamentoDTO> listarTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(CampeonatoEquipeDetalhamentoDTO::new);
	}

	public CampeonatoEquipeListagemPorCampeonatoDTO listarPorCampeonatoId(Long id) {
		Campeonato campeonato = campeonatoService.buscarCampeonatoPorId(id);
		return new CampeonatoEquipeListagemPorCampeonatoDTO(campeonato);
	}

}
