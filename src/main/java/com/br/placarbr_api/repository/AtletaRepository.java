package com.br.placarbr_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.placarbr_api.domain.model.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Long>{

	boolean existsByCpf(String cpf);

}
