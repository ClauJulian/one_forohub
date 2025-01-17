package com.claujulian.one_forohub.dto.alumno;

import com.claujulian.one_forohub.model.Curso;


import java.time.LocalDate;

public record DatosRespuestaAlumno(
        Long id,
        String nombre,
        String email,
        String matricula,
        String nacionalidad,
        LocalDate fecha_nacimiento,
        Curso curso_actual
) {
}
