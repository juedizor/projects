/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.business.iface.GestionClientesIface;
import co.com.jj.rastreapp.dto.ClienteDTO;
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import co.com.jj.rastreapp.excepcion.Message;
import java.util.List;
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
@RequestMapping("/gestionClientes")
@CrossOrigin("*")
public class GestionClienteService {

    @Autowired
    GestionClientesIface gestionClientesIface;

    @RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public Message registrarCliente(@RequestBody ClienteDTO clienteDTO) throws ExceptionGenerics {
        int resultado;
        try {
            if(clienteDTO.getIdCliente() != null){
                resultado = 0;
            }else{
                resultado = gestionClientesIface.registrarCliente(clienteDTO);
            }
            
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

    @RequestMapping(value = "/clientes/{idEmpresa}", method = RequestMethod.GET)
    public List<ClienteDTO> getClientes(@PathVariable(value = "idEmpresa") int idEmpresa) throws ExceptionGenerics {
        List<ClienteDTO> listClienteDTO;
        try {
            listClienteDTO = gestionClientesIface.buscarClientesPorEmpresa(idEmpresa);
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }

        if (listClienteDTO != null && !listClienteDTO.isEmpty()) {
            return listClienteDTO;
        } else {
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No hay datos de clientes");
            throw new ExceptionGenerics();
        }

    }

}
