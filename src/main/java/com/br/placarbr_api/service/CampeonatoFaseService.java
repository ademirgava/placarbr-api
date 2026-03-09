package com.br.placarbr_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.CampeonatoFaseAtualizaDTO;
import com.br.placarbr_api.domain.dto.CampeonatoFaseCadastroDTO;
import com.br.placarbr_api.domain.dto.CampeonatoFaseListagemDTO;
import com.br.placarbr_api.domain.dto.CampeonatoFaseReordenarDTO;
import com.br.placarbr_api.domain.model.Campeonato;
import com.br.placarbr_api.domain.model.CampeonatoFase;
import com.br.placarbr_api.domain.model.TipoFase;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.repository.CampeonatoFaseRepository;

@Service
public class CampeonatoFaseService {

	@Autowired
	private CampeonatoFaseRepository repository;

	@Autowired
	private CampeonatoService campeonatoService;

	public List<CampeonatoFaseListagemDTO> buscarFasesPorCampeonatoId(Long id) {
		return repository.findByCampeonatoId(id).stream().map(CampeonatoFaseListagemDTO::new).toList();
	}

	public CampeonatoFaseListagemDTO cadastrarFase(CampeonatoFaseCadastroDTO dto) {
		Campeonato campeonato = campeonatoService.buscarCampeonatoPorId(dto.campeonatoId());

		if (dto.fase().equals(TipoFase.GRUPOS) && dto.quantidadeGrupos() == null) {
			throw new ValidacaoException("Quantidade de grupos não pode ser nulo quando o tipo da fase é GRUPOS");
		}

		CampeonatoFase campeonatoFase = repository.save(new CampeonatoFase(dto, campeonato));
		return new CampeonatoFaseListagemDTO(campeonatoFase);
	}

	public CampeonatoFaseListagemDTO buscarFasePorId(Long id) {
		CampeonatoFase campeonatoFase = buscarCampeonatoFasePorId(id);
		return new CampeonatoFaseListagemDTO(campeonatoFase);
	}

	public CampeonatoFaseListagemDTO atualizar(CampeonatoFaseAtualizaDTO dto) {
		CampeonatoFase campeonatoFase = buscarCampeonatoFasePorId(dto.id());
		campeonatoFase.atualizar(dto);
		return new CampeonatoFaseListagemDTO(campeonatoFase);
	}

	public void deletarFase(Long id) {
		repository.delete(buscarCampeonatoFasePorId(id));
	}
	
	public List<CampeonatoFaseListagemDTO> reordenarFases(CampeonatoFaseReordenarDTO dto) {
		List<CampeonatoFase> fases = new ArrayList<CampeonatoFase>();
		dto.fases().forEach(fase -> {
			CampeonatoFase campeonatoFase = buscarCampeonatoFasePorId(fase.campeonatoFaseId());
			campeonatoFase.setOrdemFase(fase.ordem());
			fases.add(campeonatoFase);
		});
		return fases.stream().sorted(java.util.Comparator.comparingInt(CampeonatoFase::getOrdemFase))
				.map(CampeonatoFaseListagemDTO::new).toList();
	}
	
	public CampeonatoFase buscarCampeonatoFasePorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundExecption("Fase com id: "+id+" não encontrado!"));
	}

	public CampeonatoFase buscarCampeonatoFasePorIdECampeonatoId(Long campeonatoFaseId, Long campeonatoId) {
		return repository.findByIdAndCampeonatoId(campeonatoFaseId, campeonatoId).orElseThrow(() -> new NotFoundExecption("Fase com id: "+campeonatoFaseId+" para campeonato com id: "+campeonatoId+" não encontrado!"));
	}
}
