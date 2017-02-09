INSERT INTO `tipo_documento` (`codigo_tipo_documento`, `descripcion_tipo_documento`, `codigo_corto`) 
VALUES ('001', 'CEDULA DE CIUDADANIA', 'CC'), 
('002', 'NIT', 'NIT');

INSERT INTO `perfil` (`codigo_perfil`, `nombre_perfil`) 
VALUES ('001', 'ADMNISTRADOR'), 
('002', 'SUPERVISOR DE AREA');

INSERT INTO `pais` (`codigo_pais`, `nombre_pais`) 
VALUES ('001', 'COLOMBIA');

INSERT INTO `departamento` (`codigo_departamento`, `codigo_pais`, `nombre_departamento`) 
VALUES ('001', '001', 'CUNDINAMARCA');

INSERT INTO `ciudad` (`codigo_ciudad`, `nombre_ciudad`, `codigo_departamento`)
VALUES ('001', 'BOGOTA', '001');

INSERT INTO `persona` (`codigo_tipo_documento`, `numero_documento`, `nombre1`, `nombre2`, `apellido1`, `apellido2`, `fecha_registro`, `fecha_modificacion`, `email`, `codigo_ciudad`) 
VALUES ('1', '1064991582', 'JULIO', NULL, 'IZQUIERDO', NULL, CURRENT_TIMESTAMP, NULL, 'jeio_1990@hotmail.com', '001');

INSERT INTO `direccion` (`codigo_direccion`, `nombre_direccion`, `codigo_tipo_documento`, `numero_documento`, `fecha_registro`) 
VALUES ('1', 'CALLE 45 #19-20', '1', '1064991582', CURRENT_TIMESTAMP);

INSERT INTO `usuario` (`id_usuario`, `codigo_perfil`, `codigo_tipo_documento`, `numero_documento`, `nombre_usuario`, `contrasena`, `fecha_creacion`, `activo`, `fecha_modificacion`) 
VALUES ('1', '001', '1', '1064991582', 'juedizor', 'julio16', CURRENT_TIMESTAMP, '1', NULL);

INSERT INTO `empresa` (`codigo_tipo_documento`, `numero_documento`, `nombre_empresa`, `descripcion_empresa`, `fecha_registro`, `fecha_modificacion`) 
VALUES ('1', '1064991582', 'TECH-INNOVA', 'EMPRESA DE TECNOLOGIA', CURRENT_TIMESTAMP, NULL);



