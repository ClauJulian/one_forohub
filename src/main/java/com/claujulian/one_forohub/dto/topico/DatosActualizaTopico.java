package com.claujulian.one_forohub.dto.topico;

import com.claujulian.one_forohub.model.Categoria;
import jakarta.validation.constraints.NotNull;

public record DatosActualizaTopico(
        @NotNull
        Long id,
        Categoria categoria,
        String mensaje) {
}
