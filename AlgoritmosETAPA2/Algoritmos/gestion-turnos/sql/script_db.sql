-- 1. Creación de la Base de Datos
CREATE DATABASE gestion_turnos;
USE gestion_turnos;

-- 2. Tabla ESPECIALIDAD
-- (Debe ser la primera porque Profesional depende de ella)
CREATE TABLE especialidad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);

-- 3. Tabla PACIENTE
CREATE TABLE paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(20) NOT NULL UNIQUE,
    numero_afiliado VARCHAR(50) NOT NULL
);

-- 4. Tabla PROFESIONAL
CREATE TABLE profesional (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(20) NOT NULL UNIQUE,
    matricula VARCHAR(50) NOT NULL,
    especialidad_id INT,
    FOREIGN KEY (especialidad_id) REFERENCES especialidad(id) ON DELETE SET NULL
);

-- 5. Tabla CONSULTORIO
CREATE TABLE consultorio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    sector VARCHAR(100) NOT NULL
);

-- 6. Tabla TURNO
-- (Une las tres entidades principales con las fechas y horas correspondientes)
CREATE TABLE turno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    profesional_id INT NOT NULL,
    consultorio_id INT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    estado VARCHAR(30) NOT NULL,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (profesional_id) REFERENCES profesional(id) ON DELETE CASCADE,
    FOREIGN KEY (consultorio_id) REFERENCES consultorio(id) ON DELETE CASCADE
);