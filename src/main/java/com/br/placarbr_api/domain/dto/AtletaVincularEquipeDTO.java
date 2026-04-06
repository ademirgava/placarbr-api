package com.br.placarbr_api.domain.dto;

import jakarta.validation.constraints.NotNull;

public record AtletaVincularEquipeDTO(@NotNull Long equipeId, @NotNull Long atletaId)

{

}
