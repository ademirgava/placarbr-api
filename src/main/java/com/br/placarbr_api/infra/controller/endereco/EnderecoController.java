package com.br.placarbr_api.infra.controller.endereco;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.placarbr_api.application.usecases.endereco.BuscarViaCepEnedereco;
import com.br.placarbr_api.domain.entities.Endereco;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	private final BuscarViaCepEnedereco buscarViaCepEnedereco;

	public EnderecoController(BuscarViaCepEnedereco buscarViaCepEnedereco) {
		this.buscarViaCepEnedereco = buscarViaCepEnedereco;
	}
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<EnderecoViaCepDTO> buscarViaCep(@PathVariable String cep) {
		Endereco enderecoDomain = buscarViaCepEnedereco.buscar(cep);
		return ResponseEntity.ok(new EnderecoViaCepDTO(enderecoDomain));
	}
}
