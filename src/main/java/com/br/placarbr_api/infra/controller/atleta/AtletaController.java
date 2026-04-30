package com.br.placarbr_api.infra.controller.atleta;

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

import com.br.placarbr_api.application.usecases.atleta.AtualizarAtleta;
import com.br.placarbr_api.application.usecases.atleta.BuscarPorIdAtleta;
import com.br.placarbr_api.application.usecases.atleta.CadastrarAtleta;
import com.br.placarbr_api.application.usecases.atleta.DesvincularEquipeAtleta;
import com.br.placarbr_api.application.usecases.atleta.ListarAtletas;
import com.br.placarbr_api.application.usecases.atleta.ListarPorEquipeIdAtletas;
import com.br.placarbr_api.application.usecases.atleta.ListarPorNomeAtletas;
import com.br.placarbr_api.application.usecases.atleta.VincularEquipeAtleta;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.infra.controller.PageResult;
import com.br.placarbr_api.infra.controller.atleta.dto.AtletaAtualizaDTO;
import com.br.placarbr_api.infra.controller.atleta.dto.AtletaCadastroDTO;
import com.br.placarbr_api.infra.controller.atleta.dto.AtletaDetalhamentoDTO;
import com.br.placarbr_api.infra.controller.atleta.dto.AtletaListagemDTO;
import com.br.placarbr_api.infra.gateways.atleta.AtletaMapper;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

	private final CadastrarAtleta cadastrarAtleta;
	private final AtletaMapper atletaMapper;
	private final ListarAtletas listarAtletas;
	private final BuscarPorIdAtleta buscarPorIdAtleta;
	private final ListarPorEquipeIdAtletas listarPorEquipeIdAtletas;
	private final AtualizarAtleta atualizarAtleta;
	private final ListarPorNomeAtletas listarPorNomeAtletas;
	private final DesvincularEquipeAtleta desvincularEquipeAtleta;
	private final VincularEquipeAtleta vincularEquipeAtleta;

	public AtletaController(CadastrarAtleta cadastrarAtleta, AtletaMapper atletaMapper, ListarAtletas listarAtletas,
			BuscarPorIdAtleta buscarPorIdAtleta, ListarPorEquipeIdAtletas listarPorEquipeIdAtletas,
			AtualizarAtleta atualizarAtleta, ListarPorNomeAtletas listarPorNomeAtletas, DesvincularEquipeAtleta desvincularEquipeAtleta, VincularEquipeAtleta vincularEquipeAtleta) {
		this.cadastrarAtleta = cadastrarAtleta;
		this.atletaMapper = atletaMapper;
		this.listarAtletas = listarAtletas;
		this.buscarPorIdAtleta = buscarPorIdAtleta;
		this.listarPorEquipeIdAtletas = listarPorEquipeIdAtletas;
		this.atualizarAtleta = atualizarAtleta;
		this.listarPorNomeAtletas = listarPorNomeAtletas;
		this.desvincularEquipeAtleta = desvincularEquipeAtleta;
		this.vincularEquipeAtleta = vincularEquipeAtleta;
	}

	@PostMapping
	@Transactional
	public ResponseEntity criarAtleta(@RequestBody @Valid AtletaCadastroDTO dto, UriComponentsBuilder builder) {
		Atleta atletaDomain = cadastrarAtleta.cadastrar(atletaMapper.toDomain(dto));
		var uri = builder.path("/atletas/{id}").buildAndExpand(atletaDomain.getId()).toUri();
		return ResponseEntity.created(uri).body(new AtletaDetalhamentoDTO(atletaDomain));
	}

	@GetMapping
	public ResponseEntity<PageResult<AtletaDetalhamentoDTO>> listarAtleta(@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "10") int tamanho, @RequestParam(defaultValue = "nome") String sortBy,
			@RequestParam(defaultValue = "asc") String direcao) {
		Paginacao paginacao = new Paginacao(pagina, tamanho, sortBy, direcao);
		Pagina<Atleta> atletasDomain = listarAtletas.listar(paginacao);
		return ResponseEntity.ok(new PageResult<AtletaDetalhamentoDTO>(
				atletasDomain.itens().stream().map(AtletaDetalhamentoDTO::new).toList(), atletasDomain.pagina(),
				atletasDomain.totalItens(), atletasDomain.tamanho()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AtletaDetalhamentoDTO> buscarAtletaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(new AtletaDetalhamentoDTO(buscarPorIdAtleta.buscar(id)));
	}

	@GetMapping("/equipe/{equipeId}")
	public ResponseEntity<PageResult<AtletaListagemDTO>> listarAtletasPorEquipeId(
			@RequestParam(defaultValue = "0") int pagina, @RequestParam(defaultValue = "10") int tamanho,
			@RequestParam(defaultValue = "nome") String sort, @RequestParam(defaultValue = "asc") String direcao,
			@PathVariable Long equipeId) {
		Pagina<Atleta> listaDomani = listarPorEquipeIdAtletas.listar(new Paginacao(pagina, tamanho, sort, direcao),
				equipeId);
		return ResponseEntity
				.ok(new PageResult<AtletaListagemDTO>(listaDomani.itens().stream().map(AtletaListagemDTO::new).toList(),
						listaDomani.pagina(), listaDomani.totalItens(), listaDomani.tamanho()));
	}

	@PutExchange
	@Transactional
	public ResponseEntity<AtletaDetalhamentoDTO> atualizarAtleta(@RequestBody @Valid AtletaAtualizaDTO dto) {
		return ResponseEntity.ok(new AtletaDetalhamentoDTO(atualizarAtleta.atualizar(atletaMapper.toDomain(dto))));
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<PageResult<AtletaListagemDTO>> listarAtletasPorNome(
			@RequestParam(defaultValue = "0") int pagina, @RequestParam(defaultValue = "10") int tamanho,
			@RequestParam(defaultValue = "nome") String sort, @RequestParam(defaultValue = "asc") String direcao,
			@PathVariable String nome) {
		Pagina<Atleta> paginaDomain = listarPorNomeAtletas.listar(nome, new Paginacao(pagina, tamanho, sort, direcao));
		return ResponseEntity.ok(
				new PageResult<AtletaListagemDTO>(paginaDomain.itens().stream().map(AtletaListagemDTO::new).toList(),
						paginaDomain.pagina(), paginaDomain.totalItens(), paginaDomain.tamanho()));
	}

	@PutExchange("/vincular-equipe/{equipeId}/{atletaId}")
	@Transactional
	public ResponseEntity<AtletaDetalhamentoDTO> vincularAtletaNaEquipe(
			@PathVariable Long equipeId,
			@PathVariable Long atletaId) {
		Atleta atletaDomain = vincularEquipeAtleta.vincular(equipeId, atletaId);
		return ResponseEntity.ok(new AtletaDetalhamentoDTO(atletaDomain));
	}

	@PutExchange("/desvincular-equipe/{atletaId}")
	@Transactional
	public ResponseEntity<AtletaDetalhamentoDTO> desvincularAtletaNaEquipe(
			@PathVariable Long atletaId) {
		Atleta atletaDomain = desvincularEquipeAtleta.desvicularEquipe(atletaId);
		return ResponseEntity.ok(new AtletaDetalhamentoDTO(atletaDomain));
	}

}
