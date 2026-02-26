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

import com.br.placarbr_api.domain.dto.ComissaoTecnicaTipoAtualizaDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaTipoCadastraDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaTipoDetalheDTO;
import com.br.placarbr_api.service.ComissaoTecnicaTipoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/comissao-tecnica-tipo")
public class ComissaoTecnicaTipoController {

	@Autowired
	private ComissaoTecnicaTipoService service;

	@PostMapping
	@Transactional
	public ResponseEntity<ComissaoTecnicaTipoDetalheDTO> cadastrar(
			@RequestBody @Valid ComissaoTecnicaTipoCadastraDTO dto, UriComponentsBuilder builder) {
		ComissaoTecnicaTipoDetalheDTO comissaoTecnicaTipoDetalheDTO = service.cadastrar(dto);

		var uri = builder.path("/comissao-tecnica-tipo/{id}").buildAndExpand(comissaoTecnicaTipoDetalheDTO.id())
				.toUri();

		return ResponseEntity.created(uri).body(comissaoTecnicaTipoDetalheDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<ComissaoTecnicaTipoDetalheDTO>> listar(@PageableDefault(size = 10,sort = {"nome"}) Pageable paginacao) {
		return ResponseEntity.ok(service.listar(paginacao));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ComissaoTecnicaTipoDetalheDTO> buscarTipoPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarTipoPorId(id));
	}
	
	@PutExchange
	@Transactional
	public ResponseEntity<ComissaoTecnicaTipoDetalheDTO> atualizarTipo(@RequestBody @Valid ComissaoTecnicaTipoAtualizaDTO dto) {
		return ResponseEntity.ok(service.atualizar(dto));
	}
}
