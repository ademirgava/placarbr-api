package com.br.placarbr_api.infra.persistence.comissao_tecnica_tipo;

import java.time.LocalDateTime;

import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ComissaoTecnicaTipo")
@Table(name = "comissao_tecnica_tipo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComissaoTecnicaTipoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;
	private LocalDateTime dataCriacao;

	public void atualizar(ComissaoTecnicaTipo comissaoTecnicaTipo) {
		this.descricao = comissaoTecnicaTipo.getDescricao();
		this.nome = comissaoTecnicaTipo.getNome();
	}
	
}
