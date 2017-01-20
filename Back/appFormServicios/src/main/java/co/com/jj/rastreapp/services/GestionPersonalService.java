/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.business.iface.GestionPersonalIface;
import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import co.com.jj.rastreapp.excepcion.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jeio
 */
@RestController
@RequestMapping("/gestionPersonal")
@CrossOrigin("*")
public class GestionPersonalService {
    
    @Autowired
    GestionPersonalIface gestionPersonalIface;
    
    @RequestMapping(value = "/personas", method = RequestMethod.POST)
    public Message registrarPersona(@RequestBody PersonaDTO personaDTO) throws ExceptionGenerics {
        int resultado;
        try {
            resultado = gestionPersonalIface.registrarPersona(personaDTO);
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
    
    @RequestMapping(value = "/personas/{tipoDoc}/{numeroDoc}", method = RequestMethod.GET)
    public PersonaDTO getPersona(@PathVariable(value = "tipoDoc") int tipoDoc,
            @PathVariable(value = "numeroDoc") long numeroDoc) throws ExceptionGenerics {
        PersonaDTO personaDTO = null;
        try {
            personaDTO = gestionPersonalIface.getPersona(tipoDoc, numeroDoc);
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
    
    @RequestMapping(value = "/personas/{email:.+}", method = RequestMethod.GET)
    public PersonaDTO getPersona(@PathVariable(value = "email") String email) throws ExceptionGenerics {
        PersonaDTO personaDTO = null;
        try {
            personaDTO = gestionPersonalIface.getPersona(email);
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }

        if (personaDTO == null) {
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No existe el Email");
            throw new ExceptionGenerics();
        }

        return personaDTO;
    }
    
}
