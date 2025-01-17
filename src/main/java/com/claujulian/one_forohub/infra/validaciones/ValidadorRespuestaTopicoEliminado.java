package com.claujulian.one_forohub.infra.validaciones;

import com.claujulian.one_forohub.dto.respuesta.DatosRegistraRespuesta;
import com.claujulian.one_forohub.model.Estado;
import com.claujulian.one_forohub.model.Topico;
import com.claujulian.one_forohub.model.ValidacionException;
import com.claujulian.one_forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorRespuestaTopicoEliminado implements ValidadorDeRespuesta {
    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(DatosRegistraRespuesta datos) {

        if(datos.id_topico() == null){ return;}

        Topico topico = topicoRepository.getReferenceById(datos.id_topico());

        System.out.println(topico.getEstado());
        if(topico.getEstado().equals(Estado.ELIMINADO)){
            throw new ValidacionException("El Tópico es de un alumno no activo.");
        }

    }
}
