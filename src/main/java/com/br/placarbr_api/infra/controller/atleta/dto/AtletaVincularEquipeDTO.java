package com.br.placarbr_api.infra.controller.atleta.dto;

import jakarta.validation.constraints.NotNull;

public record AtletaVincularEquipeDTO(@NotNull Long equipeId, @NotNull Long atletaId)

{

}
