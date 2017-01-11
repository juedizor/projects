
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS tipo_documento;

CREATE TABLE perfil(
    id_perfil integer auto_increment not null, 
    nombre varchar (100) not null, 
    primary key(id_perfil)
);


CREATE TABLE tipo_documento(
    id_tipo_documento integer auto_increment not null, 
    codigo char(2) not null, 
    nombre varchar(50) not null, 
    primary key(id_tipo_documento)
);

CREATE TABLE persona(
    id_persona integer auto_increment not null, 
    id_tipo_documento integer not null,
    numero_documento decimal(16,0) not null, 
    nombre1 varchar(100) not null, 
    nombre2 varchar(100) not null, 
    apellido1 varchar(100) not null, 
    apellido2 varchar(100) not null, 
    email varchar(100) not null, 
    fecha_registro timestamp not null, 
    fecha_modificacion timestamp not null, 
    primary key(id_persona), 
    foreign key(id_tipo_documento) references tipo_documento (id_tipo_documento)
    on update cascade
    on delete cascade, 
    unique (id_tipo_documento, numero_documento)
);

CREATE TABLE usuario (
    id_usuario integer auto_increment not null, 
    nombre_usuario varchar(10) not null, 
    contrasena varchar(100) not null, 
    fecha_creacion timestamp not null, 
    activo boolean not null, 
    id_perfil integer not null, 
    id_persona integer not null, 
    primary key(id_usuario), 
    foreign key(id_perfil) references perfil(id_perfil)
    on update cascade
    on delete cascade, 
    foreign key(id_persona) references persona(id_persona)
    on update cascade
    on delete cascade, 
    unique (nombre_usuario)
);