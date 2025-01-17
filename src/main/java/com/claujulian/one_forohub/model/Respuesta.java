package com.claujulian.one_forohub.model;

import com.claujulian.one_forohub.dto.respuesta.DatosActualizaRespuesta;
import com.claujulian.one_forohub.dto.respuesta.DatosRegistraRespuesta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name="respuestas")
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_topico;
    private String autor_respuesta;
    private String respuesta;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoRespuesta estado;

    private LocalDateTime fecha_creacion;

    public Respuesta() {
    }

    public Respuesta(DatosRegistraRespuesta datosRegistraRespuesta) {
        this.id_topico= datosRegistraRespuesta.id_topico();
        this.autor_respuesta= datosRegistraRespuesta.autor_respuesta();
        this.respuesta= datosRegistraRespuesta.respuesta();
        this.fecha_creacion= LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getId_topico() {
        return id_topico;
    }

    public String getAutor_respuesta() {
        return autor_respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public EstadoRespuesta getEstado() {
        return estado;
    }

    public void setEstado(EstadoRespuesta estado) {
        this.estado = estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_topico(Long id_topico) {
        this.id_topico = id_topico;
    }

    public void setAutor_respuesta(String autor_respuesta) {
        this.autor_respuesta = autor_respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public void actualizaDatos(DatosActualizaRespuesta datosActualizaRespuesta) {
        if(datosActualizaRespuesta.autor_respuesta() != null){
            this.autor_respuesta= datosActualizaRespuesta.autor_respuesta();
            this.fecha_creacion=LocalDateTime.now();
        }
        if(datosActualizaRespuesta.respuesta() != null){
            this.respuesta= datosActualizaRespuesta.respuesta();
            this.fecha_creacion=LocalDateTime.now();
        }

    }

    public void eliminaRespuesta(){
        this.estado=EstadoRespuesta.ELIMINADA;
    }
}
