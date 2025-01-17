CREATE TABLE IF NOT EXISTS respuestas(
    id BIGSERIAL NOT NULL,
    id_topico BIGINT NOT NULL,
    autor_respuesta VARCHAR(20) NOT NULL,
    respuesta TEXT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,

    PRIMARY KEY(id)
);