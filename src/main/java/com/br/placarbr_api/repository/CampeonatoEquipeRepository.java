package com.br.placarbr_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.placarbr_api.domain.model.Campeonato;
import com.br.placarbr_api.domain.model.CampeonatoEquipe;
import com.br.placarbr_api.domain.model.CampeonatoFase;
import com.br.placarbr_api.domain.model.Equipe;

public interface CampeonatoEquipeRepository extends JpaRepository<CampeonatoEquipe, Long> {

	List<CampeonatoEquipe> findAllByCampeonatoId(Long id);

	List<CampeonatoEquipe> findAllByCampeonatoIdAndCampeonatoFaseId(Long id, Long idFase);

	List<CampeonatoEquipe> findAllByCampeonatoAndCampeonatoFase(Campeonato campeonato, CampeonatoFase campeonatoFase);

	boolean existsByCampeonatoAndCampeonatoFaseAndEquipe(Campeonato campeonato, CampeonatoFase campeonatoFase, Equipe equipe);

}
