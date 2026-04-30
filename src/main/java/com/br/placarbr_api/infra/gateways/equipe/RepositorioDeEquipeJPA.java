package com.br.placarbr_api.infra.gateways.equipe;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.placarbr_api.application.gateways.equipe.RepositorioDeEquipe;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeDetalhamentoDTO;
import com.br.placarbr_api.infra.gateways.pageable.PageableMapper;
import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;
import com.br.placarbr_api.infra.persistence.equipe.EquipeRepository;

public class RepositorioDeEquipeJPA implements RepositorioDeEquipe {

	private final EquipeMapper equipeMapper;
	private final EquipeRepository repostirio;
	private final PageableMapper pageableMapper;

	public RepositorioDeEquipeJPA(EquipeRepository repostirio, EquipeMapper equipeMapper,
			PageableMapper pageableMapper) {
		this.repostirio = repostirio;
		this.equipeMapper = equipeMapper;
		this.pageableMapper = pageableMapper;
	}

	@Override
	public Equipe cadastrar(Equipe equipe) {
		EquipeEntity equipeEntity = this.repostirio.save(equipeMapper.toEntity(equipe));
		return equipeMapper.toDomain(equipeEntity);
	}

	@Override
	public boolean existsByNome(String nome) {
		return this.repostirio.existsByNome(nome);
	}

	@Override
	public boolean existsBySigla(String sigla) {
		return this.repostirio.existsBySigla(sigla);
	}

	@Override
	public Pagina<Equipe> listarTodas(Paginacao paginacao) {
		Pageable pageable = pageableMapper.toPageable(paginacao);
		Page<EquipeEntity> equipesEntity = this.repostirio.findAll(pageable);
		return new Pagina<Equipe>(equipesEntity.getContent().stream().map(equipeMapper::toDomain).toList(),
				equipesEntity.getNumber(), equipesEntity.getNumberOfElements(), equipesEntity.getTotalElements());
	}

	@Override
	public Equipe buscarPorId(Long equipeId) {
		Optional<EquipeEntity> opEquipe = this.repostirio.findById(equipeId);
		if (opEquipe.isPresent())
			return equipeMapper.toDomain(opEquipe.get());

		return null;
	}

	@Override
	public Equipe desativar(Equipe equipe) {
		EquipeEntity equipeEntity = this.repostirio.getReferenceById(equipe.getId());
		equipeEntity.setAtivo(equipe.getAtivo());
		return equipeMapper.toDomain(this.repostirio.save(equipeEntity));
	}

	@Override
	public Equipe ativarEquipe(Equipe equipe) {
		EquipeEntity equipeEntity = this.repostirio.getReferenceById(equipe.getId());
		equipeEntity.setAtivo(equipe.getAtivo());
		return equipeMapper.toDomain(this.repostirio.save(equipeEntity));
	}

	@Override
	public Equipe atualizar(Equipe equipe) {
		EquipeEntity equipeEntity = this.repostirio.getReferenceById(equipe.getId());
		equipeEntity.atualizar(equipe);
		return equipeMapper.toDomain(this.repostirio.save(equipeEntity));
	}

	@Override
	public Equipe adicionarLogo(Equipe equipe) {
		EquipeEntity equipeEntity = this.repostirio.getReferenceById(equipe.getId());
		equipeEntity.setLogomarca(equipe.getLogomarca());
		return equipeMapper.toDomain(equipeEntity);
	}

}
