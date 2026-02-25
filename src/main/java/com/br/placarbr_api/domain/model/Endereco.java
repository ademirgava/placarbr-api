package com.br.placarbr_api.domain.model;

import com.br.placarbr_api.domain.dto.EnderecoCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Endereco")
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String complemento;
	
	@OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY)
	private Atleta jogador;
	
	@OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY)
	private Equipe equipe;
	
	public Endereco(EnderecoCadastroDTO dto) {
		this.logradouro = dto.logradouro();
		this.numero = dto.numero();
		this.bairro = dto.bairro();
		this.cidade = dto.cidade();
		this.uf = dto.uf();
		this.cep = dto.cep();
		this.complemento = dto.complemento();
	}

	public void atualizar(EnderecoCadastroDTO dto) {
		this.logradouro = dto.logradouro();
		this.numero = dto.numero();
		this.bairro = dto.bairro();
		this.cidade = dto.cidade();
		this.uf = dto.uf();
		this.cep = dto.cep();
		this.complemento = dto.complemento();
	}
}
