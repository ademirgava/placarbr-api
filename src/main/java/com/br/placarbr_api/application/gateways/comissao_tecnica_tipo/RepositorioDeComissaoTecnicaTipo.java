package com.br.placarbr_api.application.gateways.comissao_tecnica_tipo;

import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;

public interface RepositorioDeComissaoTecnicaTipo {

	ComissaoTecnicaTipo cadastrar(ComissaoTecnicaTipo comissaoTecnicaTipo);

	Pagina<ComissaoTecnicaTipo> listar(Paginacao paginacao);

	ComissaoTecnicaTipo buscarTipoPorId(Long id);

	ComissaoTecnicaTipo atualizarTipo(ComissaoTecnicaTipo comissaoTecnicaTipo);
}
