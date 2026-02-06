package com.br.placarbr_api.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.br.placarbr_api.domain.dto.JogadorAtualizaDTO;
import com.br.placarbr_api.domain.dto.JogadorCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Jogador")
@Table(name = "jogadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String apelido;

	private String descricao;

	private byte[] foto;

	private String cpf;

	private String rg;

	@Enumerated(EnumType.STRING)
	private TipoPePredominante pePredominante;

	private LocalDate dataNascimento;

	private String celular;

	private LocalDateTime dataCriacao;

	@OneToOne(fetch = FetchType.LAZY)
	private Endereco endereco;

	@OneToMany(mappedBy = "jogador")
	private List<CampeonatoJogador> campeonatoJogadores = new ArrayList<>();

	public Jogador(JogadorCadastroDTO dto, Endereco endereco) {
		this.nome = dto.nome();
		this.apelido = dto.apelido();
		this.descricao = dto.descricao();
		this.cpf = dto.cpf();
		this.rg = dto.rg();
		this.pePredominante = dto.pePredominante();
		this.dataNascimento = dto.dataNascimento();
		this.celular = dto.celular();
		this.endereco = endereco;

		this.dataCriacao = LocalDateTime.now(ZoneOffset.of("-03:00"));
	}

	public void atualizar(@Valid JogadorAtualizaDTO dto) {
		this.nome = dto.nome();
		this.apelido = dto.apelido();
		this.descricao = dto.descricao();
		this.cpf = dto.cpf();
		this.rg = dto.rg();
		this.pePredominante = dto.pePredominante();
		this.dataNascimento = dto.dataNascimento();
		this.celular = dto.celular();
		this.endereco.atualizar(dto.endereco());
	}

}
