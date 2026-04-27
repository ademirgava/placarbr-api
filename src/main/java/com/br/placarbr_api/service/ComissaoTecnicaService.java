package com.br.placarbr_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.infra.controller.comissao_tecnica.ComissaoTecnicaAtualizaDTO;
import com.br.placarbr_api.infra.controller.comissao_tecnica.ComissaoTecnicaCadastraDTO;
import com.br.placarbr_api.infra.controller.comissao_tecnica.ComissaoTecnicaDetalheDTO;
import com.br.placarbr_api.infra.controller.comissao_tecnica.ComissaoTecnicaListagemDTO;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.infra.persistence.comissao_tecnica.ComissaoTecnicaEntity;
import com.br.placarbr_api.infra.persistence.comissao_tecnica.ComissaoTecnicaRepository;

@Service
public class ComissaoTecnicaService {
/*
	@Autowired
	private ComissaoTecnicaRepository repository;

	@Autowired
	private ComissaoTecnicaTipoService tecnicaTipoService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public ComissaoTecnicaDetalheDTO cadastrar(ComissaoTecnicaCadastraDTO dto) {
		ComissaoTecnicaEntity comissaoTecnica = new ComissaoTecnicaEntity(dto);
		comissaoTecnica.setEndereco(enderecoService.cadastrar(dto.enderecoCadastroDTO()));
	//	comissaoTecnica.setComissaoTecnicaTipo(tecnicaTipoService.comissaoTipoPorId(dto.comissaoTecnicaTipoId()));
		return new ComissaoTecnicaDetalheDTO(repository.save(comissaoTecnica));
	}

	public Page<ComissaoTecnicaListagemDTO> listarTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(ComissaoTecnicaListagemDTO::new);
	}

	public ComissaoTecnicaDetalheDTO buscarComissaoPorId(Long id) {
		return new ComissaoTecnicaDetalheDTO(buscarComissaoTecnicaPorId(id));
	}
	
	public ComissaoTecnicaEntity buscarComissaoTecnicaPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundExecption("Comissão técnica com id: "+id+" não encontrado!"));
	}

	public ComissaoTecnicaDetalheDTO atualizar(ComissaoTecnicaAtualizaDTO dto) {
		ComissaoTecnicaEntity comissaoTecnica = repository.getReferenceById(dto.id());
		comissaoTecnica.atuzalizar(dto);
	//	comissaoTecnica.setComissaoTecnicaTipo(tecnicaTipoService.comissaoTipoPorId(dto.comissaoTecnicaTipoId()));
		return new ComissaoTecnicaDetalheDTO(comissaoTecnica);
	}
*/
}
