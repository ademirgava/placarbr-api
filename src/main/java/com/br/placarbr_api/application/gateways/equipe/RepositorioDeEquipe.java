package com.br.placarbr_api.application.gateways.equipe;

import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.equipe.Equipe;

public interface RepositorioDeEquipe {

	Equipe cadastrar(Equipe equipe);

	boolean existsByNome(String nome);

	boolean existsBySigla(String sigla);

	Pagina<Equipe> listarTodas(Paginacao paginacao);

	Equipe buscarPorId(Long equipeId);

	Equipe desativar(Equipe equipe);

	Equipe ativarEquipe(Equipe equipe);

	Equipe atualizar(Equipe equipe);

	Equipe adicionarLogo(Equipe equipe);
}
