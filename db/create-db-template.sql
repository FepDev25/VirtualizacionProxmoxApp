
-- Tabla PAIS
CREATE TABLE pais (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla POSICION
CREATE TABLE posicion (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Tabla EQUIPO
CREATE TABLE equipo (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100),
    anio_fundacion INTEGER
);

-- Tabla JUGADOR
CREATE TABLE jugador (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INTEGER,
    equipo_id INTEGER REFERENCES equipo(id) ON DELETE SET NULL,
    pais_id INTEGER REFERENCES pais(id) ON DELETE SET NULL,
    posicion_id INTEGER REFERENCES posicion(id) ON DELETE SET NULL
);

-- Tabla DT (Director Técnico)
CREATE TABLE dt (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    pais_id INTEGER REFERENCES pais(id) ON DELETE SET NULL,
    equipo_id INTEGER UNIQUE REFERENCES equipo(id) ON DELETE CASCADE
);
