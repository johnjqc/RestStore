CREATE TABLE cliente (
	cliente_id varchar(36) not null,
	nombre varchar(255) not null,
	edad int4 not null,
	documento numeric(10,0) default 0 not null,
	correo varchar(255) not null,
	usuario varchar(255) not null,
	contraseña varchar(255) not null,
	PRIMARY KEY (cliente_id),
	UNIQUE (correo),
	UNIQUE (documento)
);

CREATE TABLE producto (
	producto_id varchar(36) not null,
	nombre varchar(255) not null,
	descripcion text not null,
	precio numeric(19,2) default 0 not null,
	codigo_barras text default 0 not null,
	PRIMARY KEY (producto_id)
);

CREATE TABLE tienda (
	tienda_id varchar(36) not null,
	nombre varchar(255) not null,
	horario varchar(50) not null,
	direccion varchar(255) not null,
	PRIMARY KEY (tienda_id)
);

CREATE TABLE inventario (
	inevntario_id varchar(36) not null default nextval('inventario_seq'),
	tienda_id varchar(36) not null,
	producto_id varchar(36) not null,
	existencia varchar(255) not null,
	PRIMARY KEY (inevntario_id),
	FOREIGN KEY (tienda_id) REFERENCES tienda(tienda_id) ON DELETE cascade,
	FOREIGN KEY (producto_id) REFERENCES producto(producto_id) ON DELETE cascade
);

CREATE SEQUENCE cliente_seq;
CREATE SEQUENCE producto_seq;
CREATE SEQUENCE tienda_seq;
CREATE SEQUENCE inventario_seq;

