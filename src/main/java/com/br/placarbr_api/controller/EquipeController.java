package com.br.placarbr_api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.domain.dto.EquipeAtualizaDTO;
import com.br.placarbr_api.domain.dto.EquipeCadastroDTO;
import com.br.placarbr_api.domain.dto.EquipeDetalhamentoDTO;
import com.br.placarbr_api.infra.exception.ValidacaoException;
import com.br.placarbr_api.service.EquipeService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

	@Autowired
	private EquipeService equipeService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EquipeDetalhamentoDTO> cadastrarEquipe(@RequestBody @Valid EquipeCadastroDTO dto, UriComponentsBuilder builder) {
		try {
			EquipeDetalhamentoDTO equipe = equipeService.cadastrar(dto);
			var uri = builder.path("/equipes/{id}").buildAndExpand(equipe.id()).toUri();
			return ResponseEntity.created(uri).body(equipe);
		} catch (ValidacaoException e) {
			throw new ValidacaoException(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<Page<EquipeDetalhamentoDTO>> listarEquipes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		return ResponseEntity.ok(equipeService.listarEquipes(paginacao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EquipeDetalhamentoDTO> buscarEquipe(@PathVariable Long id) {
		return ResponseEntity.ok(equipeService.buscarEquipe(id));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<EquipeDetalhamentoDTO> atualizarEquipe(@RequestBody @Valid EquipeAtualizaDTO dto) {
		return ResponseEntity.ok(equipeService.atualizarEquipe(dto));
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity desativarEquipe(@PathVariable Long id) {
		equipeService.inativarEquipe(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EquipeDetalhamentoDTO> reativarEquipe(@PathVariable Long id) {
		return ResponseEntity.ok(equipeService.reativarEquipe(id));
	}
	
	@PostMapping("/add-imagem/{id}")
	@Transactional
	public ResponseEntity<EquipeDetalhamentoDTO> addLogomarca(@PathVariable Long id,
			@RequestParam("file") MultipartFile logomarca) throws IOException, IOException {
		return ResponseEntity.ok(equipeService.addLogomarca(id, logomarca));
	}
	
}