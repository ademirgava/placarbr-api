package com.br.placarbr_api.infra.gateways.comissao_tecnica;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.br.placarbr_api.application.gateways.comissao_tecnica.RepositorioDeComissaoTecnica;
import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.BuscarComissaoTecnicaTipoPorId;
import com.br.placarbr_api.application.usecases.endereco.CriarEndereco;
import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;
import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;
import com.br.placarbr_api.infra.gateways.comissao_tecnica_tipo.ComissaoTecnicaTipoEntityMapper;
import com.br.placarbr_api.infra.gateways.endereco.EnderecoEntityMapper;
import com.br.placarbr_api.infra.persistence.comissao_tecnica.ComissaoTecnicaEntity;
import com.br.placarbr_api.infra.persistence.comissao_tecnica.ComissaoTecnicaRepository;

public class RepositorioDeComissaoTecnicaJPA implements RepositorioDeComissaoTecnica{

	private final ComissaoTecnicaRepository repository;
	private final ComissaoTecnicaMapper mapper;
	private final ComissaoTecnicaTipoEntityMapper tipoEntityMapper;
	private final BuscarComissaoTecnicaTipoPorId buscarComissaoTecnicaTipoPorId;
	private final CriarEndereco criarEndereco;
	private final EnderecoEntityMapper enderecoEntityMapper;
	
	public RepositorioDeComissaoTecnicaJPA(ComissaoTecnicaRepository repository, ComissaoTecnicaMapper mapper, ComissaoTecnicaTipoEntityMapper tipoEntityMapper, BuscarComissaoTecnicaTipoPorId buscarComissaoTecnicaTipoPorId, CriarEndereco criarEndereco, EnderecoEntityMapper enderecoEntityMapper) {
		this.repository = repository;
		this.mapper = mapper;
		this.tipoEntityMapper = tipoEntityMapper;
		this.buscarComissaoTecnicaTipoPorId = buscarComissaoTecnicaTipoPorId;
		this.criarEndereco = criarEndereco;
		this.enderecoEntityMapper = enderecoEntityMapper;
	}

	@Override
	public ComissaoTecnica cadastrarComissaoTecnica(ComissaoTecnica comissaoTecnica) {
		ComissaoTecnicaEntity entity = mapper.toEntity(comissaoTecnica);
		
		Endereco endereco = criarEndereco.cadastrarEndereco(comissaoTecnica.getEndereco());
		entity.setEndereco(enderecoEntityMapper.toEntity(endereco));
		
		ComissaoTecnicaTipo tipoComissao = buscarComissaoTecnicaTipoPorId.buscarTipoPorId(comissaoTecnica.getComissaoTecnicaTipo().getId());
		entity.setComissaoTecnicaTipo(tipoEntityMapper.toEntity(tipoComissao));
		
		return mapper.toDomain(repository.save(entity));
	}

	@Override
	public ComissaoTecnica buscarPorIdComissaoTecnica(Long id) {
		ComissaoTecnicaEntity entity = repository.getReferenceById(id);
		return mapper.toDomain(entity);
	}

	@Override
	public Pagina<ComissaoTecnica> listar(Paginacao paginacao) {
		Sort sort = paginacao.direcao().equalsIgnoreCase("desc") ? Sort.by(paginacao.sortBy()).descending() : Sort.by(paginacao.sortBy()).ascending();
		Pageable page = PageRequest.of(paginacao.page(), paginacao.size(), sort);
		Page<ComissaoTecnicaEntity> paginaEntity = repository.findAll(page);
		return new Pagina<>(paginaEntity.getContent().stream().map(mapper::toDomain).toList(), paginaEntity.getNumber(), paginaEntity.getSize(), paginaEntity.getTotalElements());
	}

}
