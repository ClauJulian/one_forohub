package com.claujulian.one_forohub.dto.topico;

import com.claujulian.one_forohub.infra.validaciones.ValidadorDeTopico;
import com.claujulian.one_forohub.model.Alumno;
import com.claujulian.one_forohub.model.Topico;
import com.claujulian.one_forohub.model.ValidacionException;
import com.claujulian.one_forohub.repository.AlumnoRepository;
import com.claujulian.one_forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidaRegistraTopico {
    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    List<ValidadorDeTopico> validadores;

    public Topico registra(DatosRegistroTopico datos){

        if(!alumnoRepository.existsById(datos.id_alumno())){
            throw new ValidacionException("El alumno no existe.");
        }
        Alumno alumno = alumnoRepository.getReferenceById(datos.id_alumno());

        validadores.forEach(v-> v.validar(datos));

        Topico topico = new Topico(datos, alumno);

        topicoRepository.save(topico);


        return topico;
    }
}
