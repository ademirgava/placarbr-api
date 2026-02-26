package com.br.placarbr_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.ComissaoTecnicaTipoAtualizaDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaTipoCadastraDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaTipoDetalheDTO;
import com.br.placarbr_api.domain.model.ComissaoTecnicaTipo;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.repository.ComissaoTecnicaTipoRepository;

@Service
public class ComissaoTecnicaTipoService {

	@Autowired
	private ComissaoTecnicaTipoRepository repository;

	public ComissaoTecnicaTipoDetalheDTO cadastrar(ComissaoTecnicaTipoCadastraDTO dto) {
		ComissaoTecnicaTipo tipo = new ComissaoTecnicaTipo(dto);
		ComissaoTecnicaTipo comissaoTecnicaTipo = repository.save(tipo);
		return new ComissaoTecnicaTipoDetalheDTO(comissaoTecnicaTipo);
	}

	public Page<ComissaoTecnicaTipoDetalheDTO> listar(Pageable paginacao) {
		return repository.findAll(paginacao).map(ComissaoTecnicaTipoDetalheDTO::new);
	}

	public ComissaoTecnicaTipoDetalheDTO buscarTipoPorId(Long id) {
		ComissaoTecnicaTipo ComissaoTecnicaTipo = comissaoTipoPorId(id);
		return new ComissaoTecnicaTipoDetalheDTO(ComissaoTecnicaTipo);
	}
	
	public ComissaoTecnicaTipo comissaoTipoPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundExecption("Tipo de comissão com id: "+ id + " não encontrado!"));
	}

	public ComissaoTecnicaTipoDetalheDTO atualizar(ComissaoTecnicaTipoAtualizaDTO dto) {
		ComissaoTecnicaTipo comissaoTecnicaTipo = repository.getReferenceById(dto.id());
		comissaoTecnicaTipo.atualizar(dto);
		return new ComissaoTecnicaTipoDetalheDTO(comissaoTecnicaTipo);
	}

}
