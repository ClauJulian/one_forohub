package com.claujulian.one_forohub.dto.alumno;

import com.claujulian.one_forohub.model.Alumno;
import com.claujulian.one_forohub.model.Curso;

public record DatosListadoAlumno(
        Long id,
        String nombre,
        String matricula,
        Curso curso_actual
) {
    public DatosListadoAlumno(Alumno alumno){
        this(alumno.getId(),alumno.getNombre(),alumno.getMatricula(),alumno.getCurso_actual());
    }
}
