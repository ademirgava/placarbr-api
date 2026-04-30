package com.br.placarbr_api.infra.persistence.equipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<EquipeEntity, Long>{

	boolean existsByNome(String nome);

	boolean existsBySigla(String sigla);

}
