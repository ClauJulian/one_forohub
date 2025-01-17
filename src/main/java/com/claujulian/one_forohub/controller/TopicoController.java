package com.claujulian.one_forohub.controller;

import com.claujulian.one_forohub.dto.topico.*;
import com.claujulian.one_forohub.model.Estado;
import com.claujulian.one_forohub.model.Topico;
import com.claujulian.one_forohub.repository.AlumnoRepository;
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
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private ValidaRegistraTopico validaRegistraTopico;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registraTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){

        Topico topico = validaRegistraTopico.registra(datosRegistroTopico);

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getAlumno().getNombre(),
                topico.getCategoria(),
                topico.getMensaje(),
                topico.getEstado(),
                topico.getCurso(),
                topico.getFecha_creacion()
                );

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public Page<DatosListadoTopico> listaTopico(Pageable paginacion){
        return topicoRepository.findByEstadoNot(Estado.ELIMINADO, paginacion).map(DatosListadoTopico::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminaTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        topico.setEstado(Estado.valueOf("ELIMINADO"));
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizaTopico(@RequestBody @Valid DatosActualizaTopico datosActualizaTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizaTopico.id());
        topico.actualizaDatos(datosActualizaTopico);

        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getAlumno().getNombre(),
                topico.getCategoria(),
                topico.getMensaje(),
                topico.getEstado(),
                topico.getCurso(),
                topico.getFecha_creacion()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> obtenerUnTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        var topicoEncontrado= new DatosRespuestaTopico(
                topico.getAlumno().getNombre(),
                topico.getCategoria(),
                topico.getMensaje(),
                topico.getEstado(),
                topico.getCurso(),
                topico.getFecha_creacion());
        return ResponseEntity.ok(topicoEncontrado);
    }

}
