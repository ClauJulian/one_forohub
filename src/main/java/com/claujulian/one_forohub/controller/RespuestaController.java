package com.claujulian.one_forohub.controller;

import com.claujulian.one_forohub.dto.respuesta.*;
import com.claujulian.one_forohub.model.*;
import com.claujulian.one_forohub.repository.RespuestaRepository;
import com.claujulian.one_forohub.repository.TopicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    private ValidaRegistraRespuesta validaRegistraRespuesta;


    @PostMapping
    public ResponseEntity<DatosMuestraRespuesta> registraRespuesta(@RequestBody @Valid DatosRegistraRespuesta datosRegistraRespuesta, UriComponentsBuilder uriComponentsBuilder){

        //Respuesta respuesta = new Respuesta(datosRegistraRespuesta);

        Respuesta respuesta = validaRegistraRespuesta.registra(datosRegistraRespuesta);
        //respuesta.setEstado(EstadoRespuesta.ENVIADA);
        respuestaRepository.save(respuesta);

        Topico topico = topicoRepository.getReferenceById(datosRegistraRespuesta.id_topico());
        topico.actualizaDatos(Estado.CONTESTADO);
        topicoRepository.save(topico);

        DatosMuestraRespuesta datosMuestraRespuesta = new DatosMuestraRespuesta(
                topico.getId(),
                topico.getMensaje(),
                topico.getAlumno().getNombre(),
                respuesta.getAutor_respuesta(),
                respuesta.getRespuesta(),
                respuesta.getEstado(),
                respuesta.getFecha_creacion()
                );

        URI url= uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
    return ResponseEntity.created(url).body(datosMuestraRespuesta);
    }

    @GetMapping
    public Page<DatosListadoRespuesta> listarRespuestas(Pageable paginacion){
        return respuestaRepository.findAll(paginacion).map(DatosListadoRespuesta::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosMuestraRespuesta> actualizarRespuesta(@RequestBody @Valid DatosActualizaRespuesta datosActualizaRespuesta){

        Respuesta respuesta =respuestaRepository.getReferenceById(datosActualizaRespuesta.id());
        respuesta.actualizaDatos(datosActualizaRespuesta);
        respuestaRepository.save(respuesta);
        Topico topico = topicoRepository.getReferenceById(respuesta.getId_topico());

        return ResponseEntity.ok(new DatosMuestraRespuesta(
                    respuesta.getId_topico(),
                    topico.getMensaje(),
                    topico.getAlumno().getNombre(),
                    respuesta.getAutor_respuesta(),
                    respuesta.getRespuesta(),
                    respuesta.getEstado(),
                    respuesta.getFecha_creacion()
        ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminaRespuesta(@PathVariable Long id){
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuesta.eliminaRespuesta();
        respuestaRepository.save(respuesta);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosMuestraRespuesta> obtenerRespuesta(@PathVariable Long id){
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        Topico topico = topicoRepository.getReferenceById(respuesta.getId_topico());

        var respuestaObtenida = new DatosMuestraRespuesta(
                respuesta.getId_topico(),
                topico.getMensaje(),
                topico.getAlumno().getNombre(),
                respuesta.getAutor_respuesta(),
                respuesta.getRespuesta(),
                respuesta.getEstado(),
                respuesta.getFecha_creacion());
        return ResponseEntity.ok(respuestaObtenida);
    }

}

