package com.br.placarbr_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.placarbr_api.domain.dto.AutenticacaoDTO;
import com.br.placarbr_api.domain.model.Usuario;
import com.br.placarbr_api.infra.security.DadosToken;
import com.br.placarbr_api.infra.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO dados) {
		Authentication authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		Authentication authenticate = manager.authenticate(authenticationToken);

		String tokenJWT = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

		return ResponseEntity.ok(new DadosToken(tokenJWT));
	}

}
