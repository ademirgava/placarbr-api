package com.br.placarbr_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.domain.dto.CampeonatoJogadorCadastroDTO;
import com.br.placarbr_api.domain.dto.CampeonatoTimeDetalhamentoDTO;
import com.br.placarbr_api.service.CampeonatoJogadoresService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/campeonato-jogadores")
public class CampeonatoJogadoresController {

	@Autowired
	private CampeonatoJogadoresService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CampeonatoTimeDetalhamentoDTO> cadastrarCampeonatoJogador(@RequestBody @Valid CampeonatoJogadorCadastroDTO dto, UriComponentsBuilder builder) {
		CampeonatoTimeDetalhamentoDTO campeonatoTimeDetalhamentoDTO = service.cadastrarCampeonatoJogador(dto);
		var uri = builder.path("/campoenoto/{id}").buildAndExpand(campeonatoTimeDetalhamentoDTO.campeonatoListagemDTO().id()).toUri();
		return ResponseEntity.created(uri).body(campeonatoTimeDetalhamentoDTO);
	}
}
