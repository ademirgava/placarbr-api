package com.br.placarbr_api.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.br.placarbr_api.domain.dto.CampeonatoFaseAtualizaDTO;
import com.br.placarbr_api.domain.dto.CampeonatoFaseCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "campeonato_fases")
@Entity(name = "CampeonatoFase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CampeonatoFase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	private Campeonato campeonato;

	@Enumerated(EnumType.STRING)
	private TipoFase tipoFase;

	private Integer ordemFase;
	private Integer classificados;
	private Integer quantidadeGrupos;
	private Integer quantidadeTimes;
	private Boolean idaVolta;
	
	@OneToMany(mappedBy = "campeonatoFase")
	private List<CampeonatoJogo> jogos = new ArrayList<CampeonatoJogo>();

	public CampeonatoFase(CampeonatoFaseCadastroDTO dto, Campeonato campeonato) {
		this.nome = dto.nome();
		this.descricao = dto.descricao();
		this.tipoFase = dto.fase();
		this.ordemFase = dto.ordemFase();
		this.idaVolta = dto.idaVolta();
		this.quantidadeTimes = dto.quantidadeTimes();

		if (this.tipoFase.equals(TipoFase.GRUPOS)) {
			this.classificados = dto.classificados();
			this.quantidadeGrupos = dto.quantidadeGrupos();
		}

		this.campeonato = campeonato;
	}

	public void atualizar(CampeonatoFaseAtualizaDTO dto) {
		if (this.nome != null) {
			this.nome = dto.nome();
		}
		
		if (this.descricao != null) {
			this.descricao = dto.descricao();
		}
		
		if (this.tipoFase != null) {
			this.tipoFase = dto.fase();
		}

		if (this.classificados != null) {
			this.classificados = dto.classificados();
		}
		
		if (this.quantidadeGrupos != null) {
			this.quantidadeGrupos = dto.quantidadeGrupos();
		}
		
		if (this.idaVolta != null) {
			this.idaVolta = dto.idaVolta();
		}

		if (this.quantidadeTimes != null) {
			this.quantidadeTimes = dto.quantidadeTimes();
		}
	}

}
