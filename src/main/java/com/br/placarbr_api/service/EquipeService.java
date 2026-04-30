package com.br.placarbr_api.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.br.placarbr_api.infra.controller.equipe.dto.EquipeAtualizaDTO;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeCadastroDTO;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeDetalhamentoDTO;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;
import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;
import com.br.placarbr_api.infra.persistence.equipe.EquipeRepository;

import jakarta.validation.Valid;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository repository;
	
	@Autowired
	private EnderecoService enderecoService;

	public EquipeDetalhamentoDTO cadastrar(EquipeCadastroDTO dto) {
		EnderecoEntity endereco = enderecoService.cadastrar(dto.endereco());
		EquipeEntity novaEquipe = new EquipeEntity(dto, endereco);
		EquipeEntity equipe = repository.save(novaEquipe);
		return new EquipeDetalhamentoDTO(equipe);
	}

	public Page<EquipeDetalhamentoDTO> listarEquipes(Pageable paginacao) {
		return repository.findAll(paginacao).map(EquipeDetalhamentoDTO::new);
	}

	public EquipeDetalhamentoDTO buscarEquipe(Long id) {
		return new EquipeDetalhamentoDTO(repository.getReferenceById(id));
	}
	
	public EquipeEntity buscarEquipePeloIdReference(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundExecption("Equipe com id: "+id+" não encontrada!"));
	}

	public EquipeDetalhamentoDTO atualizarEquipe(@Valid EquipeAtualizaDTO dto) {
		EquipeEntity equipe = repository.getReferenceById(dto.id());
//		equipe.atualizar(dto);
		return new EquipeDetalhamentoDTO(equipe);
	}

	public void inativarEquipe(Long id) {
		EquipeEntity equipe = repository.getReferenceById(id);
		equipe.inativar();
	}

	public EquipeDetalhamentoDTO reativarEquipe(Long id) {
		EquipeEntity equipe = repository.getReferenceById(id);
		equipe.ativarEquipe();
		return new EquipeDetalhamentoDTO(equipe);
	}

	
}
