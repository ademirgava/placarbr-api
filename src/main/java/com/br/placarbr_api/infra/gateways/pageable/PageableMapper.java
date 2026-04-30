package com.br.placarbr_api.infra.gateways.pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.br.placarbr_api.domain.entities.Paginacao;

public class PageableMapper {
	
	public Pageable toPageable(Paginacao paginacao) {
		Sort sort = paginacao.direcao().equalsIgnoreCase("desc") ? Sort.by(paginacao.sortBy()).descending()
				: Sort.by(paginacao.sortBy()).ascending();
		return PageRequest.of(paginacao.page(), paginacao.size(), sort);
	}
}
