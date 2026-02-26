package com.br.placarbr_api.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.br.placarbr_api.domain.dto.ComissaoTecnicaAtualizaDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaCadastraDTO;

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
public class ComissaoTecnica {

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
	private Endereco endereco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ComissaoTecnicaTipo comissaoTecnicaTipo;

	public ComissaoTecnica(ComissaoTecnicaCadastraDTO dto) {
		this.cpf = dto.cpf();
		this.rg = dto.rg();
		this.registro = dto.registro();
		this.registroTipo = dto.registroTipo();
		this.nome = dto.nome();
		this.email = dto.email();
		this.apelido = dto.apelido();
		this.dataNascimento = dto.dataNascimento();
		this.descricao = dto.descricao();
		this.celular = dto.celular();
		
		this.dataCriacao = LocalDateTime.now();
	}

	public void atuzalizar(ComissaoTecnicaAtualizaDTO dto) {
		this.cpf = dto.cpf();
		this.rg = dto.rg();
		this.registro = dto.registro();
		this.registroTipo = dto.registroTipo();
		this.nome = dto.nome();
		this.email = dto.email();
		this.apelido = dto.apelido();
		this.dataNascimento = dto.dataNascimento();
		this.descricao = dto.descricao();
		this.celular = dto.celular();
		this.endereco.atualizar(dto.enderecoCadastroDTO()); 
	}

}
