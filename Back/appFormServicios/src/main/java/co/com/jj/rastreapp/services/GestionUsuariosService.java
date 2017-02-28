/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.rastreapp.business.Respuestas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.jj.rastreapp.business.iface.GestionUsuariosIface;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import co.com.jj.rastreapp.excepcion.Message;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

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

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public Message registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws ExceptionGenerics {
        int resultado;
        try {
            if(usuarioDTO.getIdUsuario() == null){
                resultado = 0; //gestionUsuariosIface.registrar(usuarioDTO);
            }else{
                resultado = 0;// gestionUsuariosIface.actualizarUsuario(usuarioDTO);
            }
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }
        Message message;
        if (resultado == Respuestas.EXISTE_REGISTRO) {
            message = new Message("" + Respuestas.EXISTE_REGISTRO, "Usuario Existe");
            return message;
        } else {
            message = new Message("" + Respuestas.CREADO, "Usuario Creado");
            if (resultado == Respuestas.ACTUALIZADO) {
                message = new Message("" + Respuestas.CREADO, "Usuario Actualizado");
            }
            return message;
        }
    }

    @RequestMapping(value = "/usuarios/{nombreUsuario}", method = RequestMethod.GET)
    public List<UsuarioDTO> getUsuarios(@PathVariable(value = "nombreUsuario") String nombreUsuario) throws ExceptionGenerics {
        List<UsuarioDTO> listUsuarioDTO = null;
        try {
            listUsuarioDTO = gestionUsuariosIface.obtenerUsuarios(nombreUsuario);
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

    @RequestMapping(value = "/usuarios/usuario/{nombreUsuario}", method = RequestMethod.GET)
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
