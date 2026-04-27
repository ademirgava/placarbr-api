package com.br.placarbr_api.domain.entities;

import java.util.List;

public record Pagina<T>(List<T> itens, int pagina, int totalItens, Long tamanho) {

}
