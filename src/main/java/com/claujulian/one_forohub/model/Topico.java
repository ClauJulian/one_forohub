package com.claujulian.one_forohub.model;

import com.claujulian.one_forohub.dto.topico.DatosActualizaTopico;
import com.claujulian.one_forohub.dto.topico.DatosRegistroTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name="topicos")
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private String mensaje;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "curso")
    @Enumerated(EnumType.STRING)
    private Curso curso;

    private LocalDateTime fecha_creacion;

    public Topico() {
    }

    public Topico(DatosRegistroTopico datosRegistroTopico, Alumno alumno) {
        this.alumno=alumno;
        this.categoria=datosRegistroTopico.categoria();
        this.mensaje= datosRegistroTopico.mensaje();
        this.estado=datosRegistroTopico.estado();
        this.curso=datosRegistroTopico.curso();
        this.fecha_creacion=LocalDateTime.now();

    }

    public Long getId() {
        return id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Estado getEstado() {
        return estado;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void actualizaDatos(DatosActualizaTopico datosActualizaTopico) {
        if(datosActualizaTopico.categoria() != null){
            this.categoria=datosActualizaTopico.categoria();
        }
        if(datosActualizaTopico.mensaje() != null){
            this.mensaje= datosActualizaTopico.mensaje();
        }
    }

    public void actualizaDatos(Estado estado){
        this.estado=estado;
    }
}
