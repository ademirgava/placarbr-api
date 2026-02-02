package com.br.placarbr_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.placarbr_api.domain.dto.EnderecoCadastroDTO;
import com.br.placarbr_api.domain.model.Endereco;
import com.br.placarbr_api.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public Endereco cadastrar(EnderecoCadastroDTO dto) {
		return repository.save(new Endereco(dto));
	}
}
