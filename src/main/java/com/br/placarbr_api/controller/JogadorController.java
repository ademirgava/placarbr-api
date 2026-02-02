package com.br.placarbr_api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.domain.dto.JogadorAtualizaDTO;
import com.br.placarbr_api.domain.dto.JogadorCadastroDTO;
import com.br.placarbr_api.domain.dto.JogadorDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.JogadorListagemDTO;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.service.JogadorService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

	@Autowired
	private JogadorService jogadorService;

	@PostMapping
	@Transactional
	public ResponseEntity criarJogador(@RequestBody @Valid JogadorCadastroDTO dto, UriComponentsBuilder builder) {
		try {
			JogadorDetalhamentoDTO jogador = jogadorService.cadastrar(dto);
			var uri = builder.path("/jogadores/{id}").buildAndExpand(jogador.id()).toUri();
			return ResponseEntity.created(uri).body(jogador);
		} catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
		}
		
	}

	@GetMapping
	public ResponseEntity<Page<JogadorListagemDTO>> listarJogadores(@PageableDefault(size =10, sort = {"nome"}) Pageable paginacao) {
		return ResponseEntity.ok(jogadorService.listarJogadores(paginacao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detalhamentoJogador(@PathVariable Long id) {
		return ResponseEntity.ok(jogadorService.buscarJogador(id));
	}
	
	@PutExchange
	@Transactional
	public ResponseEntity atualizarJogadro(@RequestBody @Valid JogadorAtualizaDTO dto) {
		return ResponseEntity.ok(jogadorService.atualizarJogador(dto));
	}
}
