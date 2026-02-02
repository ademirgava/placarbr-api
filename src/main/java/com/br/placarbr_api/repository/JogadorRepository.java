package com.br.placarbr_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.placarbr_api.domain.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long>{

	boolean existsByCpf(String cpf);

}
