package com.br.placarbr_api.infra.controller;

import java.util.List;

public record PageResult<T>(List<T> itens, int pagina, int tamanho, Long totalDeItens) {

}
