package com.br.placarbr_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.CampeonatoJogoCadastroDTO;
import com.br.placarbr_api.domain.dto.CampeonatoJogoDetalhamentoDTO;
import com.br.placarbr_api.domain.model.Campeonato;
import com.br.placarbr_api.domain.model.CampeonatoFase;
import com.br.placarbr_api.domain.model.CampeonatoJogo;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;
import com.br.placarbr_api.repository.CameponatoJogoRepository;

@Service
public class CampeonatoJogoService {

	@Autowired
	private CameponatoJogoRepository repository;

	@Autowired
	private CampeonatoFaseService faseService;
	
	@Autowired
	private CampeonatoService campeonatoService;
	
	@Autowired
	private EquipeService equipeService;
	
	public CampeonatoJogoDetalhamentoDTO cadastrarCameponatoJogo(CampeonatoJogoCadastroDTO dto) {
		if (dto.cameponatoTimeMandateId() == dto.cameponatoTimeVisitanteId()) {
			throw new ValidacaoException("Não é possível solicitar jogo com time mandante e visitante sendo o mesmo!");
		}
		
		if (repository.existsByEquipeMandanteIdAndEquipeVisitanteId(dto.cameponatoTimeMandateId(), dto.cameponatoTimeVisitanteId())) {
			throw new ValidacaoException("Este jogo já esta cadastrado!");			
		}
		
		if (repository.temRodadaAndEquipeMandanteIdOrEquipeVisitanteId(dto.cameponatoTimeMandateId(), dto.cameponatoTimeMandateId(), dto.rodada()) > 0) {
			throw new ValidacaoException("Este time id: "+dto.cameponatoTimeMandateId()+" já tem jogo para rodada: "+dto.rodada());			
		}
		
		if (repository.temRodadaAndEquipeMandanteIdOrEquipeVisitanteId(dto.cameponatoTimeVisitanteId(), dto.cameponatoTimeVisitanteId(), dto.rodada()) > 0) {
			throw new ValidacaoException("Este time id: "+dto.cameponatoTimeVisitanteId()+" já tem jogo para rodada: "+dto.rodada());			
		}
		
		Campeonato campeonato = campeonatoService.buscarCampeonatoPorId(dto.campeonatoId());
		CampeonatoFase fase = faseService.buscarCampeonatoFasePorId(dto.campeonatoFaseId());
		EquipeEntity equipeVisitante = equipeService.buscarEquipePeloIdReference(dto.cameponatoTimeVisitanteId());
		EquipeEntity equipeMandante = equipeService.buscarEquipePeloIdReference(dto.cameponatoTimeMandateId());
		
		return new CampeonatoJogoDetalhamentoDTO(repository.save(new CampeonatoJogo(dto.rodada(), equipeVisitante, equipeMandante, fase, campeonato)));
	}

	public Page<CampeonatoJogoDetalhamentoDTO> listarCampeonatoJogosPorCampeonatoId(Pageable paginacao, Long campeonatoID) {
		return repository.findByCampeonatoId(campeonatoID, paginacao).map(CampeonatoJogoDetalhamentoDTO::new);
	}
}
