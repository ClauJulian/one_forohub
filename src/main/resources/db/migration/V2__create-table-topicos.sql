CREATE TABLE IF NOT EXISTS topicos(
    id BIGSERIAL NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    mensaje TEXT NOT NULL,
    alumno_id BIGINT NOT NULL,
    estado VARCHAR(100) NOT NULL,
    curso VARCHAR(20),
    fecha_creacion TIMESTAMP NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_topicos_alumno_id FOREIGN KEY(alumno_id) REFERENCES alumnos(id)

);