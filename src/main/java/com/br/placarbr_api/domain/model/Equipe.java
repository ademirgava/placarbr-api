package com.br.placarbr_api.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.br.placarbr_api.domain.dto.EquipeAtualizaDTO;
import com.br.placarbr_api.domain.dto.EquipeCadastroDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Equipe {

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
	private Endereco endereco;
	
    @OneToMany(mappedBy = "equipe")
    private List<CampeonatoTime> times = new ArrayList<>();

	public Equipe(EquipeCadastroDTO dados, Endereco endereco) {
		this.ativo = true;
		this.dataCriacao = LocalDateTime.now();

		this.nome = dados.nome();
		this.sigla = dados.sigla();
		this.dataFundacao = dados.dataFundacao();
		this.corPrincipal = dados.corPrincipal();
		this.corSecundaria = dados.corSecundaria();
		this.endereco = endereco;
	}

	public void atualizar(EquipeAtualizaDTO novaEquipe) {

		if (novaEquipe.nome() != null) {
			this.nome = novaEquipe.nome();
		}

		if (novaEquipe.sigla() != null) {
			this.sigla = novaEquipe.sigla();
		}

		if (novaEquipe.dataFundacao() != null) {
			this.dataFundacao = novaEquipe.dataFundacao();
		}

		if (novaEquipe.corPrincipal() != null) {
			this.corPrincipal = novaEquipe.corPrincipal();
		}

		if (novaEquipe.corSecundaria() != null) {
			this.corSecundaria = novaEquipe.corSecundaria();
		}
	}

	public void inativar() {
		this.ativo = false;
	}

	public void ativarEquipe() {
		this.ativo = true;
	}
}
