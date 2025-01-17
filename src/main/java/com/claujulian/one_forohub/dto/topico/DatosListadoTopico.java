package com.claujulian.one_forohub.dto.topico;

import com.claujulian.one_forohub.model.Curso;
import com.claujulian.one_forohub.model.Estado;
import com.claujulian.one_forohub.model.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String nombre_alumno,
        Curso curso,
        String mensaje,
        Estado estado,
        LocalDateTime fecha_creacion
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getAlumno().getNombre(),topico.getCurso(),topico.getMensaje(),topico.getEstado(),topico.getFecha_creacion());
    }
}
