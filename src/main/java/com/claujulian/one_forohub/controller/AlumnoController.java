package com.claujulian.one_forohub.controller;

import com.claujulian.one_forohub.dto.alumno.DatosActualizaAlumno;
import com.claujulian.one_forohub.dto.alumno.DatosListadoAlumno;
import com.claujulian.one_forohub.dto.alumno.DatosRegistroAlumno;
import com.claujulian.one_forohub.dto.alumno.DatosRespuestaAlumno;
import com.claujulian.one_forohub.model.Alumno;
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
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/alumnos")
@SecurityRequirement(name = "bearer-key")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaAlumno> registraAlumno(@RequestBody @Valid DatosRegistroAlumno datosRegistroAlumno, UriComponentsBuilder uriComponentsBuilder) {
        Alumno alumno = alumnoRepository.save(new Alumno(datosRegistroAlumno));
        DatosRespuestaAlumno datosRespuestaAlumno = new DatosRespuestaAlumno(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getEmail(),
                alumno.getMatricula(),
                alumno.getNacionalidad(),
                alumno.getFecha_nacimiento(),
                alumno.getCurso_actual());

        URI url = uriComponentsBuilder.path("/alumnos/{id}").buildAndExpand(alumno.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaAlumno);
    }

    @GetMapping
    public Page<DatosListadoAlumno> listaAlumnos(@PageableDefault(sort = "nombre") Pageable paginacion) {
        return alumnoRepository.findByActivoTrue(paginacion).map(DatosListadoAlumno::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaAlumno> actualizaAlumno(@RequestBody @Valid DatosActualizaAlumno datosActualizaAlumno) {
        Alumno alumno = alumnoRepository.getReferenceById(datosActualizaAlumno.id());
        alumno.actualizaDatos(datosActualizaAlumno);
        return ResponseEntity.ok(new DatosRespuestaAlumno(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getEmail(),
                alumno.getMatricula(),
                alumno.getNacionalidad(),
                alumno.getFecha_nacimiento(),
                alumno.getCurso_actual()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarAlumno(@PathVariable Long id) {
        Alumno alumno = alumnoRepository.getReferenceById(id);
        alumno.desactivarAlumno();

        // eliminar topicos del alumno
        List<Topico> topicosDeAlumnoEliminado = topicoRepository.topicosDeAlumno(id);
        topicosDeAlumnoEliminado.forEach(topico -> {
            topico.setEstado(Estado.ELIMINADO);
            topicoRepository.save(topico);
        });
        // eliminar respuestas a esos topicos?
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaAlumno> obtenerAlumno(@PathVariable Long id) {
        Alumno alumno = alumnoRepository.getReferenceById(id);
        var alumnoObtenido = new DatosRespuestaAlumno(alumno.getId(),
                alumno.getNombre(),
                alumno.getEmail(),
                alumno.getMatricula(),
                alumno.getNacionalidad(),
                alumno.getFecha_nacimiento(),
                alumno.getCurso_actual());
        return ResponseEntity.ok(alumnoObtenido);

    }
}