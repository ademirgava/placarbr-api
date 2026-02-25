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
import com.br.placarbr_api.domain.model.CampeonatoTime;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.repository.CameponatoJogoRepository;

@Service
public class CampeonatoJogoService {

	@Autowired
	private CameponatoJogoRepository repository;

	@Autowired
	private CampeonatoFaseService faseService;
	
	@Autowired
	private CampeonatoTimesService timesService;
	
	@Autowired
	private CampeonatoService campeonatoService;
	
	public CampeonatoJogoDetalhamentoDTO cadastrarCameponatoJogo(CampeonatoJogoCadastroDTO dto) {
		if (dto.cameponatoTimeMandateId() == dto.cameponatoTimeVisitanteId()) {
			throw new ValidacaoException("Não é possível solicitar jogo com time mandante e visitante sendo o mesmo!");
		}
		
		if (repository.existsByTimeMandanteIdAndTimeVisitanteId(dto.cameponatoTimeMandateId(), dto.cameponatoTimeVisitanteId())) {
			throw new ValidacaoException("Este jogo já esta cadastrado!");			
		}
		
		if (repository.temRodadaAndTimeMandanteIdOrTimeVisitanteId(dto.cameponatoTimeMandateId(), dto.cameponatoTimeMandateId(), dto.rodada()) > 0) {
			throw new ValidacaoException("Este time id: "+dto.cameponatoTimeMandateId()+" já tem jogo para rodada: "+dto.rodada());			
		}
		
		if (repository.temRodadaAndTimeMandanteIdOrTimeVisitanteId(dto.cameponatoTimeVisitanteId(), dto.cameponatoTimeVisitanteId(), dto.rodada()) > 0) {
			throw new ValidacaoException("Este time id: "+dto.cameponatoTimeVisitanteId()+" já tem jogo para rodada: "+dto.rodada());			
		}
		
		Campeonato campeonato = campeonatoService.buscarCampeonatoPorId(dto.campeonatoId());
		CampeonatoFase fase = faseService.buscarCampeonatoFasePorId(dto.campeonatoFaseId());
		
		CampeonatoTime timeVisitante = timesService.buscarCampeonatoTimePorIdAndCampeonatoId(dto.cameponatoTimeVisitanteId(), dto.campeonatoId());
		CampeonatoTime timeMandante = timesService.buscarCampeonatoTimePorIdAndCampeonatoId(dto.cameponatoTimeMandateId(), dto.campeonatoId());
		
		return new CampeonatoJogoDetalhamentoDTO(repository.save(new CampeonatoJogo(dto.rodada(), timeVisitante, timeMandante, fase, campeonato)));
	}

	public Page<CampeonatoJogoDetalhamentoDTO> listarCampeonatoJogosPorCampeonatoId(Pageable paginacao, Long campeonatoID) {
		return repository.findByCampeonatoId(campeonatoID, paginacao).map(CampeonatoJogoDetalhamentoDTO::new);
	}
}
