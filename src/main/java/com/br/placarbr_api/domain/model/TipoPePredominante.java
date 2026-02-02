package com.br.placarbr_api.domain.model;

public enum TipoPePredominante {
	DIREITO("Direito"),
	ESQUERDO("Esquerdo"),
	AMBIDESTRO("Ambidestro");

	private String tipo;

	private TipoPePredominante(String descricao) {
        this.tipo = descricao;
    }

    public String getDescricao() {
        return tipo;
    }
}
