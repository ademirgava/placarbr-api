package com.br.placarbr_api.application.usecases.comissao_tecnica;

import com.br.placarbr_api.application.gateways.comissao_tecnica.RepositorioDeComissaoTecnica;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;

public class ListarTodoComissaoTecnica {

	private final RepositorioDeComissaoTecnica repositorioDeComissaoTecnica;

	public ListarTodoComissaoTecnica(RepositorioDeComissaoTecnica repositorioDeComissaoTecnica) {
		this.repositorioDeComissaoTecnica = repositorioDeComissaoTecnica;
	}
	
	public Pagina<ComissaoTecnica> listarTodos(Paginacao paginacao) {
		return this.repositorioDeComissaoTecnica.listar(paginacao);
	}
}
