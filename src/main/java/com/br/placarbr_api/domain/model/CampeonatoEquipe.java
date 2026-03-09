package com.br.placarbr_api.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "CampeonatoEquipe")
@Table(name = "campeonato_equipes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampeonatoEquipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Campeonato campeonato;

	@ManyToOne
	private Equipe equipe;

	@ManyToOne
	private CampeonatoFase campeonatoFase;
	
}
