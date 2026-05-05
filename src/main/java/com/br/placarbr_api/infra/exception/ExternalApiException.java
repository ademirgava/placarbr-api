package com.br.placarbr_api.infra.exception;

public class ExternalApiException extends RuntimeException {
	
	public ExternalApiException(String mensagem) {
		super(mensagem);
	}

}
