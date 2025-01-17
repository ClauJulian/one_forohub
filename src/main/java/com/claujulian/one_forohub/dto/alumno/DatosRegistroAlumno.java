package com.claujulian.one_forohub.dto.alumno;

import com.claujulian.one_forohub.model.Curso;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record DatosRegistroAlumno(
        @NotBlank
        String nombre,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp ="\\d{4,6}")
        String matricula,

        @NotBlank
        String nacionalidad,

        @NotNull
        @Past
        LocalDate fecha_nacimiento,

        @NotNull
        Curso curso_actual

) {
}
