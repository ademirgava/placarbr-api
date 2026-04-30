package com.br.placarbr_api.domain.model;

import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "campeonato_jogos")
@Entity(name = "CampeonatoJogo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CampeonatoJogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Campeonato campeonato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipe_mandante_id")
	private EquipeEntity equipeMandante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipe_visitante_id")
	private EquipeEntity equipeVisitante;

	private Integer rodada;

	@ManyToOne(fetch = FetchType.LAZY)
	private CampeonatoFase campeonatoFase;

	public CampeonatoJogo(Integer rodada, EquipeEntity timeVisitante, EquipeEntity timeMandante,
			CampeonatoFase fase, Campeonato campeonato) {
		this.rodada = rodada;
		this.equipeVisitante = timeVisitante;
		this.equipeMandante = timeMandante;
		this.campeonatoFase = fase;
		this.campeonato = campeonato;
	}

}
