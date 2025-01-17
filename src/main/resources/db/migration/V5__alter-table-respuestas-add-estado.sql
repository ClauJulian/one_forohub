ALTER TABLE respuestas ADD COLUMN estado VARCHAR(10);

UPDATE respuestas SET estado = 'ENVIADA';

ALTER TABLE respuestas
ALTER COLUMN estado SET NOT NULL;