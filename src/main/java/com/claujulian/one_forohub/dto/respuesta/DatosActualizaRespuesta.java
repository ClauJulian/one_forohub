package com.claujulian.one_forohub.dto.respuesta;

import jakarta.validation.constraints.NotNull;

public record DatosActualizaRespuesta(
        @NotNull
        Long id,
        String autor_respuesta,
        String respuesta
) {
}
