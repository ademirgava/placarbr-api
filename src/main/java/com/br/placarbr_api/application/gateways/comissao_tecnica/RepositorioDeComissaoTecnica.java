package com.br.placarbr_api.application.gateways.comissao_tecnica;

import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.comissao_tecnica.ComissaoTecnica;

public interface RepositorioDeComissaoTecnica {

	ComissaoTecnica cadastrarComissaoTecnica(ComissaoTecnica comissaoTecnica);

	ComissaoTecnica buscarPorIdComissaoTecnica(Long id);

	Pagina<ComissaoTecnica> listar(Paginacao paginacao);

}
