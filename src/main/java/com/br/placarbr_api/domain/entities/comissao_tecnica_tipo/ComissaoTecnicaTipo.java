package com.br.placarbr_api.domain.entities.comissao_tecnica_tipo;

import java.time.LocalDateTime;

public class ComissaoTecnicaTipo {
	private Long id;
	private String nome;
	private String descricao;
	private LocalDateTime dataCriacao;
	
	public ComissaoTecnicaTipo(String nome, String descricao) {
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome não deve ser vazio!");
		}
		
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = LocalDateTime.now();
	}
	
	public ComissaoTecnicaTipo(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = LocalDateTime.now();
	}

	public ComissaoTecnicaTipo(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
