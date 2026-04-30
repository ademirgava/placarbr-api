package com.br.placarbr_api.infra.persistence.equipe;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.placarbr_api.domain.entities.equipe.Equipe;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeAtualizaDTO;
import com.br.placarbr_api.infra.controller.equipe.dto.EquipeCadastroDTO;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "equipes")
@Entity(name = "Equipe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EquipeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String sigla;

	private Boolean ativo;

	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] logomarca;

	private LocalDate dataFundacao;

	private LocalDateTime dataCriacao;

	private String corPrincipal;

	private String corSecundaria;

	@OneToOne(fetch = FetchType.LAZY)
	private EnderecoEntity endereco;

	public EquipeEntity(EquipeCadastroDTO dados, EnderecoEntity endereco) {
		this.ativo = true;
		this.dataCriacao = LocalDateTime.now();

		this.nome = dados.nome();
		this.sigla = dados.sigla();
		this.dataFundacao = dados.dataFundacao();
		this.corPrincipal = dados.corPrincipal();
		this.corSecundaria = dados.corSecundaria();
		this.endereco = endereco;
	}

	public void inativar() {
		this.ativo = false;
	}

	public void ativarEquipe() {
		this.ativo = true;
	}

	public EquipeEntity(String nome, String sigla, Boolean ativo, LocalDate dataFundacao, LocalDateTime dataCriacao,
			String corPrincipal, String corSecundaria, EnderecoEntity endereco) {
		this.nome = nome;
		this.sigla = sigla;
		this.ativo = ativo;
		this.dataFundacao = dataFundacao;
		this.dataCriacao = dataCriacao;
		this.corPrincipal = corPrincipal;
		this.corSecundaria = corSecundaria;
		this.endereco = endereco;
	}

	public void atualizar(Equipe novaEquipe) {
		this.nome = novaEquipe.getNome();
		this.sigla = novaEquipe.getSigla();
		this.dataFundacao = novaEquipe.getDataFundacao();
		this.corPrincipal = novaEquipe.getCorPrincipal();
		this.corSecundaria = novaEquipe.getCorSecundaria();
	}
}
