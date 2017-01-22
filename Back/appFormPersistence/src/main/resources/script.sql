INSERT INTO `tipo_documento` (`id_tipo_documento`, `codigo`, `nombre`) 
VALUES ('1', 'CC', 'CEDULA DE CIUDADANIA'), 
('2', 'TI', 'TARJETA DE IDENTIDAD'), 
('3', 'NIT', 'NIT'), 
('4', 'CE', 'CEDULA DE EXTRANJERIA');

INSERT INTO `perfil` (`id_perfil`, `nombre`, `acceso_web`) 
VALUES ('1', 'ADMINISTRADOR', true), 
('2', 'GUARDA DE SEGURIDAD', false);

INSERT INTO `persona` (`id_persona`, `id_tipo_documento`, `numero_documento`, `nombre1`, `nombre2`, `apellido1`, `apellido2`, `email`, `fecha_registro`, `fecha_modificacion`) 
VALUES ('1', '1', '1064991582', 'JULIO', 'EDUARDO', 'IZQUIERDO', 'OROZCO', 'jeio_1990@hotmail.com', CURRENT_TIMESTAMP, NULL);
INSERT INTO `direccion` (`id_direccion`, `nombre_direccion`, `id_persona`, `fecha_inicial`, `fecha_final`) 
VALUES ('1', 'calle 45 #19-20', '1', CURRENT_TIMESTAMP, NULL);
INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`, `contrasena`, `fecha_creacion`, `activo`, `id_perfil`, `id_persona`) 
VALUES ('1', 'juedizor', 'julio16', CURRENT_TIMESTAMP, '1', '1', '1');
