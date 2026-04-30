package com.br.placarbr_api.domain.entities.comissao_tecnica;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComissaoTecnica {

	private Long id;
	private String cpf;
	private String rg;
	private String registro;
	private String registroTipo;
	private String nome;
	private String email;
	private String apelido;
	private LocalDate dataNascimento;
	private byte[] foto;
	private String descricao;
	private String celular;
	private LocalDateTime dataCriacao;

	private Endereco endereco;

	private ComissaoTecnicaTipo comissaoTecnicaTipo;

	public ComissaoTecnica(Long id, String cpf, String rg, String registro, String registroTipo, String nome,
			String email, String apelido, LocalDate dataNascimento, byte[] foto, String descricao, String celular,
			LocalDateTime dataCriacao, Endereco endereco, ComissaoTecnicaTipo comissaoTecnicaTipo) {
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.registro = registro;
		this.registroTipo = registroTipo;
		this.nome = nome;
		this.email = email;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.descricao = descricao;
		this.celular = celular;
		this.dataCriacao = dataCriacao;
		this.endereco = endereco;
		this.comissaoTecnicaTipo = comissaoTecnicaTipo;
	}

	public ComissaoTecnica(String cpf, String rg, String registro, String registroTipo, String nome, String email,
			String apelido, LocalDate dataNascimento, byte[] foto, String descricao, String celular, Endereco endereco,
			ComissaoTecnicaTipo comissaoTecnicaTipo) {
		this.cpf = cpf;
		this.rg = rg;
		this.registro = registro;
		this.registroTipo = registroTipo;
		this.nome = nome;
		this.email = email;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.descricao = descricao;
		this.celular = celular;
		this.endereco = endereco;
		this.comissaoTecnicaTipo = comissaoTecnicaTipo;
	}

	public ComissaoTecnica(Long id, String cpf, String rg, String registro, String registroTipo, String nome,
			String email, String apelido, LocalDate dataNascimento, String descricao, String celular, Endereco endereco, ComissaoTecnicaTipo comissaoTecnicaTipo) {
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.registro = registro;
		this.registroTipo = registroTipo;
		this.nome = nome;
		this.email = email;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.descricao = descricao;
		this.celular = celular;
		this.endereco = endereco;
		this.comissaoTecnicaTipo = comissaoTecnicaTipo;
	}
}
