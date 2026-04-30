package com.br.placarbr_api.config.pageable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.placarbr_api.infra.gateways.pageable.PageableMapper;

@Configuration
public class PageableConfig {

	@Bean
	PageableMapper pageableMapper() {
		return new PageableMapper();
	}
}
