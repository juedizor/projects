/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.rastreapp.business.Respuestas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.jj.rastreapp.business.iface.GestionUsuariosIface;
import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import co.com.jj.rastreapp.excepcion.Message;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author jeio
 */
@RestController
@RequestMapping("/gestionUsuarios")
@CrossOrigin("*")
public class GestionUsuariosService {

    @Autowired
    GestionUsuariosIface gestionUsuariosIface;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<UsuarioDTO> getUsuarios() throws ExceptionGenerics {
        List<UsuarioDTO> listUsuarioDTO = null;
        try {
            listUsuarioDTO = gestionUsuariosIface.obtenerUsuarios();
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }

        if (listUsuarioDTO != null && !listUsuarioDTO.isEmpty()) {
            return listUsuarioDTO;
        } else {
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No existen Usuarios");
            throw new ExceptionGenerics();
        }
    }

    @RequestMapping(value = "/usuarios/{nombreUsuario}", method = RequestMethod.GET)
    public UsuarioDTO getUsuario(@PathVariable(value = "nombreUsuario") String nombreUsuario) throws ExceptionGenerics {
        UsuarioDTO usuarioDTO = null;
        try {
            usuarioDTO = gestionUsuariosIface.getUser(nombreUsuario);
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }

        if (usuarioDTO == null) {
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No existe el usuario");
            throw new ExceptionGenerics();
        }

        return usuarioDTO;
    }

    

}
