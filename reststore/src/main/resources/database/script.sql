CREATE TABLE client (
	client_id numeric(19) NOT NULL,
	client_name varchar(255) NOT NULL,
	age int4 NOT NULL,
	document numeric(10) NOT NULL DEFAULT 0,
	email varchar(255) NOT NULL,
	client_user varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	UNIQUE (document),
	UNIQUE (email),
	PRIMARY KEY (client_id)
);

CREATE TABLE product (
	product_id numeric(19) NOT NULL,
	product_name varchar(255) NOT NULL,
	description text NOT NULL,
	cost numeric(19,2) NOT NULL DEFAULT 0,
	barcode text NOT NULL DEFAULT 0,
	PRIMARY KEY (product_id)
);

CREATE TABLE shop (
	shop_id numeric(19) NOT NULL,
	shop_name varchar(255) NOT NULL,
	schedule varchar(50) NOT NULL,
	address varchar(255) NOT NULL,
	PRIMARY KEY (shop_id)
);

CREATE TABLE inventory (
	inventory_id numeric(19) NOT NULL DEFAULT nextval('inventory_seq'::regclass),
	shop_id numeric(19) NOT NULL,
	product_id numeric(19) NOT NULL,
	total varchar(255) NOT NULL,
	PRIMARY KEY (inventory_id),
	FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE,
	FOREIGN KEY (shop_id) REFERENCES shop(shop_id) ON DELETE CASCADE
);

CREATE SEQUENCE client_seq;
CREATE SEQUENCE product_seq;
CREATE SEQUENCE shop_seq;
CREATE SEQUENCE inventory_seq;

