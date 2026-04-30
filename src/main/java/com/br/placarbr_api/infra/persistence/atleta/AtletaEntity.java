package com.br.placarbr_api.infra.persistence.atleta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.br.placarbr_api.domain.entities.atleta.Atleta;
import com.br.placarbr_api.domain.entities.atleta.TipoPePredominante;
import com.br.placarbr_api.infra.controller.atleta.dto.AtletaCadastroDTO;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;
import com.br.placarbr_api.infra.persistence.equipe.EquipeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Atleta")
@Table(name = "atletas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AtletaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cpf;

	private String rg;

	private String nome;

	private String email;

	private String apelido;

	private LocalDate dataNascimento;

	private byte[] foto;

	@Enumerated(EnumType.STRING)
	private TipoPePredominante pePredominante;

	private String descricao;

	private String celular;

	@OneToOne(fetch = FetchType.LAZY)
	private EnderecoEntity endereco;

	private LocalDateTime dataCriacao;

	@ManyToOne(fetch = FetchType.LAZY)
	private EquipeEntity equipe;

	public AtletaEntity(AtletaCadastroDTO dto, EnderecoEntity endereco) {
		this.nome = dto.nome();
		this.apelido = dto.apelido();
		this.descricao = dto.descricao();
		this.cpf = dto.cpf();
		this.rg = dto.rg();
		this.email = dto.email();
		this.pePredominante = dto.pePredominante();
		this.dataNascimento = dto.dataNascimento();
		this.celular = dto.celular();
		this.endereco = endereco;

		this.dataCriacao = LocalDateTime.now(ZoneOffset.of("-03:00"));
	}

	public void vincularEquipe(EquipeEntity equipe) {
		this.equipe = equipe;
	}

	public void desvincularEquipe() {
		this.equipe = null;
	}

	public AtletaEntity(Atleta dto, EnderecoEntity endereco) {
		this.nome = dto.getNome();
		this.apelido = dto.getApelido();
		this.descricao = dto.getDescricao();
		this.cpf = dto.getCpf();
		this.rg = dto.getRg();
		this.email = dto.getEmail();
		this.pePredominante = dto.getPePredominante();
		this.dataNascimento = dto.getDataNascimento();
		this.celular = dto.getCelular();
		this.endereco = endereco;

		this.dataCriacao = LocalDateTime.now(ZoneOffset.of("-03:00"));
	}

	public void atualizar(Atleta atleta) {
		this.nome = atleta.getNome();
		this.apelido = atleta.getApelido();
		this.descricao = atleta.getDescricao();
		this.cpf = atleta.getCpf();
		this.rg = atleta.getRg();
		this.email = atleta.getEmail();
		this.pePredominante = atleta.getPePredominante();
		this.dataNascimento = atleta.getDataNascimento();
		this.celular = atleta.getCelular();
	}

}
