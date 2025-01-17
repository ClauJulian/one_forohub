package com.claujulian.one_forohub.repository;

import com.claujulian.one_forohub.model.Respuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    Page<Respuesta> findAll(Pageable paginacion);
}
