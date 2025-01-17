package com.claujulian.one_forohub.dto.alumno;

import jakarta.validation.constraints.NotNull;

public record DatosActualizaAlumno(
        @NotNull
        Long id,
        String nombre,
        String email
) { }
