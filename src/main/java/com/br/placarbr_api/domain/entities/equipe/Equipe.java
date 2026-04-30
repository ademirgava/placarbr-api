package com.br.placarbr_api.domain.entities.equipe;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.placarbr_api.domain.entities.Endereco;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeCadastroDTO;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Equipe {

	private Long id;

	@NotNull
	@Size(min = 6)
	private String nome;
	@NotBlank
	@Size(min = 2, max = 3)
	private String sigla;

	private Boolean ativo;

	private byte[] logomarca;

	private LocalDate dataFundacao;

	private LocalDateTime dataCriacao;
	@NotBlank
	private String corPrincipal;
	@NotBlank
	private String corSecundaria;

	private Endereco endereco;

	public Equipe(EquipeCadastroDTO dados, EnderecoEntity endereco) {
		this.ativo = true;
		this.dataCriacao = LocalDateTime.now();

		this.nome = dados.nome();
		this.sigla = dados.sigla();
		this.dataFundacao = dados.dataFundacao();
		this.corPrincipal = dados.corPrincipal();
		this.corSecundaria = dados.corSecundaria();
	}

	public Equipe(Long id) {
		this.id = id;
	}

	public void inativar() {
		this.ativo = false;
	}

	public void ativarEquipe() {
		this.ativo = true;
	}

	public Equipe(String nome, String sigla, LocalDate dataFundacao, String corPrincipal, String corSecundaria,
			Endereco endereco) {
		this.nome = nome;
		this.sigla = sigla;
		this.dataFundacao = dataFundacao;
		this.corPrincipal = corPrincipal;
		this.corSecundaria = corSecundaria;
		this.endereco = endereco;

		this.ativo = true;
		this.dataCriacao = LocalDateTime.now();

	}

	public Equipe(Long id, String nome, String sigla, LocalDate dataFundacao, String corPrincipal, String corSecundaria,
			Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.dataFundacao = dataFundacao;
		this.corPrincipal = corPrincipal;
		this.corSecundaria = corSecundaria;
		this.endereco = endereco;
	}

	
	public void atualizar(Equipe equipe) {
		if (equipe.getNome() != null) {
			this.nome = equipe.getNome();
		}
		
		if (equipe.getSigla() != null) {
			this.sigla = equipe.getSigla();
		}
		
		if (equipe.getDataFundacao() != null) {
			this.dataFundacao = equipe.getDataFundacao();
		}
		
		if (equipe.getCorPrincipal() != null) {
			this.corPrincipal = equipe.getCorPrincipal();
		}
		
		if (equipe.getCorSecundaria() != null) {
			this.corSecundaria = equipe.getCorSecundaria();
		}
	}

}
