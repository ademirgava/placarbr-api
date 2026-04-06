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

import com.br.placarbr_api.domain.dto.AtletaAtualizaDTO;
import com.br.placarbr_api.domain.dto.AtletaCadastroDTO;
import com.br.placarbr_api.domain.dto.AtletaDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.AtletaListagemDTO;
import com.br.placarbr_api.domain.dto.AtletaVincularEquipeDTO;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.service.AtletaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

	@Autowired
	private AtletaService atletaService;

	@PostMapping
	@Transactional
	public ResponseEntity criarAtleta(@RequestBody @Valid AtletaCadastroDTO dto, UriComponentsBuilder builder) {
		try {
			AtletaDetalhamentoDTO jogador = atletaService.cadastrar(dto);
			var uri = builder.path("/jogadores/{id}").buildAndExpand(jogador.id()).toUri();
			return ResponseEntity.created(uri).body(jogador);
		} catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
		}
		
	}

	@GetMapping
	public ResponseEntity<Page<AtletaDetalhamentoDTO>> listarAtleta(@PageableDefault(size =10, sort = {"nome"}) Pageable paginacao) {
		return ResponseEntity.ok(atletaService.listarAtletas(paginacao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AtletaDetalhamentoDTO> detalhamentoJogadorAtleta(@PathVariable Long id) {
		return ResponseEntity.ok(atletaService.buscarAtleta(id));
	}
	
	@GetMapping("/equipe/{id}")
	public ResponseEntity<Page<AtletaListagemDTO>> listarAtletasPorEquipeId(@PageableDefault(size =10, sort = {"nome"}) Pageable paginacao, @PathVariable Long id) {
		return ResponseEntity.ok(atletaService.listarAtletasPorEquipeId(paginacao, id));
	}
	
	@PutExchange
	@Transactional
	public ResponseEntity<AtletaDetalhamentoDTO> atualizarAtleta(@RequestBody @Valid AtletaAtualizaDTO dto) {
		return ResponseEntity.ok(atletaService.atualizarAtleta(dto));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Page<AtletaDetalhamentoDTO>> listarAtletasPorNome(@PageableDefault(size =10, sort = {"nome"}) Pageable paginacao, @PathVariable String nome) {
		return ResponseEntity.ok(atletaService.listarAtletasPorNome(paginacao, nome));
	}
	
	@PutExchange("/vincular-equipe")
	@Transactional
	public ResponseEntity<AtletaDetalhamentoDTO> vincularAtletaNaEquipe(@RequestBody @Valid AtletaVincularEquipeDTO dto) {
		return ResponseEntity.ok(atletaService.vincularAtletaNaEquipe(dto));
	}
	
	@PutExchange("/desvincular-equipe")
	@Transactional
	public ResponseEntity<AtletaDetalhamentoDTO> desvincularAtletaNaEquipe(@RequestBody @Valid AtletaVincularEquipeDTO dto) {
		return ResponseEntity.ok(atletaService.desvincularAtletaNaEquipe(dto));
	}
}
