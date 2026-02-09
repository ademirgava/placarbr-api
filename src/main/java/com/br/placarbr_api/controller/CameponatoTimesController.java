package com.br.placarbr_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.domain.dto.CampeonatoTimeDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.CampeonatoTimeJogadoresDTO;
import com.br.placarbr_api.domain.dto.CampeonatoTimesCadastroDTO;
import com.br.placarbr_api.service.CampeonatoTimesService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/campeonato-times")
public class CameponatoTimesController {

	@Autowired
	private CampeonatoTimesService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CampeonatoTimeDetalhamentoDTO> cadastrarTimes(@RequestBody @Valid CampeonatoTimesCadastroDTO dto, UriComponentsBuilder builder) {
		CampeonatoTimeDetalhamentoDTO time = service.cadastrarTime(dto);
		
		var uri = builder.path("/campeonato-times/{id}").buildAndExpand(time.cameponatoTimeId()).toUri();
		return ResponseEntity.created(uri).body(time);
	}
		
	@GetMapping("/time/{id}")
	public ResponseEntity<CampeonatoTimeJogadoresDTO> listarJogadoresTime(@PathVariable Long id) {
		return ResponseEntity.ok(service.listarJogadoresTime(id));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletarTime(@PathVariable Long id) {
		service.deletarTime(id);
		return ResponseEntity.noContent().build();
	}
}
