package com.br.placarbr_api.infra.controller.comissao_tecnica;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.application.usecases.comissao_tecnica.BuscarPorIdComissaoTecnica;
import com.br.placarbr_api.application.usecases.comissao_tecnica.CriarComissaoTecnica;
import com.br.placarbr_api.application.usecases.comissao_tecnica.ListarTodoComissaoTecnica;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;
import com.br.placarbr_api.infra.controller.PageResult;
import com.br.placarbr_api.infra.gateways.comissao_tecnica.ComissaoTecnicaMapper;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/comissao-tecnica")
public class ComissaoTecnicaController {

	private final CriarComissaoTecnica criarComissaoTecnica;
	private final ComissaoTecnicaMapper mapper;
	private final BuscarPorIdComissaoTecnica buscarPorIdComissaoTecnica;
	private final ListarTodoComissaoTecnica listarTodoComissaoTecnica;

	public ComissaoTecnicaController(CriarComissaoTecnica criarComissaoTecnica, ComissaoTecnicaMapper mapper, BuscarPorIdComissaoTecnica buscarPorIdComissaoTecnica, ListarTodoComissaoTecnica listarTodoComissaoTecnica) {
		this.criarComissaoTecnica = criarComissaoTecnica;
		this.mapper = mapper;
		this.buscarPorIdComissaoTecnica = buscarPorIdComissaoTecnica;
		this.listarTodoComissaoTecnica = listarTodoComissaoTecnica;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ComissaoTecnicaDetalheDTO> cadastrar(@RequestBody @Valid ComissaoTecnicaCadastraDTO dto,
			UriComponentsBuilder builder) {
		ComissaoTecnica comissaoTecnica = criarComissaoTecnica.cadastrarComissaoTecnica(mapper.toDomain(dto));
		var uri = builder.path("/comissao-tecnica/{id}").buildAndExpand(comissaoTecnica.getId()).toUri();
		return ResponseEntity.created(uri).body(new ComissaoTecnicaDetalheDTO(comissaoTecnica));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ComissaoTecnicaDetalheDTO> buscarComissaoPorId(@PathVariable Long id) {
		ComissaoTecnica comissaoTecnica = buscarPorIdComissaoTecnica.buscarPorIdComissaoTecnica(id);
		return ResponseEntity.ok(new ComissaoTecnicaDetalheDTO(comissaoTecnica));
	}
	
	@GetMapping
	public ResponseEntity<PageResult<ComissaoTecnicaListagemDTO>> listarTodos(@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "10") int tamanho,
			@RequestParam(defaultValue = "nome") String sortBy,
			@RequestParam(defaultValue = "asc") String direcao
			) {
		Pagina<ComissaoTecnica> listarTodos = listarTodoComissaoTecnica.listarTodos(new Paginacao(pagina, tamanho, sortBy, direcao));
		return ResponseEntity.ok(new PageResult<ComissaoTecnicaListagemDTO>(listarTodos.itens().stream().map(ComissaoTecnicaListagemDTO::new).toList(), pagina, listarTodos.totalItens(), listarTodos.tamanho()));
	}
	
	/*



	@PutMapping
	@Transactional
	public ResponseEntity<ComissaoTecnicaDetalheDTO> atualizar(@RequestBody @Valid ComissaoTecnicaAtualizaDTO dto) {
		return ResponseEntity.ok(service.atualizar(dto));
	}
*/
}
