package com.br.placarbr_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.infra.controller.endereco.EnderecoCadastroDTO;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoEntity;
import com.br.placarbr_api.infra.persistence.endereco.EnderecoRepository;

import jakarta.validation.constraints.NotNull;

@Service
public class EnderecoService {

	public EnderecoEntity cadastrar(@NotNull EnderecoCadastroDTO endereco) {
		// TODO Auto-generated method stub
		return null;
	}

}
