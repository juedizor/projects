DROP TABLE IF EXISTS telefono_sede;
DROP TABLE IF EXISTS direccion_sede;
DROP TABLE IF EXISTS sede_empresa;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS empresa;
DROP TABLE IF EXISTS telefono;
DROP TABLE IF EXISTS direccion;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS ciudad;
DROP TABLE IF EXISTS departamento;
DROP TABLE IF EXISTS pais;
DROP TABLE IF EXISTS tipo_documento;
DROP TABLE IF EXISTS tipo_sede;

CREATE TABLE tipo_sede
(
	codigo_tipo_sede VARCHAR(50) NOT NULL,
	nombre_tipo_sede VARCHAR(50) NOT NULL,
	PRIMARY KEY (codigo_tipo_sede)
) 
;

CREATE TABLE tipo_documento
(
	codigo_tipo_documento INTEGER NOT NULL,
	descripcion_tipo_documento VARCHAR(50) NOT NULL,
	codigo_corto CHAR(3) NOT NULL,
	PRIMARY KEY (codigo_tipo_documento)
) 
;

CREATE TABLE pais
(
	codigo_pais VARCHAR(50) NOT NULL,
	nombre_pais VARCHAR(50) NOT NULL,
	PRIMARY KEY (codigo_pais)
) 
;


CREATE TABLE departamento
(
	codigo_departamento VARCHAR(50) NOT NULL,
	codigo_pais VARCHAR(50) NOT NULL,
	nombre_departamento VARCHAR(50) NOT NULL,
	PRIMARY KEY (codigo_departamento),
	KEY (codigo_pais)
) 
;


ALTER TABLE departamento ADD CONSTRAINT FK_departamento_pais 
	FOREIGN KEY (codigo_pais) REFERENCES pais (codigo_pais)
	ON DELETE CASCADE ON UPDATE CASCADE
;

CREATE TABLE ciudad
(
	codigo_ciudad VARCHAR(50) NOT NULL,
	nombre_ciudad VARCHAR(50) NOT NULL,
	codigo_departamento VARCHAR(50) NOT NULL,
	PRIMARY KEY (codigo_ciudad),
	KEY (codigo_departamento)
) 
;


ALTER TABLE ciudad ADD CONSTRAINT FK_ciudad_departamento 
	FOREIGN KEY (codigo_departamento) REFERENCES departamento (codigo_departamento)
	ON DELETE CASCADE ON UPDATE CASCADE
;


CREATE TABLE persona
(
	codigo_tipo_documento INTEGER NOT NULL,
	numero_documento BIGINT NOT NULL,
	nombre1 VARCHAR(50) NULL,
	nombre2 VARCHAR(50) NULL,
	apellido1 VARCHAR(50) NULL,
	apellido2 VARCHAR(50) NULL ,
	fecha_registro TIMESTAMP NOT NULL,
	fecha_modificacion TIMESTAMP NULL,
	email VARCHAR(50) NOT NULL,
	codigo_ciudad VARCHAR(50) NOT NULL,
	PRIMARY KEY (codigo_tipo_documento, numero_documento),
	KEY (codigo_ciudad),
	KEY (codigo_tipo_documento)
) 
;


ALTER TABLE persona ADD CONSTRAINT FK_persona_ciudad 
	FOREIGN KEY (codigo_ciudad) REFERENCES ciudad (codigo_ciudad)
	ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE persona ADD CONSTRAINT FK_persona_tipo_documento 
	FOREIGN KEY (codigo_tipo_documento) REFERENCES tipo_documento (codigo_tipo_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;

CREATE TABLE direccion
(
	codigo_direccion INTEGER NOT NULL AUTO_INCREMENT,
	nombre_direccion VARCHAR(50) NOT NULL,
	codigo_tipo_documento INTEGER NOT NULL,
	numero_documento BIGINT NOT NULL,
	fecha_registro TIMESTAMP NOT NULL,
	PRIMARY KEY (codigo_direccion),
	KEY (codigo_tipo_documento, numero_documento)
) 
;


ALTER TABLE direccion ADD CONSTRAINT FK_direccion_persona 
	FOREIGN KEY (codigo_tipo_documento, numero_documento) REFERENCES persona (codigo_tipo_documento, numero_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;

CREATE TABLE telefono
(
	id_telefono INTEGER NOT NULL AUTO_INCREMENT,
	numero_telefono VARCHAR(50) NOT NULL,
	codigo_tipo_documento INTEGER NOT NULL,
	numero_documento BIGINT NOT NULL,
	fecha_registro TIMESTAMP NOT NULL,
	PRIMARY KEY (id_telefono),
	KEY (codigo_tipo_documento, numero_documento)
) 
;


ALTER TABLE telefono ADD CONSTRAINT FK_telefono_persona 
	FOREIGN KEY (codigo_tipo_documento, numero_documento) REFERENCES persona (codigo_tipo_documento, numero_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;






CREATE TABLE empresa
(
	codigo_tipo_documento INTEGER NOT NULL,
	numero_documento BIGINT NOT NULL,
	nombre_empresa VARCHAR(50) NOT NULL,
	descripcion_empresa VARCHAR(50) NOT NULL,
	fecha_registro TIMESTAMP NOT NULL,
	fecha_modificacion TIMESTAMP NULL,
	PRIMARY KEY (codigo_tipo_documento, numero_documento),
	KEY (codigo_tipo_documento, numero_documento)
) 
;


ALTER TABLE empresa ADD CONSTRAINT FK_empresa_persona 
	FOREIGN KEY (codigo_tipo_documento, numero_documento) REFERENCES persona (codigo_tipo_documento, numero_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;

CREATE TABLE perfil
(
	codigo_perfil VARCHAR(50) NOT NULL,
	nombre_perfil VARCHAR(50) NOT NULL,
	codigo_tipo_documento INTEGER NOT NULL,
	numero_documento BIGINT NOT NULL,
	PRIMARY KEY (codigo_perfil),
	KEY (codigo_tipo_documento, numero_documento)
) 
;


ALTER TABLE perfil ADD CONSTRAINT FK_perfil_empresa 
	FOREIGN KEY (codigo_tipo_documento, numero_documento) REFERENCES empresa (codigo_tipo_documento, numero_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;

CREATE TABLE usuario
(
	id_usuario INTEGER NOT NULL AUTO_INCREMENT,
	codigo_perfil VARCHAR(50) NOT NULL,
	codigo_tipo_documento INTEGER NOT NULL,
	numero_documento BIGINT NOT NULL,
	nombre_usuario VARCHAR(50) NOT NULL,
	contrasena VARCHAR(50) NOT NULL,
	fecha_creacion TIMESTAMP NOT NULL,
	activo BOOL NOT NULL,
	fecha_modificacion TIMESTAMP NULL,
	PRIMARY KEY (id_usuario),
	KEY (codigo_perfil),
	KEY (codigo_tipo_documento, numero_documento)
) 
;


ALTER TABLE usuario ADD CONSTRAINT FK_usuario_perfil 
	FOREIGN KEY (codigo_perfil) REFERENCES perfil (codigo_perfil)
	ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE usuario ADD CONSTRAINT FK_usuario_persona 
	FOREIGN KEY (codigo_tipo_documento, numero_documento) REFERENCES persona (codigo_tipo_documento, numero_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;

CREATE TABLE cliente
(
	codigo_tipo_documento_cliente INTEGER NOT NULL,
	numero_documento_cliente BIGINT NOT NULL,
	codigo_tipo_documento INTEGER NOT NULL,
	numero_documento BIGINT NOT NULL,
	PRIMARY KEY (codigo_tipo_documento_cliente, numero_documento_cliente),
	KEY (codigo_tipo_documento_cliente, numero_documento_cliente),
	KEY (codigo_tipo_documento, numero_documento)
) 
;


ALTER TABLE cliente ADD CONSTRAINT FK_cliente_empresa_01 
	FOREIGN KEY (codigo_tipo_documento_cliente, numero_documento_cliente) REFERENCES empresa (codigo_tipo_documento, numero_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE cliente ADD CONSTRAINT FK_cliente_empresa_02 
	FOREIGN KEY (codigo_tipo_documento, numero_documento) REFERENCES empresa (codigo_tipo_documento, numero_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;



ALTER TABLE cliente ADD CONSTRAINT FK_cliente_empresa 
	FOREIGN KEY (codigo_tipo_documento, numero_documento) REFERENCES empresa (codigo_tipo_documento, numero_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;

CREATE TABLE sede_empresa
(
	codigo_sede VARCHAR(50) NOT NULL,
	codigo_tipo_documento INTEGER NOT NULL,
	numero_documento BIGINT NOT NULL,
	nombre_sede VARCHAR(50) NOT NULL,
	codigo_tipo_sede VARCHAR(50) NOT NULL,
	fecha_registro TIMESTAMP NOT NULL,
	fecha_modificacion TIMESTAMP NULL,
	PRIMARY KEY (codigo_sede),
	KEY (codigo_tipo_documento, numero_documento),
	KEY (codigo_tipo_sede)
) 
;


ALTER TABLE sede_empresa ADD CONSTRAINT FK_sede_empresa_empresa 
	FOREIGN KEY (codigo_tipo_documento, numero_documento) REFERENCES empresa (codigo_tipo_documento, numero_documento)
	ON DELETE CASCADE ON UPDATE CASCADE
;

ALTER TABLE sede_empresa ADD CONSTRAINT FK_sede_empresa_tipo_sede 
	FOREIGN KEY (codigo_tipo_sede) REFERENCES tipo_sede (codigo_tipo_sede)
	ON DELETE CASCADE ON UPDATE CASCADE
;


CREATE TABLE direccion_sede
(
	id_direccion_sede INTEGER NOT NULL AUTO_INCREMENT,
	codigo_sede VARCHAR(50) NOT NULL,
	nombre_direccion_sede VARCHAR(50) NOT NULL,
	fecha_registro TIMESTAMP NOT NULL,
	fecha_modificacion TIMESTAMP NULL,
	PRIMARY KEY (id_direccion_sede),
	KEY (codigo_sede)
) 
;


ALTER TABLE direccion_sede ADD CONSTRAINT FK_direccion_sede_sede_empresa 
	FOREIGN KEY (codigo_sede) REFERENCES sede_empresa (codigo_sede)
	ON DELETE CASCADE ON UPDATE CASCADE
;

CREATE TABLE telefono_sede
(
	id_telefono_sede INTEGER NOT NULL AUTO_INCREMENT,
	codigo_sede VARCHAR(50) NOT NULL,
	numero_telefeno VARCHAR(50) NOT NULL,
	fecha_registro TIMESTAMP NOT NULL,
	PRIMARY KEY (id_telefono_sede),
	KEY (codigo_sede)
) 
;


ALTER TABLE telefono_sede ADD CONSTRAINT FK_telefono_sede_sede_empresa 
	FOREIGN KEY (codigo_sede) REFERENCES sede_empresa (codigo_sede)
	ON DELETE CASCADE ON UPDATE CASCADE
;











