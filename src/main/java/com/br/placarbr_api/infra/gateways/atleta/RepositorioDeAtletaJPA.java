package com.br.placarbr_api.infra.gateways.atleta;

import org.springframework.data.domain.Page;

import com.br.placarbr_api.application.gateways.atleta.RepositorioDeAtleta;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.infra.gateways.pageable.PageableMapper;
import com.br.placarbr_api.infra.persistence.atleta.AtletaEntity;
import com.br.placarbr_api.infra.persistence.atleta.AtletaRepository;
import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;
import com.br.placarbr_api.infra.persistence.equipe.EquipeRepository;

public class RepositorioDeAtletaJPA implements RepositorioDeAtleta {

	private final AtletaRepository repositorio;
	private final AtletaMapper mapper;
	private final PageableMapper pageableMapper;
	private final EquipeRepository equipeRepository;

	public RepositorioDeAtletaJPA(AtletaRepository repositorio, AtletaMapper mapper, PageableMapper pageableMapper, EquipeRepository equipeRepository) {
		this.repositorio = repositorio;
		this.mapper = mapper;
		this.pageableMapper = pageableMapper;
		this.equipeRepository = equipeRepository;
	}

	@Override
	public Atleta cadastrar(Atleta atleta) {
		AtletaEntity entity = repositorio.save(mapper.toEntity(atleta));
		return mapper.toDomain(entity);
	}

	@Override
	public boolean existsByCpf(String cpf) {
		return repositorio.existsByCpf(cpf);
	}

	@Override
	public Pagina<Atleta> listar(Paginacao paginacao) {
		Page<AtletaEntity> atletasEntity = repositorio.findAll(pageableMapper.toPageable(paginacao));
		return new Pagina<Atleta>(atletasEntity.stream().map(mapper::toDomain).toList(), atletasEntity.getNumber(), atletasEntity.getNumberOfElements(), atletasEntity.getTotalElements());
	}

	@Override
	public Atleta buscarPorId(Long id) {
		AtletaEntity entity = repositorio.findById(id).orElseThrow(()-> new NotFoundExecption("Atleta não encontrado!"));
		return mapper.toDomain(entity);
	}

	@Override
	public Pagina<Atleta> listarPorEquipeIdAtletas(Paginacao paginacao, Long equipeId) {
		Page<AtletaEntity> atletasEntity = repositorio.findAllByEquipeId(pageableMapper.toPageable(paginacao), equipeId);
		return new Pagina<Atleta>(atletasEntity.getContent().stream().map(mapper::toDomain).toList(), atletasEntity.getNumber(), atletasEntity.getSize(), atletasEntity.getTotalElements());
	}

	@Override
	public Atleta atualizar(Atleta atleta) {
		AtletaEntity entity = repositorio.findById(atleta.getId()).orElseThrow(()-> new NotFoundExecption("Atleta não encontrado!"));
		entity.atualizar(atleta);
		return mapper.toDomain(entity);
	}

	@Override
	public Pagina<Atleta> listarPorNomeAtletas(String nome, Paginacao paginacao) {
		Page<AtletaEntity> atletasEntity = repositorio.findByNomeStartingWith(pageableMapper.toPageable(paginacao), nome);
		return new Pagina<Atleta>(atletasEntity.stream().map(mapper::toDomain).toList(), atletasEntity.getNumber(), atletasEntity.getNumberOfElements(), atletasEntity.getTotalElements());
	}

	@Override
	public Atleta desvicular(Long atletaId) {
		AtletaEntity entity = repositorio.findById(atletaId).orElseThrow(()-> new NotFoundExecption("Atleta não encontrado!"));
		entity.setEquipe(null);
		return mapper.toDomain(entity);
	}

	@Override
	public Atleta vincularEquipeAtleta(Long equipeId, Long atletaId) {
		EquipeEntity equipeEntity = this.equipeRepository.findById(equipeId).orElseThrow(()-> new NotFoundExecption("Equipe não encontrada!"));
		AtletaEntity atletaEntity = this.repositorio.getReferenceById(atletaId);
		atletaEntity.setEquipe(equipeEntity);
		return mapper.toDomain(atletaEntity);
	}

}
