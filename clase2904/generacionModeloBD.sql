create database concesionaria;
use concesionaria;
CREATE TABLE vehiculo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    tipo VARCHAR(20)
);
CREATE TABLE rueda (
    id INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(50),
    medida INT,
    vehiculo_id INT,
    FOREIGN KEY (vehiculo_id) REFERENCES vehiculo(id)
);
CREATE TABLE motor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50),
    cilindrada INT
);
CREATE TABLE camion (
    id INT PRIMARY KEY,
    motor_id INT,
    capacidad_carga DOUBLE,
    FOREIGN KEY (id) REFERENCES vehiculo(id),
    FOREIGN KEY (motor_id) REFERENCES motor(id)
);
CREATE TABLE auto (
    id INT PRIMARY KEY,
    motor_id INT,
    FOREIGN KEY (id) REFERENCES vehiculo(id),
    FOREIGN KEY (motor_id) REFERENCES motor(id)
);
