package com.claujulian.one_forohub.dto.topico;

import com.claujulian.one_forohub.model.Categoria;
import com.claujulian.one_forohub.model.Curso;
import com.claujulian.one_forohub.model.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistroTopico(
        @NotNull
        Long id_alumno,
        @NotNull
        Categoria categoria,
        @NotBlank
        String mensaje,
        @NotNull
        Estado estado,
        @NotNull
        Curso curso
) {
}