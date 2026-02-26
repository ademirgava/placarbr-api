package com.br.placarbr_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.ComissaoTecnicaAtualizaDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaCadastraDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaDetalheDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaListagemDTO;
import com.br.placarbr_api.domain.model.ComissaoTecnica;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.repository.ComissaoTecnicaRepository;

@Service
public class ComissaoTecnicaService {

	@Autowired
	private ComissaoTecnicaRepository repository;

	@Autowired
	private ComissaoTecnicaTipoService tecnicaTipoService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public ComissaoTecnicaDetalheDTO cadastrar(ComissaoTecnicaCadastraDTO dto) {
		ComissaoTecnica comissaoTecnica = new ComissaoTecnica(dto);
		comissaoTecnica.setEndereco(enderecoService.cadastrar(dto.enderecoCadastroDTO()));
		comissaoTecnica.setComissaoTecnicaTipo(tecnicaTipoService.comissaoTipoPorId(dto.comissaoTecnicaTipoId()));
		return new ComissaoTecnicaDetalheDTO(repository.save(comissaoTecnica));
	}

	public Page<ComissaoTecnicaListagemDTO> listarTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(ComissaoTecnicaListagemDTO::new);
	}

	public ComissaoTecnicaDetalheDTO buscarComissaoPorId(Long id) {
		return new ComissaoTecnicaDetalheDTO(buscarComissaoTecnicaPorId(id));
	}
	
	public ComissaoTecnica buscarComissaoTecnicaPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundExecption("Comissão técnica com id: "+id+" não encontrado!"));
	}

	public ComissaoTecnicaDetalheDTO atualizar(ComissaoTecnicaAtualizaDTO dto) {
		ComissaoTecnica comissaoTecnica = repository.getReferenceById(dto.id());
		comissaoTecnica.atuzalizar(dto);
		comissaoTecnica.setComissaoTecnicaTipo(tecnicaTipoService.comissaoTipoPorId(dto.comissaoTecnicaTipoId()));
		return new ComissaoTecnicaDetalheDTO(comissaoTecnica);
	}

}
