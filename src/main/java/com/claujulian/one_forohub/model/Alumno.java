package com.claujulian.one_forohub.model;

import com.claujulian.one_forohub.dto.alumno.DatosActualizaAlumno;
import com.claujulian.one_forohub.dto.alumno.DatosRegistroAlumno;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Entity
@Table(name="alumnos")
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Alumno{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String matricula;
    private String nacionalidad;
    private LocalDate fecha_nacimiento;

    @Column(name = "curso_actual")
    @Enumerated(EnumType.STRING)
    private Curso curso_actual;

    private boolean activo;

    public Alumno() {
    }

    public Alumno(DatosRegistroAlumno datosRegistroAlumno){
        this.activo=true;
        this.nombre=datosRegistroAlumno.nombre();
        this.email=datosRegistroAlumno.email();
        this.matricula=datosRegistroAlumno.matricula();
        this.nacionalidad=datosRegistroAlumno.nacionalidad();
        this.fecha_nacimiento=datosRegistroAlumno.fecha_nacimiento();
        this.curso_actual=datosRegistroAlumno.curso_actual();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public Curso getCurso_actual() {
        return curso_actual;
    }

    public boolean isActivo() {
        return activo;
    }

    public void actualizaDatos(DatosActualizaAlumno datosActualizaAlumno){
        if(datosActualizaAlumno.nombre() != null){
            this.nombre = datosActualizaAlumno.nombre();
        }
        if(datosActualizaAlumno.email() != null){
            this.nombre = datosActualizaAlumno.email();
        }
    }

    public void desactivarAlumno() {
        this.activo=false;
    }
}
