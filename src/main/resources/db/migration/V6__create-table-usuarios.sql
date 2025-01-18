CREATE TABLE IF NOT EXISTS usuarios(
    id BIGSERIAL NOT NULL,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(300) NOT NULL,

    PRIMARY KEY(id)
);

INSERT INTO usuarios(id,login,password)
VALUES(1,'maria.perez','$2y$10$8C8ZZjbEBF8SKsamZVgVWudn0WoReHs3cgdnrnuXGFIk62Ytku.sC');