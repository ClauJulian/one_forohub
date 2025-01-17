package com.claujulian.one_forohub.repository;

import com.claujulian.one_forohub.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Page<Alumno> findByActivoTrue(Pageable paginacion);

    @Query("""
            select a.activo from Alumno a
            where
            a.id = :idAlumno
            """)
    Boolean findActivoById(Long idAlumno);
}
