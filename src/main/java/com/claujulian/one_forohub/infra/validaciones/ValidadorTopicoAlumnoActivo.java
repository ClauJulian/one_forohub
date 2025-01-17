package com.claujulian.one_forohub.infra.validaciones;

import com.claujulian.one_forohub.dto.topico.DatosRegistroTopico;
import com.claujulian.one_forohub.model.ValidacionException;
import com.claujulian.one_forohub.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoAlumnoActivo implements ValidadorDeTopico{

   @Autowired
    AlumnoRepository alumnoRepository;


    @Override
    public void validar(DatosRegistroTopico datos) {
        if(datos.id_alumno() == null){
            return;
        }

         var alumnoActivo= alumnoRepository.findActivoById(datos.id_alumno());

        if(!alumnoActivo){
            throw new ValidacionException("El alumno no se encuentra activo en la Base de Datos");
        }

    }
}
