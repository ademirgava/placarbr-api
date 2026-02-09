package com.br.placarbr_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.CampeonatoCadastroDTO;
import com.br.placarbr_api.domain.dto.CampeonatoDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.CampeonatoListagemDTO;
import com.br.placarbr_api.domain.model.Campeonato;
import com.br.placarbr_api.infra.exception.ValidacaoException;

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
	
	public Campeonato buscarCampeonatoPorId(Long id) {
		return repository.findById(id).orElseThrow(()-> new ValidacaoException("Campeonato com id: " + id + " não existe!"));
	}

	public CampeonatoDetalhamentoDTO cadastrarCampeonato(CampeonatoCadastroDTO dto) {
		Campeonato campeonato = repository.save(new Campeonato(dto));
		return new CampeonatoDetalhamentoDTO(campeonato);
	}

}
