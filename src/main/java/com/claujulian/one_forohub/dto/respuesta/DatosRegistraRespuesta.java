package com.claujulian.one_forohub.dto.respuesta;

import com.claujulian.one_forohub.model.EstadoRespuesta;
import jakarta.validation.constraints.NotNull;

public record DatosRegistraRespuesta(
        @NotNull
        Long id_topico,
        String autor_respuesta,
        String respuesta
) {
}
