ALTER TABLE alumnos ADD COLUMN activo BOOLEAN;

UPDATE alumnos SET activo = true;

ALTER TABLE alumnos
ALTER COLUMN activo SET NOT NULL;