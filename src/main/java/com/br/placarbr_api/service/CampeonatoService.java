package com.br.placarbr_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.CampeonatoCadastroDTO;
import com.br.placarbr_api.domain.dto.CampeonatoDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.CampeonatoListagemDTO;
import com.br.placarbr_api.domain.model.Campeonato;

@Service
public class CampeonatoService {

	@Autowired
	private CampeonatoRepository repository;

	public Page<CampeonatoListagemDTO> listarCampeonatos(Pageable paginacao) {
		return repository.findAll(paginacao).map(CampeonatoListagemDTO::new );
	}

	public CampeonatoDetalhamentoDTO buscarCampeonatoPeloId(Long id) {
		return new CampeonatoDetalhamentoDTO(repository.getReferenceById(id));
	}
	
	public Campeonato buscarReferenceCampeonatoPeloId(Long id) {
		return repository.getReferenceById(id);
	}

	public CampeonatoDetalhamentoDTO cadastrarCampeonato(CampeonatoCadastroDTO dto) {
		Campeonato campeonato = repository.save(new Campeonato(dto));
		return new CampeonatoDetalhamentoDTO(campeonato);
	}
}
