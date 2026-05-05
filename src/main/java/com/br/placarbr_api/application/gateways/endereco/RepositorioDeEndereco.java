package com.br.placarbr_api.application.gateways.endereco;

import com.br.placarbr_api.domain.entities.Endereco;

public interface RepositorioDeEndereco {

	Endereco cadastrarEndreco(Endereco endereco);

	Endereco atualizar(Endereco endereco);

	Endereco buscarViaCep(String cep);

}
