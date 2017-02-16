/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.jj.rastreapp.business.iface.GestionUsuariosIface;
import co.com.jj.rastreapp.dto.InicioSesionDTO;
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author jeio
 */
@RestController
@RequestMapping("/inicio")
@CrossOrigin("*")
public class IniciarSesionService {

    @Autowired
    GestionUsuariosIface gestionUsuariosIface;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public UsuarioDTO verificarUsuario(@RequestBody InicioSesionDTO inicioSesionDTO) throws ExceptionGenerics {
        UsuarioDTO usuarioDTO = null;
        if (inicioSesionDTO.getContrasena() != null && inicioSesionDTO.getContrasena() != null) {
            if (!inicioSesionDTO.getUsuario().trim().isEmpty() && !inicioSesionDTO.getContrasena().trim().isEmpty()) {
                try {
                    gestionUsuariosIface.getUserActivo(inicioSesionDTO.getUsuario().trim(), 
                            inicioSesionDTO.getContrasena().trim());
                } catch (Exception e) {
                    ExceptionGenerics.setCodigo(Respuestas.ERROR);
                    ExceptionGenerics.setDescripcion(e.getMessage());
                    throw new ExceptionGenerics();
                }
            }
        }
        return usuarioDTO;
    }

}
