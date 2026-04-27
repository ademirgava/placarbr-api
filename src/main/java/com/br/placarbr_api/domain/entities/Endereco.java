package com.br.placarbr_api.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Endereco {

	private Long id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String complemento;

//	private Atleta jogador;

//	private Equipe equipe;

//	private ComissaoTecnica comissaoTecnica;

	public Endereco(String logradouro, String numero, String bairro, String cidade, String uf, String cep,
			String complemento) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.complemento = complemento;
	}

}
