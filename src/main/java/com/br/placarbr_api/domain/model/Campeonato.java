package com.br.placarbr_api.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.br.placarbr_api.domain.dto.CampeonatoCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Campeonato")
@Table(name = "campeonatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Campeonato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDateTime dataCriacao;
	
    @OneToMany(mappedBy = "campeonato")
    private List<CampeonatoTime> times = new ArrayList<>();
    
    @OneToMany(mappedBy = "campeonato")
    private List<CampeonatoFase> fases = new ArrayList<>();

	public Campeonato(CampeonatoCadastroDTO dto) {
		this.nome = dto.nome();
		this.descricao = dto.descricao();
		this.dataInicio = dto.dataInicio();
		
		this.dataCriacao = LocalDateTime.now();
	}

}
