CREATE TABLE casa (
    id_casa INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE habitacion (
    id_habitacion INT AUTO_INCREMENT PRIMARY KEY,
    id_casa INT,
    tipo VARCHAR(100),  -- Ej: 'Dormitorio', 'Sala', 'Cocina', etc.
    FOREIGN KEY (id_casa) REFERENCES casa(id_casa) ON DELETE CASCADE
);

CREATE TABLE dispositivo (
    id_dispositivo INT AUTO_INCREMENT PRIMARY KEY,
    id_habitacion INT,
    tipo VARCHAR(100),  -- Ej: 'Luz', 'Aire acondicionado', 'Cámara', etc.
    estado boolean, -- Ej: 'Encendido', 'Apagado'
    FOREIGN KEY (id_habitacion) REFERENCES habitacion(id_habitacion) ON DELETE CASCADE
);

INSERT INTO casa (nombre) VALUES ('Nro A001'); 
INSERT INTO casa (nombre) VALUES ('Nro A002');  
INSERT INTO casa (nombre) VALUES ('Nro A003'); 

INSERT INTO habitacion (id_casa, tipo) VALUES (1, 'Sala');  
INSERT INTO habitacion (id_casa, tipo) VALUES (1, 'Comedor');  
INSERT INTO habitacion (id_casa, tipo) VALUES (2, 'Sala');  
INSERT INTO habitacion (id_casa, tipo) VALUES (3, 'Alcoba principal'); 

INSERT INTO dispositivo (id_habitacion, tipo, estado) VALUES (1, 'Luz', true);
INSERT INTO dispositivo (id_habitacion, tipo, estado) VALUES (2, 'Luz', false);
INSERT INTO dispositivo (id_habitacion, tipo, estado) VALUES (3, 'Luz', true);
INSERT INTO dispositivo (id_habitacion, tipo, estado) VALUES (4, 'Luz', true);

-- 
SELECT c.nombre, h.tipo, d.estado FROM casa c 
inner join habitacion h on c.id_casa = h.id_casa 
inner join dispositivo d on h.id_habitacion = d.id_habitacion 
