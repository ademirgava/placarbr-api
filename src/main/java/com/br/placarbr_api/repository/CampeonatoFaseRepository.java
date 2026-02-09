package com.br.placarbr_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.placarbr_api.domain.model.CampeonatoFase;

public interface CampeonatoFaseRepository extends JpaRepository<CampeonatoFase, Long>{

	List<CampeonatoFase> findByCampeonatoId(Long id);

}
