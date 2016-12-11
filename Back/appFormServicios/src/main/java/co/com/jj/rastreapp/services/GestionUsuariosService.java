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
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import co.com.jj.rastreapp.excepcion.Message;

/**
 *
 * @author jeio
 */
@RestController
@RequestMapping("/gestionUsuarios")
public class GestionUsuariosService {

    @Autowired
    GestionUsuariosIface gestionUsuariosIface;

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public Message registrarUsuario(@RequestBody PersonaDTO personaDTO) throws ExceptionGenerics {
        int resultado;
        try {
            resultado = gestionUsuariosIface.registrarUsuario(personaDTO);
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
            return message;
        }
    }

    @RequestMapping(value = "/usuarios/{tipoDoc}/{numeroDoc}", method = RequestMethod.GET)
    public PersonaDTO getPersona(@PathVariable(value = "tipoDoc") int tipoDoc,
            @PathVariable(value = "numeroDoc") long numeroDoc) throws ExceptionGenerics {
        PersonaDTO personaDTO = null;
        try {
            personaDTO = gestionUsuariosIface.getPersona(tipoDoc, numeroDoc);
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }
        if (personaDTO == null) {
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No existe Persona");
            throw new ExceptionGenerics();
        }

        return personaDTO;
    }

}
