package com.br.placarbr_api.domain.entities.atleta;

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
