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

import com.br.placarbr_api.domain.dto.CampeonatoEquipeCadastraDTO;
import com.br.placarbr_api.domain.dto.CampeonatoEquipeDetalhamentoDTO;
import com.br.placarbr_api.domain.dto.CampeonatoEquipeListagemPorCampeonatoDTO;
import com.br.placarbr_api.service.CampeonatoEquipeService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/campeonato-equipes")
public class CampeonatoEquipeController {

	@Autowired
	private CampeonatoEquipeService service;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid CampeonatoEquipeCadastraDTO dto, UriComponentsBuilder builder) {
		CampeonatoEquipeDetalhamentoDTO equipeDetalhamentoDTO = service.cadastrar(dto);

		var uri = builder.path("/campeonato-equipes/{id}").buildAndExpand(equipeDetalhamentoDTO.id()).toUri();

		return ResponseEntity.created(uri).body(equipeDetalhamentoDTO);
	}

	@GetMapping
	public ResponseEntity<Page<CampeonatoEquipeDetalhamentoDTO>> listarTodos(
			@PageableDefault(size = 10, sort = { "campeonato" }) Pageable paginacao) {
		return ResponseEntity.ok(service.listarTodos(paginacao));
	}

	@GetMapping("/campeonato/{id}")
	public ResponseEntity<CampeonatoEquipeListagemPorCampeonatoDTO> listarPorCampeonatoId(@PathVariable Long id) {
		return ResponseEntity.ok(service.listarPorCampeonatoId(id));
	}

}
