package com.claujulian.one_forohub.dto.respuesta;

import com.claujulian.one_forohub.model.EstadoRespuesta;

import java.time.LocalDateTime;

public record DatosMuestraRespuesta(
        Long id_topico,
        String topico,
        String nombre_alumno,
        String autor_respuesta,
        String respuesta,
        EstadoRespuesta estado,
        LocalDateTime fecha_creacion
) { }

