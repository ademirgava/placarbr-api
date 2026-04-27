package com.br.placarbr_api.application.usecases.comissao_tecnica_tipo;

import com.br.placarbr_api.application.gateways.comissao_tecnica_tipo.RepositorioDeComissaoTecnicaTipo;
import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;

public class ListarComissaoTecnicaTipo {

	private RepositorioDeComissaoTecnicaTipo repositorioDeComissaoTecnicaTipo;

	public ListarComissaoTecnicaTipo(RepositorioDeComissaoTecnicaTipo repositorioDeComissaoTecnicaTipo) {
		this.repositorioDeComissaoTecnicaTipo = repositorioDeComissaoTecnicaTipo;
	}
	
	public Pagina<ComissaoTecnicaTipo> listar(Paginacao paginacao) {
		return this.repositorioDeComissaoTecnicaTipo.listar(paginacao);
	}
}
