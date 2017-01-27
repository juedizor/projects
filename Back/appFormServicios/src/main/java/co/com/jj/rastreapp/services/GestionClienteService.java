/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.appform.persistence.iface.ClienteIfaceDAO;
import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.business.iface.GestionClientesIface;
import co.com.jj.rastreapp.dto.ClienteDTO;
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import co.com.jj.rastreapp.excepcion.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jeio
 */
@RestController
@RequestMapping("/gestionClientes")
@CrossOrigin("*")
public class GestionClienteService {
    
    @Autowired
    GestionClientesIface gestionClientesIface;
    
    
    public Message registrarCliente(@RequestBody ClienteDTO clienteDTO) throws ExceptionGenerics{
        int resultado;
        try {
            resultado = gestionClientesIface.registrarCliente(clienteDTO);
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();

        }
        
        Message message;
        if (resultado == Respuestas.EXISTE_REGISTRO) {
            message = new Message("" + Respuestas.EXISTE_REGISTRO, "Cliente Existe");
            return message;
        } else {
            message = new Message("" + Respuestas.CREADO, "Cliente Creado");
            if (resultado == Respuestas.ACTUALIZADO) {
                message = new Message("" + Respuestas.CREADO, "Cliente Actualizado");
            }
            return message;
        }
    }

}
