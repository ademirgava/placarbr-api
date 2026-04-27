package com.br.placarbr_api.infra.persistence.comissao_tecnica_tipo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.placarbr_api.domain.entities.comissao_tecnica_tipo.ComissaoTecnicaTipo;

public interface ComissaoTecnicaTipoRepository extends JpaRepository<ComissaoTecnicaTipoEntity, Long>{

}
