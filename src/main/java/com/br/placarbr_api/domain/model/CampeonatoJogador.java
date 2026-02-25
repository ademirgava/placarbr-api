package com.br.placarbr_api.domain.model;

import com.br.placarbr_api.domain.dto.CampeonatoJogadorCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "CampeonatoJogadores")
@Table(name = "campeonato_jogadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CampeonatoJogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Atleta atleta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CampeonatoTime campeonatoTime;
	
	@Enumerated(EnumType.STRING)
	private TipoPosicaoJogador posicao;

	public CampeonatoJogador(CampeonatoJogadorCadastroDTO dto) {
		this.posicao = dto.posicao();
	}

}
