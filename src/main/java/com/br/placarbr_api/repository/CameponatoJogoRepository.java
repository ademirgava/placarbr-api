package com.br.placarbr_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.placarbr_api.domain.model.CampeonatoJogo;

public interface CameponatoJogoRepository extends JpaRepository<CampeonatoJogo, Long> {

	boolean existsByTimeMandanteIdAndTimeVisitanteId(Long cameponatoTimeMandateId, Long cameponatoTimeVisitanteId);

    @Query(value = "select CASE WHEN count(*) > 0 THEN true ELSE false END  from campeonato_jogos j where j.rodada=:rodada and (j.time_mandante_id=:mandateId or j.time_visitante_id=:visitanteId)", nativeQuery = true)
	int temRodadaAndTimeMandanteIdOrTimeVisitanteId(Long mandateId, Long visitanteId, Integer rodada);

	Page<CampeonatoJogo> findByCampeonatoId(Long campeonatoId, Pageable paginacao);

}
