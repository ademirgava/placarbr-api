package com.br.placarbr_api.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.br.placarbr_api.domain.dto.EquipeAtualizaDTO;
import com.br.placarbr_api.domain.dto.EquipeCadastroDTO;
import com.br.placarbr_api.domain.dto.EquipeDetalhamentoDTO;
import com.br.placarbr_api.domain.model.Endereco;
import com.br.placarbr_api.domain.model.Equipe;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.repository.EquipeRepository;

import jakarta.validation.Valid;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository repository;
	
	@Autowired
	private EnderecoService enderecoService;

	public EquipeDetalhamentoDTO cadastrar(EquipeCadastroDTO dto) {
		Endereco endereco = enderecoService.cadastrar(dto.endereco());
		Equipe novaEquipe = new Equipe(dto, endereco);
		Equipe equipe = repository.save(novaEquipe);
		return new EquipeDetalhamentoDTO(equipe);
	}

	public Page<EquipeDetalhamentoDTO> listarEquipes(Pageable paginacao) {
		return repository.findAll(paginacao).map(EquipeDetalhamentoDTO::new);
	}

	public EquipeDetalhamentoDTO buscarEquipe(Long id) {
		return new EquipeDetalhamentoDTO(repository.getReferenceById(id));
	}
	
	public Equipe buscarEquipePeloIdReference(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundExecption("Equipe com id: "+id+" não encontrada!"));
	}

	public EquipeDetalhamentoDTO atualizarEquipe(@Valid EquipeAtualizaDTO dto) {
		Equipe equipe = repository.getReferenceById(dto.id());
		equipe.atualizar(dto);
		return new EquipeDetalhamentoDTO(equipe);
	}

	public void inativarEquipe(Long id) {
		Equipe equipe = repository.getReferenceById(id);
		equipe.inativar();
	}

	public EquipeDetalhamentoDTO reativarEquipe(Long id) {
		Equipe equipe = repository.getReferenceById(id);
		equipe.ativarEquipe();
		return new EquipeDetalhamentoDTO(equipe);
	}

	public EquipeDetalhamentoDTO addLogomarca(Long id, MultipartFile logomarca) throws IOException {
		Equipe equipe = buscarEquipePeloIdReference(id);
		equipe.setLogomarca(logomarca.getBytes());
		return new EquipeDetalhamentoDTO(repository.save(equipe));
	}
	
}
