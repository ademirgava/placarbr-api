package com.br.placarbr_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.placarbr_api.domain.model.CampeonatoTime;

public interface CameponatoTimesRepository extends JpaRepository<CampeonatoTime, Long>{

	boolean existsByCampeonatoIdAndEquipeId(Long campeonatoId, Long equipeId);

	Optional<CampeonatoTime> findByIdAndCampeonatoId(Long cameponatoTimeId, Long campeonatoId);

	List<CampeonatoTime> findAllByCampeonatoId(Long campeonatoId);

}
