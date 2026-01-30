
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

create table dutrilla_gestion.usuario(
	ID VARCHAR (32) primary key,
	NOMBRE VARCHAR (30) not null,
	PRIMERAPELLIDO VARCHAR (30) not null,
	SEGUNDOAPELLIDO VARCHAR (30) not null,
	NOMBRECOMPLETO VARCHAR (50),
	DNI VARCHAR (9) not null,
	EJERCICIONACIMIENTO INT not null,
	ALIAS VARCHAR (30),
	TELEFONO VARCHAR (9) not null,
	EMAIL VARCHAR (60) not null
);

create table dutrilla_gestion.gasto(
	ID VARCHAR (32) primary key,
	EJERCICIO numeric (4, 0),
	FECHA DATE not null,
	MES VARCHAR(10),
	IDUSUARIO VARCHAR (32) not null,
	SECCIONGASTO VARCHAR (30) not null,
	TIPOCOMERCIO VARCHAR (20) not null,
	IMPORTECOMPRA NUMERIC(8, 2) not null,
	IDESTABLECIMIENTO VARCHAR (32) references dutrilla_gestion.establecimiento (ID) not null,
	NOMBREESTABLECIMIENTO VARCHAR(20),
	IDCIUDAD VARCHAR (32) references dutrilla_gestion.ciudad (ID) not null,
	NOMBRECIUDAD VARCHAR(20),
	DESCRIPCION VARCHAR (100)
);


create table dutrilla_gestion.userpassword(
	ID VARCHAR (32) primary key,
	USUARIO VARCHAR (30) not null unique,
	PASSWORD VARCHAR (100) not null
);


create table dutrilla_gestion.establecimiento(
	ID VARCHAR (32) primary key,
	CODIGO numeric (2,0) not null,
	DESCRIPCION VARCHAR (30),
	UNIQUE(DESCRIPCION)
);

CREATE TABLE dutrilla_gestion.resumenmensualtotal (
	id varchar(32) NOT NULL,
	ejercicio numeric(4) NULL,
	mes varchar(10) NULL,
	fechacalculo date NOT NULL,
	importetotal numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importetotalepescaderia numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importetotalencarniceria numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importetotalencomprasgenericas numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importetotalenalimentacion numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importetotalenropa numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importetotalencalzado numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importehipoteca numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importeluz numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importeseguros numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importecomunidad numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importefijoscasa numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importetotalenextraescolares numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importetotalenocio numeric(8, 2) DEFAULT 0.00 NOT NULL,
	gastomercadona numeric(8, 2) DEFAULT 0.00 NOT NULL,
	gastolidl numeric(8, 2) DEFAULT 0.00 NOT NULL,
	gastoaldi numeric(8, 2) DEFAULT 0.00 NOT NULL,
	gastoalcampo numeric(8, 2) DEFAULT 0.00 NOT NULL,
	gastoalvimar numeric(8, 2) DEFAULT 0.00 NOT NULL,
	gastohnossanchez numeric(8, 2) DEFAULT 0.00 NOT NULL,
	importetotalenpescaderia numeric(19, 2) NULL,
	importesfijoscasa numeric(19, 2) NULL,
	mesenum int4 NULL,
	importesfarmacia numeric(19, 2) NULL,
	importetotalenfarmacia numeric(19, 2) NULL,
	CONSTRAINT resumenmensualtotal_pkey PRIMARY KEY (id)
);


CREATE OR REPLACE FUNCTION generar_id_aleatorio() RETURNS TEXT AS $$
BEGIN
    RETURN substr(md5(random()::text), 1, 32);
END;
$$ LANGUAGE plpgsql;
