package com.br.placarbr_api.application.gateways.atleta;

import com.br.placarbr_api.domain.entities.Pagina;
import com.br.placarbr_api.domain.entities.Paginacao;
import com.br.placarbr_api.domain.entities.atleta.Atleta;

public interface RepositorioDeAtleta {

	Atleta cadastrar(Atleta atleta);

	boolean existsByCpf(String cpf);

	Pagina<Atleta> listar(Paginacao paginacao);

	Atleta buscarPorId(Long id);

	Pagina<Atleta> listarPorEquipeIdAtletas(Paginacao paginacao, Long equipeId);

	Atleta atualizar(Atleta atleta);

	Pagina<Atleta> listarPorNomeAtletas(String nome, Paginacao paginacao);

	Atleta desvicular(Long atletaId);

	Atleta vincularEquipeAtleta(Long equipeId, Long atletaId);

}
