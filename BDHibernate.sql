CREATE DATABASE bd_hibernate1;
use bd_hibernate1;

CREATE TABLE mascotas(
id_mascota int(11) NOT NULL ,
nombre varchar(45) NOT NULL,
raza varchar(45) default null,
color varchar (45) default null,
sexo varchar (45) default null,
primary key (id_mascota)
);

CREATE TABLE persona(
id_persona int(11) NOT NULL,
nombre_persona varchar(45) DEFAULT NULL,
profesion_persona varchar (45) DEFAULT NULL,
telefono_persona varchar (45) default null,
tipo_persona int (2) not null,
nacimiento_id int(11) not null,
primary key (id_persona)
);

CREATE TABLE nacimiento(
id_nacimiento int (11) NOT NULL auto_increment,
ciudad_nacimiento varchar (45) default null,
departamento_nacimiento varchar (45) default null,
fecha_nacimiento date default null,
pais_nacimiento varchar (45) default null,
primary key (id_nacimiento)
);

ALTER TABLE persona
ADD INDEX fk_persona_nacimiento (nacimiento_id ASC);
;
ALTER TABLE persona
ADD CONSTRAINT fk_persona_nacimiento
foreign key (nacimiento_id)
references nacimiento (id_nacimiento)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE bd_hibernate1.mascotas
ADD COLUMN persona_id int(11) null after sexo;

ALTER TABLE bd_hibernate1.mascotas
ADD INDEX fk_mascotas_idx (persona_id ASC);
;
ALTER TABLE bd_hibernate1.mascotas
ADD CONSTRAINT fk_mascotas_persona
FOREIGN KEY (persona_id)
REFERENCES bd_hibernate1.persona (id_persona)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

CREATE TABLE bd_hibernate1.productos(
id_Producto int (11) NOT NULL ,
nombre_producto varchar(45) NOT NULL,
precio_producto double default null,
PRIMARY KEY( id_producto)
);

CREATE TABLE bd_hibernate1.personas_productos(
persona_id int(11) NOT NULL,
producto_id int(11)NOT NULL,
KEY FK_producto(producto_id),
key fk_persona(persona_id),
CONSTRAINT FK_producto FOREIGN KEY (producto_id) REFERENCES productos (id_producto),
CONSTRAINT FK_persona FOREIGN KEY (persona_id) REFERENCES persona (id_persona)
);


