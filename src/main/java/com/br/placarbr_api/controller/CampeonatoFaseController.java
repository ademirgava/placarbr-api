package com.br.placarbr_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.domain.dto.CampeonatoFaseAtualizaDTO;
import com.br.placarbr_api.domain.dto.CampeonatoFaseCadastroDTO;
import com.br.placarbr_api.domain.dto.CampeonatoFaseListagemDTO;
import com.br.placarbr_api.domain.dto.CampeonatoFaseReordenarDTO;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.service.CampeonatoFaseService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/campeonato-fases")
public class CampeonatoFaseController {

	@Autowired
	private CampeonatoFaseService service;

	@GetMapping("/campeonato/{id}")
	public ResponseEntity<List<CampeonatoFaseListagemDTO>> listarFases(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarFasesPorCampeonatoId(id));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CampeonatoFaseListagemDTO> cadastrarFase(@RequestBody @Valid CampeonatoFaseCadastroDTO dto,
			UriComponentsBuilder builder) {
		try {
			CampeonatoFaseListagemDTO campeonatoFaseListagemDTO = service.cadastrarFase(dto);
			var uri = builder.path("/campeonato-fases/{id}").buildAndExpand(campeonatoFaseListagemDTO.id()).toUri();
			return ResponseEntity.created(uri).body(campeonatoFaseListagemDTO);
		} catch (ValidacaoException e) {
			throw new ValidacaoException(e.getMessage());
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<CampeonatoFaseListagemDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarFasePorId(id));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<CampeonatoFaseListagemDTO> atualizarFase(@RequestBody @Valid CampeonatoFaseAtualizaDTO dto) {
		return ResponseEntity.ok(service.atualizar(dto));
	}

	@PutMapping("/reordenar")
	@Transactional
	public ResponseEntity<List<CampeonatoFaseListagemDTO>> reordemarFases(
			@RequestBody @Valid CampeonatoFaseReordenarDTO dto) {
		return ResponseEntity.ok(service.reordenarFases(dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletarFase(@PathVariable Long id) {
		service.deletarFase(id);
		return ResponseEntity.noContent().build();
	}

}
