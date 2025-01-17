CREATE TABLE IF NOT EXISTS alumnos(
    id BIGSERIAL NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL unique,
    matricula VARCHAR(100) NOT NULL,

    nacionalidad VARCHAR(100) NOT NULL,
    curso_actual VARCHAR(20),
    fecha_nacimiento TIMESTAMP NOT NULL,

    PRIMARY KEY(id)

);