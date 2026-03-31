package com.br.placarbr_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.domain.dto.CampeonatoAtualizaDTO;
import com.br.placarbr_api.domain.dto.CampeonatoCadastroDTO;
import com.br.placarbr_api.domain.dto.CampeonatoDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.CampeonatoListagemDTO;
import com.br.placarbr_api.service.CampeonatoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RequestMapping("/campeonatos")
@RestController
public class CampeonatoController {

	@Autowired
	private CampeonatoService campeonatoService;
	
	@GetMapping
	public ResponseEntity<Page<CampeonatoListagemDTO>> listarCampeonatos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		return ResponseEntity.ok(campeonatoService.listarCampeonatos(paginacao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CampeonatoDetalhamentoDTO> buscarCampeonato(@PathVariable Long id) {
		return ResponseEntity.ok(campeonatoService.buscarCampeonatoPeloId(id));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CampeonatoDetalhamentoDTO> cadastrarCampeonato(@RequestBody @Valid CampeonatoCadastroDTO dto, UriComponentsBuilder builder) {
		CampeonatoDetalhamentoDTO campeonato = campeonatoService.cadastrarCampeonato(dto);

		var uri = builder.path("/campeonatos/{id}").buildAndExpand(campeonato.id()).toUri();
		return ResponseEntity.created(uri).body(campeonato);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<CampeonatoDetalhamentoDTO> atualizarCampeonato(@RequestBody @Valid CampeonatoAtualizaDTO dto, UriComponentsBuilder builder) {
		CampeonatoDetalhamentoDTO campeonato = campeonatoService.atualizaCampeonato(dto);
		return ResponseEntity.ok(campeonato);
	}
}
