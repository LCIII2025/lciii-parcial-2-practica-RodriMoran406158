-- DISTRITOS
INSERT INTO distrito (id, name) VALUES (1, 'Ciudad Autónoma de Buenos Aires');
INSERT INTO distrito (id, name) VALUES (2, 'Buenos Aires');
INSERT INTO distrito (id, name) VALUES (3, 'Catamarca');
INSERT INTO distrito (id, name) VALUES (4, 'Córdoba');

--CARGOS
INSERT INTO cargo (id, nombre) VALUES (1, 'PRESIDENTE Y VICE');
INSERT INTO cargo (id, nombre) VALUES (3, 'DIPUTADO NACIONAL');
INSERT INTO cargo (id, nombre) VALUES (8, 'PARLAMENTO MERCOSUR NACIONAL');
INSERT INTO cargo (id, nombre) VALUES (9, 'PARLAMENTO MERCOSUR REGIONAL');

-- RELACIÓN DISTRITO-CARGO
INSERT INTO distrito_cargo (distrito_id, cargo_id) VALUES (4, 1);
INSERT INTO distrito_cargo (distrito_id, cargo_id) VALUES (4, 3);
INSERT INTO distrito_cargo (distrito_id, cargo_id) VALUES (4, 8);
INSERT INTO distrito_cargo (distrito_id, cargo_id) VALUES (4, 9);

-- SECCIONES
INSERT INTO seccion_entity (id, nombre, distrito_id) VALUES (1, 'Capital', 4);
INSERT INTO seccion_entity (id, nombre, distrito_id) VALUES (2, 'Calamuchita', 4);
INSERT INTO seccion_entity (id, nombre, distrito_id) VALUES (3, 'Colón', 4);
INSERT INTO seccion_entity (id, nombre, distrito_id) VALUES (26, 'Unión', 4);