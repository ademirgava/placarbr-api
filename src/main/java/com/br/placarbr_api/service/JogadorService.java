package com.br.placarbr_api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.JogadorAtualizaDTO;
import com.br.placarbr_api.domain.dto.JogadorCadastroDTO;
import com.br.placarbr_api.domain.dto.JogadorDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.JogadorListagemDTO;
import com.br.placarbr_api.domain.model.Endereco;
import com.br.placarbr_api.domain.model.Jogador;
import com.br.placarbr_api.infra.exception.NotFoundExecption;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.repository.JogadorRepository;

import jakarta.validation.Valid;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository repository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public JogadorDetalhamentoDTO cadastrar(JogadorCadastroDTO dto) {
		if (repository.existsByCpf(dto.cpf())) {
			throw new ValidacaoException("Já existe um jogador cadastro com o CPF: " + dto.cpf());
		}
		Endereco endereco = enderecoService.cadastrar(dto.endereco());
		Jogador jogador = new Jogador(dto, endereco);
		return new JogadorDetalhamentoDTO(repository.save(jogador));
	}

	public JogadorDetalhamentoDTO buscarJogador(Long id) {
		Jogador jogador = repository.getReferenceById(id);
		return new JogadorDetalhamentoDTO(jogador);
	}

	public Page<JogadorListagemDTO> listarJogadores(Pageable paginacao) {
		return repository.findAll(paginacao).map(JogadorListagemDTO::new);
	}

	public JogadorDetalhamentoDTO atualizarJogador(@Valid JogadorAtualizaDTO dto) {
		Jogador jogador = repository.getReferenceById(dto.id());
		jogador.atualizar(dto);
		return new JogadorDetalhamentoDTO(jogador);
	}

	public Jogador buscarJogadorReference(Long jogadorId) {
		return repository.findById(jogadorId).orElseThrow(()-> new NotFoundExecption("Jogador com id: "+jogadorId+" não encontrado!"));
	}
}
