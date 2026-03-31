package com.br.placarbr_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.placarbr_api.domain.model.CampeonatoFase;

public interface CampeonatoFaseRepository extends JpaRepository<CampeonatoFase, Long>{

	List<CampeonatoFase> findByCampeonatoIdOrderByOrdemFaseAsc(Long id);
	
	@Query("SELECT MAX(f.ordemFase) FROM CampeonatoFase f where f.campeonato.id = :campeonatoId")
    Optional<Long> findTopOrdemFaseByCampeonatoId(@Param("campeonatoId") Long id);
	
	Optional<CampeonatoFase> findByIdAndCampeonatoId(Long campeonatoFaseId, Long campeonatoId);

}
