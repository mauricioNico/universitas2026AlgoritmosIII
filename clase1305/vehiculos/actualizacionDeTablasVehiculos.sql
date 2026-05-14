DROP DATABASE IF EXISTS concesionaria;
CREATE DATABASE concesionaria;
USE concesionaria;

CREATE TABLE vehiculo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) NOT NULL
);

CREATE TABLE motor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL,
    cilindrada INT NOT NULL
);

CREATE TABLE auto (
    id INT PRIMARY KEY,
    motor_id INT NOT NULL,
    FOREIGN KEY (id) REFERENCES vehiculo(id),
    FOREIGN KEY (motor_id) REFERENCES motor(id)
);

CREATE TABLE camion (
    id INT PRIMARY KEY,
    motor_id INT NOT NULL,
    capacidad_carga DOUBLE NOT NULL,
    FOREIGN KEY (id) REFERENCES vehiculo(id),
    FOREIGN KEY (motor_id) REFERENCES motor(id)
);

CREATE TABLE rueda (
    id INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(50) NOT NULL,
    diametro INT NOT NULL,
    vehiculo_id INT NOT NULL,
    FOREIGN KEY (vehiculo_id) REFERENCES vehiculo(id)
);