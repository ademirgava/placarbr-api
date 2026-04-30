package com.br.placarbr_api.infra.controller.equipe;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.placarbr_api.application.usecases.equipe.AdicionarLogomarcaEquipe;
import com.br.placarbr_api.application.usecases.equipe.AtivarEquipe;
import com.br.placarbr_api.application.usecases.equipe.AtualizarEquipe;
import com.br.placarbr_api.application.usecases.equipe.BuscarPorIdEquipe;
import com.br.placarbr_api.application.usecases.equipe.CadastrarEquipe;
import com.br.placarbr_api.application.usecases.equipe.InativaEquipe;
import com.br.placarbr_api.application.usecases.equipe.ListarTodasEquipes;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.controller.PageResult;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeAtualizaDTO;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeCadastroDTO;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeDetalhamentoDTO;
import com.br.placarbr_api.infra.gateways.equipe.EquipeMapper;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

	private final CadastrarEquipe cadastrarEquipe;
	private final EquipeMapper mapper;
	private final ListarTodasEquipes listarTodasEquipes;
	private final BuscarPorIdEquipe buscarPorIdEquipe;
	private final InativaEquipe inativaEquipe;
	private final AtivarEquipe ativarEquipe;
	private final AtualizarEquipe atualizarEquipe;
	private final AdicionarLogomarcaEquipe adicionarLogomarcaEquipe;

	public EquipeController(EquipeMapper mapper, CadastrarEquipe cadastrarEquipe, ListarTodasEquipes listarTodasEquipes,
			BuscarPorIdEquipe buscarPorIdEquipe, InativaEquipe inativaEquipe, AtivarEquipe ativarEquipe,
			AtualizarEquipe atualizarEquipe, AdicionarLogomarcaEquipe adicionarLogomarcaEquipe) {
		this.mapper = mapper;
		this.cadastrarEquipe = cadastrarEquipe;
		this.listarTodasEquipes = listarTodasEquipes;
		this.buscarPorIdEquipe = buscarPorIdEquipe;
		this.inativaEquipe = inativaEquipe;
		this.ativarEquipe = ativarEquipe;
		this.atualizarEquipe = atualizarEquipe;
		this.adicionarLogomarcaEquipe = adicionarLogomarcaEquipe;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<EquipeDetalhamentoDTO> cadastrarEquipe(@RequestBody EquipeCadastroDTO dto,
			UriComponentsBuilder builder) {
		Equipe equipeDomain = cadastrarEquipe.cadastrar(mapper.toDomain(dto));
		var uri = builder.path("/equipes/{id}").buildAndExpand(equipeDomain.getId()).toUri();
		return ResponseEntity.created(uri).body(new EquipeDetalhamentoDTO(equipeDomain));
	}

	@GetMapping
	public ResponseEntity<PageResult<EquipeDetalhamentoDTO>> listarEquipes(@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "10") int tamanho, @RequestParam(defaultValue = "nome") String sort,
			@RequestParam(defaultValue = "desc") String direcao) {
		Pagina<Equipe> equipesDomain = listarTodasEquipes.listar(new Paginacao(pagina, tamanho, sort, direcao));
		return ResponseEntity.ok(new PageResult<EquipeDetalhamentoDTO>(
				equipesDomain.itens().stream().map(EquipeDetalhamentoDTO::new).toList(), equipesDomain.pagina(),
				equipesDomain.totalItens(), equipesDomain.tamanho()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EquipeDetalhamentoDTO> buscarEquipe(@PathVariable Long id) {
		return ResponseEntity.ok(new EquipeDetalhamentoDTO(buscarPorIdEquipe.buscarPorId(id)));
	}

	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity desativarEquipe(@PathVariable Long id) {
		inativaEquipe.invativarEquipe(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EquipeDetalhamentoDTO> reativarEquipe(@PathVariable Long id) {
		return ResponseEntity.ok(new EquipeDetalhamentoDTO(this.ativarEquipe.ativar(id)));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<EquipeDetalhamentoDTO> atualizarEquipe(@RequestBody EquipeAtualizaDTO dto) {
		return ResponseEntity.ok(new EquipeDetalhamentoDTO(atualizarEquipe.atualizar(mapper.toDomain(dto))));
	}

	@PostMapping("/add-imagem/{id}")
	@Transactional
	public ResponseEntity<EquipeDetalhamentoDTO> addLogomarca(@PathVariable Long id,
			@RequestParam("file") MultipartFile logomarca) throws IOException, IOException {
		return ResponseEntity.ok(new EquipeDetalhamentoDTO(adicionarLogomarcaEquipe.adicionar(id, logomarca)));
	}

}