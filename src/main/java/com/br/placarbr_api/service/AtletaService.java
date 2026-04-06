package com.br.placarbr_api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.AtletaAtualizaDTO;
import com.br.placarbr_api.domain.dto.AtletaCadastroDTO;
import com.br.placarbr_api.domain.dto.AtletaDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.AtletaListagemDTO;
import com.br.placarbr_api.domain.dto.AtletaVincularEquipeDTO;
import com.br.placarbr_api.domain.model.Atleta;
import com.br.placarbr_api.domain.model.Endereco;
import com.br.placarbr_api.domain.model.Equipe;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.repository.AtletaRepository;

import jakarta.validation.Valid;

@Service
public class AtletaService {

	@Autowired
	private AtletaRepository repository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EquipeService equipeService;
	
	public AtletaDetalhamentoDTO cadastrar(AtletaCadastroDTO dto) {
		if (repository.existsByCpf(dto.cpf())) {
			throw new ValidacaoException("Já existe um atleta cadastro com o CPF: " + dto.cpf());
		}
		Endereco endereco = enderecoService.cadastrar(dto.endereco());
		
		Atleta atleta = new Atleta(dto, endereco);
		if (dto.equipeId() != null) {
			Equipe equipe = equipeService.buscarEquipePeloIdReference(dto.equipeId());
			atleta.setEquipe(equipe);
		}
		return new AtletaDetalhamentoDTO(repository.save(atleta));
	}

	public AtletaDetalhamentoDTO buscarAtleta(Long id) {
		Atleta jogador = repository.getReferenceById(id);
		return new AtletaDetalhamentoDTO(jogador);
	}

	public Page<AtletaDetalhamentoDTO> listarAtletas(Pageable paginacao) {
		return repository.findAll(paginacao).map(AtletaDetalhamentoDTO::new);
	}

	public AtletaDetalhamentoDTO atualizarAtleta(AtletaAtualizaDTO dto) {
		Atleta jogador = repository.getReferenceById(dto.id());
		jogador.atualizar(dto);
		return new AtletaDetalhamentoDTO(jogador);
	}

	public Atleta buscarAtletaReference(Long atletaId) {
		return repository.findById(atletaId).orElseThrow(()-> new NotFoundExecption("Atleta com id: "+atletaId+" não encontrado!"));
	}

	public Page<AtletaListagemDTO> listarAtletasPorEquipeId(Pageable paginacao, Long equipeId) {
		return repository.findAllByEquipeId(paginacao, equipeId).map(AtletaListagemDTO::new);
	}

	public Page<AtletaDetalhamentoDTO> listarAtletasPorNome(Pageable paginacao, String nome) {
		return repository.findByNomeStartingWith(paginacao, nome).map(AtletaDetalhamentoDTO::new);
	}

	public AtletaDetalhamentoDTO vincularAtletaNaEquipe(AtletaVincularEquipeDTO dto) {
		Atleta atleta = buscarAtletaReference(dto.atletaId());
		Equipe equipe = equipeService.buscarEquipePeloIdReference(dto.equipeId());
		atleta.vincularEquipe(equipe);
		return new AtletaDetalhamentoDTO(atleta);
	}

	public AtletaDetalhamentoDTO desvincularAtletaNaEquipe(AtletaVincularEquipeDTO dto) {
		Atleta atleta = buscarAtletaReference(dto.atletaId());
		atleta.desvincularEquipe();
		return new AtletaDetalhamentoDTO(atleta);
	}
}
