package com.br.placarbr_api.domain.model;

import java.time.LocalDateTime;

import com.br.placarbr_api.domain.dto.ComissaoTecnicaTipoAtualizaDTO;
import com.br.placarbr_api.domain.dto.ComissaoTecnicaTipoCadastraDTO;

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
public class ComissaoTecnicaTipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;
	private LocalDateTime dataCriacao;
	
	public ComissaoTecnicaTipo(ComissaoTecnicaTipoCadastraDTO dto) {
		this.nome = dto.nome();
		this.descricao = dto.descricao();
		this.dataCriacao = LocalDateTime.now();
	}

	public void atualizar(ComissaoTecnicaTipoAtualizaDTO dto) {
		this.nome = dto.nome();
		this.descricao = dto.descricao();		
	}

}
