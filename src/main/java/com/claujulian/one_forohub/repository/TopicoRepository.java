package com.claujulian.one_forohub.repository;

import com.claujulian.one_forohub.model.Estado;
import com.claujulian.one_forohub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("SELECT t FROM Topico t WHERE t.estado != :estado")
    Page<Topico> findByEstadoNot(Estado estado, Pageable paginacion);

    @Query("SELECT t FROM Topico t WHERE t.alumno = :id")
    List<Topico> topicosDeAlumno(Long id);
}
