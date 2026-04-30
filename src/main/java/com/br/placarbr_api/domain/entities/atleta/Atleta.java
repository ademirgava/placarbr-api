package com.br.placarbr_api.domain.entities.atleta;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.domain.entities.equipe.Equipe;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Atleta {
	private Long id;
	@NotBlank
	@Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$")
	private String cpf;

	private String rg;
	
	@NotBlank(message = "Nome obrigatório!")
	private String nome;
	@NotBlank(message = "E-mail obrigatório!")
	@Email
	private String email;

	private String apelido;

	private LocalDate dataNascimento;

	private byte[] foto;

	private TipoPePredominante pePredominante;

	private String descricao;

	@NotBlank
	@Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$")
	private String celular;

	private Endereco endereco;

	private LocalDateTime dataCriacao;

	private Equipe equipe;

	public Atleta(String cpf, String rg, String nome, String email, String apelido, LocalDate dataNascimento,
			TipoPePredominante pePredominante, String descricao, String celular, Endereco endereco, Equipe equipe) {
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.email = email;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.pePredominante = pePredominante;
		this.descricao = descricao;
		this.celular = celular;
		this.endereco = endereco;
		this.equipe = equipe;
	}
	
	public Atleta(Long id, String cpf, String rg, String nome, String email, String apelido, LocalDate dataNascimento,
			TipoPePredominante pePredominante, String descricao, String celular, Endereco endereco, Equipe equipe) {
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.email = email;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.pePredominante = pePredominante;
		this.descricao = descricao;
		this.celular = celular;
		this.endereco = endereco;
		this.equipe = equipe;
	}

	public Atleta(Long id, String cpf, String rg, String nome, String email, String apelido,
			LocalDate dataNascimento, TipoPePredominante pePredominante, String descricao, String celular,
			Endereco endereco) {
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.email = email;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.pePredominante = pePredominante;
		this.descricao = descricao;
		this.celular = celular;
		this.endereco = endereco;
	}

}
