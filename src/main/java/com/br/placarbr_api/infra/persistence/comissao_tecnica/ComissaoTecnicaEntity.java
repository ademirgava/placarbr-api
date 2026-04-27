package com.br.placarbr_api.infra.persistence.comissao_tecnica;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.placarbr_api.infra.persistence.comissao_tecnica_tipo.ComissaoTecnicaTipoEntity;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ComissaoTecnica")
@Table(name = "comissao_tecnica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComissaoTecnicaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cpf;
	private String rg;
	private String registro;
	private String registroTipo;
	private String nome;
	private String email;
	private String apelido;
	private LocalDate dataNascimento;
	private byte[] foto;
	private String descricao;
	private String celular;
	private LocalDateTime dataCriacao;

	@OneToOne(fetch = FetchType.LAZY)
	private EnderecoEntity endereco;

	@ManyToOne(fetch = FetchType.LAZY)
	private ComissaoTecnicaTipoEntity comissaoTecnicaTipo;

	public ComissaoTecnicaEntity(String cpf, String rg, String registro, String registroTipo, String nome, String email,
			String apelido, LocalDate dataNascimento, byte[] foto, String descricao, String celular,
			LocalDateTime dataCriacao) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.registro = registro;
		this.registroTipo = registroTipo;
		this.nome = nome;
		this.email = email;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.descricao = descricao;
		this.celular = celular;
		this.dataCriacao = dataCriacao;
	}

	
}
