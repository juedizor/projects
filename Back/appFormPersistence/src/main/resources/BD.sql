DROP TABLE IF EXISTS usuario_sede;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS empresa_sede;
DROP TABLE IF EXISTS empresa;
DROP TABLE IF EXISTS direccion;
DROP TABLE IF EXISTS telefono;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS tipo_documento;
DROP TABLE IF EXISTS ciudad;
DROP TABLE IF EXISTS departamento;
DROP TABLE IF EXISTS pais;


CREATE TABLE pais(
    id_pais integer auto_increment not null, 
    codigo_pais varchar(10) not null, 
    nombre_pais varchar(100) not null, 
    primary key(id_pais), 
    unique(codigo_pais)
);

CREATE TABLE departamento(
    id_departamento integer auto_increment not null, 
    codigo_departamento varchar(10) not null, 
    nombre_departamento varchar(100) not null, 
    id_pais integer not null, 
    primary key(id_departamento), 
    foreign key(id_pais) references pais(id_pais)
    on delete cascade
    on update cascade, 
    unique(codigo_departamento)
);

CREATE TABLE ciudad(
    id_ciudad integer auto_increment not null, 
    codigo_ciudad varchar(10) not null, 
    nombre_ciudad varchar(100) not null, 
    id_departamento integer not null, 
    primary key(id_ciudad), 
    foreign key(id_departamento) references departamento(id_departamento)
    on delete cascade
    on update cascade, 
    unique(codigo_ciudad)
);


CREATE TABLE perfil(
    id_perfil integer auto_increment not null, 
    nombre varchar (100) not null,
    acceso_web boolean not null,
    primary key(id_perfil)
);

CREATE TABLE tipo_documento(
    id_tipo_documento integer auto_increment not null, 
    codigo char(3) not null, 
    nombre varchar(50) not null, 
    primary key(id_tipo_documento)
);

CREATE TABLE persona(
    id_persona integer auto_increment not null, 
    id_tipo_documento integer not null,
    numero_documento decimal(16,0) not null, 
    nombre1 varchar(100) null, 
    nombre2 varchar(100) null, 
    apellido1 varchar(100) null, 
    apellido2 varchar(100) null, 
    email varchar(100) not null, 
    fecha_registro timestamp not null, 
    fecha_modificacion timestamp null, 
    id_ciudad integer not null,
    primary key(id_persona), 
    foreign key(id_tipo_documento) references tipo_documento (id_tipo_documento)
    on update cascade
    on delete cascade,
    foreign key(id_ciudad) references ciudad(id_ciudad)
    on delete cascade
    on update cascade,
    unique (id_tipo_documento, numero_documento)
);

CREATE TABLE telefono(
    id_telefono integer auto_increment not null, 
    numero_telefono varchar(100) not null, 
    fecha_registro timestamp not null,
    id_persona integer not null, 
    primary key(id_telefono), 
    foreign key(id_persona) references persona (id_persona)
    on delete cascade 
    on update cascade, 
    unique (id_persona, numero_telefono)
);

CREATE TABLE direccion(
    id_direccion integer auto_increment not null,
    nombre_direccion varchar(100) not null, 
    id_persona integer not null, 
    fecha_inicial timestamp not null, 
    fecha_final timestamp null,
    primary key(id_direccion), 
    foreign key(id_persona) references persona(id_persona)
    on delete cascade
    on update cascade
);


CREATE TABLE empresa(
    id_empresa integer auto_increment not null, 
    nombre_empresa varchar(100) null,
    descripcion_empresa varchar(500) not null,
    id_persona integer not null,
    primary key(id_empresa), 
    foreign key(id_persona) references persona(id_persona)
    on update cascade
    on delete cascade, 
    unique(nombre_empresa)
);

CREATE TABLE empresa_sede(
    id_empresa_sede integer auto_increment not null, 
    id_empresa_principal integer not null, 
    id_empresa integer not null, 
    primary key (id_empresa_sede),
    foreign key (id_empresa_principal) references empresa(id_empresa)
    on delete cascade 
    on update cascade, 
    foreign key (id_empresa) references empresa(id_empresa)
    on delete cascade
    on update cascade
);

CREATE TABLE usuario (
    id_usuario integer auto_increment not null, 
    nombre_usuario varchar(10) not null, 
    contrasena varchar(100) not null, 
    fecha_creacion timestamp not null, 
    activo boolean not null, 
    id_perfil integer null, 
    id_persona integer not null, 
    id_empresa integer null,
    primary key(id_usuario), 
    foreign key(id_perfil) references perfil(id_perfil)
    on update cascade
    on delete cascade, 
    foreign key(id_persona) references persona(id_persona)
    on update cascade
    on delete cascade, 
    foreign key(id_empresa) references empresa(id_empresa)
    on update cascade
    on delete cascade,
    unique (nombre_usuario)
);


CREATE TABLE cliente(
    id_cliente integer auto_increment not null,
    id_empresa integer not null, 
    id_persona integer not null, 
    primary key(id_cliente), 
    foreign key (id_empresa) references empresa(id_empresa)
    on delete cascade
    on update cascade, 
    foreign key (id_persona) references persona(id_persona)
    on delete cascade
    on update cascade
); 


CREATE TABLE usuario_sede(
    id_usuario_sede integer auto_increment not null, 
    id_usuario integer not null, 
    id_empresa_sede integer not null,
    primary key(id_usuario_sede), 
    foreign key(id_usuario) references usuario(id_usuario)
    on delete cascade
    on update cascade, 
    foreign key(id_empresa_sede) references empresa_sede(id_empresa_sede) 
    on delete cascade
    on update cascade
);



