package com.br.placarbr_api.domain.model;

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
	@JoinColumn(name = "time_mandante_id")
	private CampeonatoTime timeMandante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "time_visitante_id")
	private CampeonatoTime timeVisitante;

	private Integer rodada;

	@ManyToOne(fetch = FetchType.LAZY)
	private CampeonatoFase campeonatoFase;

	public CampeonatoJogo(Integer rodada, CampeonatoTime timeVisitante, CampeonatoTime timeMandante,
			CampeonatoFase fase, Campeonato campeonato) {
		this.rodada = rodada;
		this.timeVisitante = timeVisitante;
		this.timeMandante = timeMandante;
		this.campeonatoFase = fase;
		this.campeonato = campeonato;
	}

}
