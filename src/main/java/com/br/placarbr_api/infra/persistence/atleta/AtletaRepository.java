package com.br.placarbr_api.infra.persistence.atleta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<AtletaEntity, Long>{

	boolean existsByCpf(String cpf);

	Page<AtletaEntity> findAllByEquipeId(Pageable paginacao, Long equipeId);
	
	Page<AtletaEntity> findByNomeStartingWith(Pageable paginacao, String nome);
	
}
