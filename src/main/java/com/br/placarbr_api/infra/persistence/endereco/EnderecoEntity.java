package com.br.placarbr_api.infra.persistence.endereco;

import com.br.placarbr_api.domain.model.Atleta;
import com.br.placarbr_api.domain.model.Equipe;
import com.br.placarbr_api.infra.persistence.comissao_tecnica.ComissaoTecnicaEntity;

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
public class EnderecoEntity {

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

	@OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY)
	private ComissaoTecnicaEntity comissaoTecnicaEntity;

	public EnderecoEntity(Long id,String logradouro, String numero, String bairro, String cidade, String uf, String cep,
			String complemento) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.complemento = complemento;
	}

}
