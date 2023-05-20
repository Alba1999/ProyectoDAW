/******************************* BASE DE DATOS *******************************/
DROP DATABASE IF EXISTS protectora_db;
CREATE DATABASE IF NOT EXISTS protectora_db 
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
USE protectora_db;



/*********************************** TABLAS ***********************************/
CREATE TABLE animal (
  animal_id INT PRIMARY KEY,
  chip INT,
  nombre VARCHAR(50),
  especie VARCHAR(50),
  sexo VARCHAR(20),
  color VARCHAR(20),
  tamano VARCHAR(20),
  /* ISA */
  estado ENUM('sin hogar', 'adopción', 'acogida', 'recogido'),
  fecha_nacimiento DATE, 
  imagen VARCHAR(200)
);

CREATE TABLE historial (
  num_his INT PRIMARY KEY,
  patologias VARCHAR(100),
  veterinario VARCHAR(50),
  fecha_consulta DATE,
  medicamentos VARCHAR(100),
  id_animal INT,
  FOREIGN KEY (id_animal) REFERENCES animal(animal_id)
);

CREATE TABLE clinica (
  cif INT PRIMARY KEY,
  num_contacto VARCHAR(20),
  nombre_cli VARCHAR(100),
  direccion VARCHAR(200),
  ciudad VARCHAR(50),
  fecha_consulta DATE
);

CREATE TABLE vacunas (
  id_vac INT PRIMARY KEY,
  nombre VARCHAR(200),
  descripcion VARCHAR(200),
  fecha_caducidad DATE,
  marca VARCHAR(50),
  lote VARCHAR(20),
  clinica_cif INT,
  FOREIGN KEY (clinica_cif) REFERENCES clinica(cif)
);

CREATE TABLE empleado (
  DNI VARCHAR(9),
  num_seg_soc INT PRIMARY KEY,
  direccion VARCHAR(200),
  nombre VARCHAR(50),
  apellidos VARCHAR(50),
  /* ISA */
  tipo_empleado ENUM('voluntario', 'asalariado'),
  clinica_cif INT,
  FOREIGN KEY (clinica_cif) REFERENCES clinica(cif)
);

CREATE TABLE seguimiento (
  num_caso INT PRIMARY KEY,
  fecha DATE,
  estado VARCHAR(50),
  empleado_num_seg_soc INT,
  id_animal_seg INT,
  FOREIGN KEY (empleado_num_seg_soc) REFERENCES empleado(num_seg_soc),
  FOREIGN KEY (id_animal_seg) REFERENCES animal(animal_id)
);

/* DE LAS RELACIONES */
CREATE TABLE clinica_historial (
  id_cli_hi INT,
  clinica_cif INT,
  historial_num_his INT,
  PRIMARY KEY (clinica_cif, historial_num_his),
  FOREIGN KEY (clinica_cif) REFERENCES clinica(cif),
  FOREIGN KEY (historial_num_his) REFERENCES historial(num_his)
);

CREATE TABLE cuidado_animal (
  id_vet_ani INT,
  animal_id INT,
  empleado_num_seg_soc INT,
  PRIMARY KEY (animal_id, empleado_num_seg_soc),
  FOREIGN KEY (animal_id) REFERENCES animal(animal_id),
  FOREIGN KEY (empleado_num_seg_soc) REFERENCES empleado(num_seg_soc)
);



/******************************** DATOS DE CARGA ********************************/
-- Insertar datos en la tabla "animal"
INSERT INTO animal (animal_id, chip, nombre, especie, sexo, color, tamano, estado, fecha_nacimiento, imagen)
VALUES (1, 123456, 'Max', 'Perro', 'Macho', 'Marrón', 'Mediano', 'sin hogar', '2020-04-10', 'imagen_max.jpg'),
       (2, 987654, 'Luna', 'Gato', 'Hembra', 'Blanco', 'Pequeño', 'adopción', '2022-09-18', 'imagen_luna.jpg'),
       (3, 456789, 'Bella', 'Perro', 'Hembra', 'Negro', 'Grande', 'sin hogar', '2019-07-20', NULL),
       (4, 987123, 'Simba', 'Gato', 'Macho', 'Naranja', 'Mediano', 'adopción', '2021-03-12', NULL),
       (5, 406789, 'Lucky', 'Perro', 'Macho', 'Blanco y marrón', 'Pequeño', 'recogido', '2022-02-28', NULL),
       (6, 567890, 'Lola', 'Gato', 'Hembra', 'Blanco y negro', 'Pequeño', 'sin hogar', NULL, NULL),
       (7, 678901, 'Rocky', 'Perro', 'Macho', 'Marrón', 'Mediano', 'acogida', '2022-09-18', NULL),
       (8, 789012, 'Coco', 'Perro', 'Macho', 'Blanco', 'Pequeño', 'adopción', '2020-04-30', NULL),
       (9, 890123, 'Luna', 'Gato', 'Hembra', 'Gris', 'Pequeño', 'recogido', '2021-07-22', NULL),
       (10, 901234, 'Max', 'Perro', 'Macho', 'Negro y blanco', 'Grande', 'sin hogar', NULL, NULL),
       (11, 123056, 'Lola', 'Gato', 'Hembra', 'Atigrado', 'Mediano', 'adopción', '2019-11-05', NULL);
       
-- Insertar datos en la tabla "historial"
INSERT INTO historial (num_his, patologias, veterinario, fecha_consulta, medicamentos, id_animal)
VALUES (1, 'Gripe canina', 'Dr. López', '2022-10-15', 'Antibióticos', 1),
       (2, 'Desparasitación', 'Dr. García', '2023-01-22', 'Antibióticos',  2),
       (3, 'Infección de oído', 'Dr. Rodríguez', '2023-04-10', 'Gotas antibióticas', 3),
       (4, 'Fractura de pata', 'Dr. Gómez', '2023-03-15', 'Férula y analgésicos', 4),
       (5, 'Problemas digestivos', 'Dra. López', '2023-02-20', 'Dieta especial y medicamentos', 5),
       (6, 'Vacunación anual', 'Dr. Martínez', '2023-05-05', 'Vacuna polivalente', 6),
       (7, 'Extracción de dientes', 'Dra. Fernández', '2023-01-10', 'Analgésicos y antibióticos', 7),
       (8, 'Desparasitación', 'Dr. Sánchez', '2023-02-28', 'Antiparasitario oral', 8);
       

-- Insertar datos en la tabla "clinica"
INSERT INTO clinica (cif, num_contacto, nombre_cli, direccion, ciudad, fecha_consulta)
VALUES ('6583473', '987654321', 'Clínica Veterinaria XYZ', 'Calle Principal 123', 'Ciudad A', '2022-12-01'),
       ('4967832', '123456789', 'Hospital Veterinario WXY', 'Avenida Central 456', 'Ciudad B', '2023-02-15'),
       ('0489673', '987654321', 'Clínica Veterinaria Amigos Peludos', 'Calle Veterinaria 123', 'Madrid', '2023-05-10'),
       ('1920390', '654321987', 'Clínica Veterinaria Patitas Felices', 'Avenida Mascotas 456', 'Barcelona', '2023-05-15'),
       ('5860352', '321654987', 'Clínica Veterinaria Cuidado Animal', 'Calle Animales 789', 'Valencia', '2023-05-12');

-- Insertar datos en la tabla "vacunas"
INSERT INTO vacunas (id_vac, nombre, descripcion, fecha_caducidad, marca, lote, clinica_cif)
VALUES (1, 'Vacuna contra la rabia', 'Protege contra la rabia en perros y gatos', '2024-05-01', 'VacunaCorp', '123ABC', '5860352'),
       (2, 'Vacuna felina triple', 'Protege contra varias enfermedades en gatos', '2023-08-10', 'FelinaVac', '456DEF', '1920390'),
       (3, 'Vacuna contra la leptospirosis', 'Protege contra la leptospirosis en perros', '2023-11-30', 'PetVax', '789XYZ', '6583473'),
       (4, 'Vacuna contra la panleucopenia', 'Protege contra la panleucopenia en gatos', '2024-04-15', 'FelinaShield', 'ABC123', '1920390'),
       (5, 'Vacuna contra la parvovirosis', 'Protege contra la parvovirosis en perros', '2023-09-20', 'DogGuard', 'DEF456', '0489673');

-- Insertar datos en la tabla "empleado"
INSERT INTO empleado (DNI, num_seg_soc, direccion, nombre, apellidos, tipo_empleado, clinica_cif)
VALUES ('11111111A', 1004, 'Calle Principal 789', 'Pedro', 'Martínez', 'asalariado', '6583473'),
       ('22222222B', 1005, 'Avenida Central 456', 'María', 'López', 'voluntario', '1920390'),
       ('33333333C', 1006, 'Calle Secundaria 123', 'Carlos', 'González', 'asalariado', '0489673'),
       ('44444444D', 1007, 'Avenida Principal 789', 'Laura', 'Hernández', 'voluntario', '6583473'),
       ('55555555E', 1008, 'Calle Central 456', 'Antonio', 'Ramírez', 'asalariado', '4967832');

-- Insertar datos en la tabla "seguimiento"
INSERT INTO seguimiento (num_caso, fecha, estado, empleado_num_seg_soc, id_animal_seg)
VALUES (1, '2023-03-20', 'En proceso', 1004, 5), 
       (2, '2023-04-05', 'Completado', 1005, 6),
	   (3, '2023-03-20', 'En proceso', 1006, 7), 
       (4, '2023-04-05', 'Completado', 1007, 8);
       
-- Insertar datos en la tabla "clinica_historial"
INSERT INTO clinica_historial (clinica_cif, historial_num_his)
VALUES ('6583473', 1),
       ('5860352', 2);

-- Insertar datos en la tabla "cuidado_animal"
INSERT INTO cuidado_animal (id_vet_ani, animal_id, empleado_num_seg_soc)
VALUES (100, 1, 1004),
       (200, 2, 1005);
