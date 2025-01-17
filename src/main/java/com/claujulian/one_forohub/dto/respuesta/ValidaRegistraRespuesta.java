package com.claujulian.one_forohub.dto.respuesta;

import com.claujulian.one_forohub.infra.validaciones.ValidadorDeRespuesta;
import com.claujulian.one_forohub.model.EstadoRespuesta;
import com.claujulian.one_forohub.model.Respuesta;
import com.claujulian.one_forohub.model.ValidacionException;
import com.claujulian.one_forohub.repository.RespuestaRepository;
import com.claujulian.one_forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidaRegistraRespuesta {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    List<ValidadorDeRespuesta> validadores;

    public Respuesta registra(DatosRegistraRespuesta datos){

        if(!topicoRepository.existsById(datos.id_topico())){
            throw new ValidacionException("El Tópico no existe en la Base de Datos");
        }

        validadores.forEach(v->v.validar(datos));

        Respuesta respuesta = new Respuesta(datos);
        respuesta.setEstado(EstadoRespuesta.ENVIADA);

        respuestaRepository.save(respuesta);

        return respuesta;
    }
}
