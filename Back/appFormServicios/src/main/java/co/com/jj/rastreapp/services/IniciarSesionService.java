/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.rastreapp.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.jj.rastreapp.business.iface.GestionUsuariosIface;

/**
 *
 * @author jeio
 */
@RestController
@RequestMapping("/inicio")
public class IniciarSesionService {
    
    
    @Autowired
    GestionUsuariosIface aeUsuarioIface;
    
    
    @RequestMapping (value = "/usuario/{nombre}", method = RequestMethod.GET)
    public List<UsuarioDTO> verificarUsuario(@PathVariable("nombre") String nombre) throws Exception{
        List<UsuarioDTO> listAeUsuario = new ArrayList<>();
        if(nombre != null){
            if(!nombre.trim().isEmpty()){
                listAeUsuario = aeUsuarioIface.getUserActivo(nombre.trim());
            }
        }
        return listAeUsuario;
    }
    
}
