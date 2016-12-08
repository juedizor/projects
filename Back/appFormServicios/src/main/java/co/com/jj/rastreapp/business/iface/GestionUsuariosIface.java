/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.iface;

import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author jeio
 */
public interface GestionUsuariosIface {
    
    public List<UsuarioDTO> getUserActivo(String nombreUsuario) throws Exception;
    public UsuarioDTO getUser(String nombreUsuario) throws Exception;
    public int registrarUsuario(UsuarioDTO usuarioDTO) throws Exception;
    public List<PersonaDTO> getPersona(int tipoDoc, long numeroDoc) throws Exception;
    
}