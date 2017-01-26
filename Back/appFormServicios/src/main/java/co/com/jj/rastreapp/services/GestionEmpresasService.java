/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.appform.persistence.iface.EmpresaIfaceDAO;
import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.business.iface.GestionEmpresasIface;
import co.com.jj.rastreapp.dto.EmpresaDTO;
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import co.com.jj.rastreapp.excepcion.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julio.izquierdo
 */
@RestController
@RequestMapping("/gestionEmpresas")
@CrossOrigin("*")
public class GestionEmpresasService {

    @Autowired
    GestionEmpresasIface gestionEmpresasIface;

    @RequestMapping(value = "/empresas", method = RequestMethod.POST)
    public Message registrarEmpresa(@RequestBody EmpresaDTO empresaDTO) throws ExceptionGenerics{
        int resultado;
        try {
            resultado = gestionEmpresasIface.registrarEmpresa(empresaDTO);
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

}
