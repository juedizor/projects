/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.jj.rastreapp.business.iface.GestionUsuariosIface;
import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.dto.UsuarioDTO;

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
    public int registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        int resultado = gestionUsuariosIface.registrarUsuario(usuarioDTO);
        return resultado;
        
    }

    @RequestMapping(value = "/usuarios/{tipoDoc}/{numeroDoc}", method = RequestMethod.GET)
    public List<PersonaDTO> getPersona(@PathVariable(value = "tipoDoc") int tipoDoc,
            @PathVariable(value = "numeroDoc") long numeroDoc) throws Exception {
        return gestionUsuariosIface.getPersona(tipoDoc, numeroDoc);
    }

}
