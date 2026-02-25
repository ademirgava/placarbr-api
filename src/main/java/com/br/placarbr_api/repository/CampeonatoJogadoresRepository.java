package com.br.placarbr_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.placarbr_api.domain.model.CampeonatoJogador;
import com.br.placarbr_api.domain.model.CampeonatoTime;

public interface CampeonatoJogadoresRepository extends JpaRepository<CampeonatoJogador, Long> {

	List<CampeonatoJogador> findAllByCampeonatoTime(CampeonatoTime campeonatoTime);

	Boolean existsByAtletaIdAndCampeonatoTimeId(Long jogadorId, Long campeonatoTimeId);

	void deleteByCampeonatoTimeId(Long id);

}
