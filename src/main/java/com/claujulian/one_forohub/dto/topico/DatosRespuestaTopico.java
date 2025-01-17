package com.claujulian.one_forohub.dto.topico;

import com.claujulian.one_forohub.model.Categoria;
import com.claujulian.one_forohub.model.Curso;
import com.claujulian.one_forohub.model.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        @NotNull
        String nombre_alumno,
        @NotNull
        Categoria categoria,
        @NotBlank
        String mensaje,
        @NotNull
        Estado estado,
        @NotNull
        Curso curso,
        @NotBlank
        LocalDateTime fecha_creacion
) {
}
