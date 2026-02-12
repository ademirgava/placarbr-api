package com.br.placarbr_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.placarbr_api.domain.model.CampeonatoJogo;

public interface CameponatoJogoRepository extends JpaRepository<CampeonatoJogo, Long> {

	boolean existsByTimeMandanteIdAndTimeVisitanteId(Long cameponatoTimeMandateId, Long cameponatoTimeVisitanteId);

	boolean existsByTimeMandanteIdOrTimeVisitanteIdAndRodada(Long mandateId, Long vistanteId, Integer rodada);

	Page<CampeonatoJogo> findByCampeonatoId(Long campeonatoId, Pageable paginacao);

}
