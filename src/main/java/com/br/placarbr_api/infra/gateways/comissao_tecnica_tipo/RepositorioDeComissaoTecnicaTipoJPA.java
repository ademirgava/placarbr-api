package com.br.placarbr_api.infra.gateways.comissao_tecnica_tipo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.br.placarbr_api.application.gateways.comissao_tecnica_tipo.RepositorioDeComissaoTecnicaTipo;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;
import com.br.placarbr_api.infra.persistence.comissao_tecnica_tipo.ComissaoTecnicaTipoEntity;
import com.br.placarbr_api.infra.persistence.comissao_tecnica_tipo.ComissaoTecnicaTipoRepository;

public class RepositorioDeComissaoTecnicaTipoJPA implements RepositorioDeComissaoTecnicaTipo{

	private final ComissaoTecnicaTipoRepository repository;
	private final ComissaoTecnicaTipoEntityMapper mapper;
	
	public RepositorioDeComissaoTecnicaTipoJPA(ComissaoTecnicaTipoRepository repository, ComissaoTecnicaTipoEntityMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public ComissaoTecnicaTipo cadastrar(ComissaoTecnicaTipo comissaoTecnicaTipo) {
		ComissaoTecnicaTipoEntity entity = mapper.toEntity(comissaoTecnicaTipo);
		return mapper.toDomain(repository.save(entity));
	}

	@Override
	public ComissaoTecnicaTipo buscarTipoPorId(Long id) {
		return mapper.toDomain(repository.getReferenceById(id));
	}

	@Override
	public ComissaoTecnicaTipo atualizarTipo(ComissaoTecnicaTipo comissaoTecnicaTipo) {
		ComissaoTecnicaTipoEntity entity = repository.getReferenceById(comissaoTecnicaTipo.getId());
		entity.atualizar(comissaoTecnicaTipo);
		return mapper.toDomain(entity);
	}

	@Override
	public Pagina<ComissaoTecnicaTipo> listar(Paginacao paginacao) {
		Sort sort = paginacao.direcao().equalsIgnoreCase("desc") ? Sort.by(paginacao.sortBy()).descending() : Sort.by(paginacao.sortBy()).ascending();
		Pageable pageable = PageRequest.of(paginacao.page(), paginacao.size(), sort);
		Page<ComissaoTecnicaTipoEntity> page = repository.findAll(pageable);
		return new Pagina<>(page.getContent().stream().map(mapper::toDomain).toList(), page.getNumber(), page.getSize(), page.getTotalElements());
	}


}
