package com.br.placarbr_api.infra.controller.comissao_tecnica_tipo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.AtualizarComissaoTecnicaTipo;
import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.BuscarComissaoTecnicaTipoPorId;
import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.CriarComissaoTecnicaTipo;
import com.br.placarbr_api.application.usecases.comissao_tecnica_tipo.ListarComissaoTecnicaTipo;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;
import com.br.placarbr_api.infra.controller.PageResult;
import com.br.placarbr_api.infra.gateways.comissao_tecnica_tipo.ComissaoTecnicaTipoEntityMapper;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/comissao-tecnica-tipo")
public class ComissaoTecnicaTipoController {

	private final ComissaoTecnicaTipoEntityMapper mapper;
	private final CriarComissaoTecnicaTipo criarComissaoTecnicaTipo;
	private final BuscarComissaoTecnicaTipoPorId buscarComissaoTecnicaTipoPorId;
	private final AtualizarComissaoTecnicaTipo atualizarComissaoTecnicaTipo;
	private final ListarComissaoTecnicaTipo listarComissaoTecnicaTipo;

	public ComissaoTecnicaTipoController(CriarComissaoTecnicaTipo criarComissaoTecnicaTipo,
			ComissaoTecnicaTipoEntityMapper mapper, BuscarComissaoTecnicaTipoPorId buscarComissaoTecnicaTipoPorId,
			AtualizarComissaoTecnicaTipo atualizarComissaoTecnicaTipo,
			ListarComissaoTecnicaTipo listarComissaoTecnicaTipo) {
		this.criarComissaoTecnicaTipo = criarComissaoTecnicaTipo;
		this.mapper = mapper;
		this.buscarComissaoTecnicaTipoPorId = buscarComissaoTecnicaTipoPorId;
		this.atualizarComissaoTecnicaTipo = atualizarComissaoTecnicaTipo;
		this.listarComissaoTecnicaTipo = listarComissaoTecnicaTipo;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ComissaoTecnicaTipoDetalheDTO> cadastrarComissaoTecnicaTipo(
			@RequestBody @Valid ComissaoTecnicaTipoCadastraDTO dto, UriComponentsBuilder builder) {
		ComissaoTecnicaTipo tipoSalvo = criarComissaoTecnicaTipo.cadastrarComissaoTecnicaTipo(mapper.toDomain(dto));

		var uri = builder.path("/comissao-tecnica-tipo/{id}").buildAndExpand(tipoSalvo.getId()).toUri();

		return ResponseEntity.created(uri).body(new ComissaoTecnicaTipoDetalheDTO(tipoSalvo));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComissaoTecnicaTipoDetalheDTO> buscarTipoPorId(@PathVariable Long id) {
		ComissaoTecnicaTipo comissaoTecnicaTipo = buscarComissaoTecnicaTipoPorId.buscarTipoPorId(id);
		return ResponseEntity.ok(new ComissaoTecnicaTipoDetalheDTO(comissaoTecnicaTipo));
	}

	@PutExchange
	@Transactional
	public ResponseEntity<ComissaoTecnicaTipoDetalheDTO> atualizarTipo(
			@RequestBody @Valid ComissaoTecnicaTipoAtualizaDTO dto) {
		ComissaoTecnicaTipo tipo = atualizarComissaoTecnicaTipo.atualizarTipo(mapper.toDomain(dto));
		return ResponseEntity.ok(new ComissaoTecnicaTipoDetalheDTO(tipo));
	}

	@GetMapping 
	public ResponseEntity<PageResult<ComissaoTecnicaTipoDetalheDTO>> listar(@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "10") int tamanho,
			@RequestParam(defaultValue = "nome") String sortBy,
			@RequestParam(defaultValue = "asc") String direcao) {
		
		Pagina<ComissaoTecnicaTipo> lista = listarComissaoTecnicaTipo.listar(new Paginacao(pagina, tamanho, sortBy, direcao));
		return ResponseEntity.ok(new PageResult<ComissaoTecnicaTipoDetalheDTO>(lista.itens().stream().map(tipo -> new ComissaoTecnicaTipoDetalheDTO(tipo)).toList(), lista.pagina(), lista.totalItens(), lista.tamanho())); 
	 }

}
