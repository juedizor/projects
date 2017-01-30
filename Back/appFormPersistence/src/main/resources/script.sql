INSERT INTO `tipo_documento` (`id_tipo_documento`, `codigo`, `nombre`) 
VALUES ('1', 'CC', 'CEDULA DE CIUDADANIA'), 
('2', 'TI', 'TARJETA DE IDENTIDAD'), 
('3', 'NIT', 'NIT'), 
('4', 'CE', 'CEDULA DE EXTRANJERIA');

INSERT INTO `perfil` (`id_perfil`, `nombre`, `acceso_web`) 
VALUES ('1', 'ADMINISTRADOR', true), 
('2', 'GUARDA DE SEGURIDAD', false);

INSERT INTO `pais` (`id_pais`, `codigo_pais`, `nombre_pais`) 
VALUES ('1', '001', 'COLOMBIA'), 
('2', '002', 'VENEZUELA');

INSERT INTO `departamento` (`id_departamento`, `codigo_departamento`, `nombre_departamento`, `id_pais`) 
VALUES ('1', '001', 'CUNDINAMARCA', '1'), 
('2', '002', 'ANTIOQUIA', '1');

INSERT INTO `ciudad` (`id_ciudad`, `codigo_ciudad`, `nombre_ciudad`, `id_departamento`) 
VALUES ('1', '001', 'BOGOTA D.C', '1'), 
('2', '002', 'LA CALERA', '1');
INSERT INTO `ciudad` (`id_ciudad`, `codigo_ciudad`, `nombre_ciudad`, `id_departamento`) 
VALUES ('3', '003', 'MEDELLIN', '2'), 
('4', '004', 'ITAGUI', '2');

INSERT INTO `persona` (`id_persona`, `id_tipo_documento`, `numero_documento`, `nombre1`, `nombre2`, `apellido1`, `apellido2`, `email`, `fecha_registro`, `fecha_modificacion`) 
VALUES ('1', '1', '1064991582', 'JULIO', 'EDUARDO', 'IZQUIERDO', 'OROZCO', 'jeio_1990@hotmail.com', CURRENT_TIMESTAMP, NULL);
INSERT INTO `direccion` (`id_direccion`, `nombre_direccion`, `id_persona`, `fecha_inicial`, `fecha_final`) 
VALUES ('1', 'calle 45 #19-20', '1', CURRENT_TIMESTAMP, NULL);
INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`, `contrasena`, `fecha_creacion`, `activo`, `id_perfil`, `id_persona`) 
VALUES ('1', 'juedizor', 'julio16', CURRENT_TIMESTAMP, '1', '1', '1');
