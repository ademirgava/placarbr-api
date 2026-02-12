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
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.domain.dto.CampeonatoJogoCadastroDTO;
import com.br.placarbr_api.domain.dto.CampeonatoJogoDetalhamentoDTO;
import com.br.placarbr_api.service.CampeonatoJogoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/campeonato-jogos")
public class CampeonatoJogosController {

	@Autowired
	private CampeonatoJogoService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CampeonatoJogoDetalhamentoDTO> cadastrarCameponatoJogo(@RequestBody @Valid CampeonatoJogoCadastroDTO dto, UriComponentsBuilder builder) {
		CampeonatoJogoDetalhamentoDTO cameponatoJogoDTO = service.cadastrarCameponatoJogo(dto);
		var uri = builder.path("/campeonato-jogo/{id}").buildAndExpand(cameponatoJogoDTO.id()).toUri();
		
		return ResponseEntity.created(uri).body(cameponatoJogoDTO);
	}
	
	@GetMapping("/campeonato/{id}")
	public ResponseEntity<Page<CampeonatoJogoDetalhamentoDTO>> listarCampeonatoJogosPorCampeonatoId(@PageableDefault(size = 10, sort = {"rodada"}) Pageable paginacao, @PathVariable Long id) {
		return ResponseEntity.ok(service.listarCampeonatoJogosPorCampeonatoId(paginacao, id));
	}
}
