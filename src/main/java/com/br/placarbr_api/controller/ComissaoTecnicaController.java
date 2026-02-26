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

import com.br.placarbr_api.domain.dto.ComissaoTecnicaAtualizaDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaCadastraDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaDetalheDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaListagemDTO;
import com.br.placarbr_api.service.ComissaoTecnicaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/comissao-tecnica")
public class ComissaoTecnicaController {

	@Autowired
	private ComissaoTecnicaService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ComissaoTecnicaDetalheDTO> cadastrar(@RequestBody @Valid ComissaoTecnicaCadastraDTO dto, UriComponentsBuilder builder) {
		ComissaoTecnicaDetalheDTO comissaoTecnicaDetalheDTO = service.cadastrar(dto);
		var uri = builder.path("/comissao-tecnica/{id}").buildAndExpand(comissaoTecnicaDetalheDTO.id()).toUri();
		return ResponseEntity.created(uri).body(comissaoTecnicaDetalheDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<ComissaoTecnicaListagemDTO>> listarTodos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		return ResponseEntity.ok(service.listarTodos(paginacao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ComissaoTecnicaDetalheDTO> buscarComissaoPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarComissaoPorId(id));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<ComissaoTecnicaDetalheDTO> atualizar(@RequestBody @Valid ComissaoTecnicaAtualizaDTO dto) {
		return ResponseEntity.ok(service.atualizar(dto));
	}
}
