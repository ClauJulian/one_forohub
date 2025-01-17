package com.claujulian.one_forohub.dto.respuesta;

import com.claujulian.one_forohub.model.Respuesta;

import java.time.LocalDateTime;

public record DatosListadoRespuesta(
        Long id,
        Long id_topico,
        String autor_respuesta,
        String respuesta,
        LocalDateTime fecha_creacion
) {

    public DatosListadoRespuesta(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getId_topico(), respuesta.getAutor_respuesta(), respuesta.getRespuesta(), respuesta.getFecha_creacion());
    }
}
