/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.entity.Usuario;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.jj.rastreapp.business.iface.GestionUsuariosIface;
import co.com.jj.rastreapp.dto.PersonaDTO;

/**
 *
 * @author jeio
 */
@Service
public class GestionUsuariosImpl implements GestionUsuariosIface {

    @Autowired
    UsuarioIfaceDAO usuarioIfaceDAO;
    @Autowired
    PersonaIfaceDAO personaIfaceDAO;

    @Override
    public List<UsuarioDTO> getUserActivo(String nombreUsuario) throws Exception {
        List<Usuario> listUsuarios = usuarioIfaceDAO.findByNombreUsuarioActivo(nombreUsuario, true);
        List<UsuarioDTO> listAeUsuarioDTO = new ArrayList<>();
        if (listUsuarios != null && !listUsuarios.isEmpty()) {
            UsuarioDTO aeUsuarioDTO;
            for (Usuario usuario : listUsuarios) {
                aeUsuarioDTO = new UsuarioDTO(usuario.getIdPersona().getNombre1(),
                        usuario.getIdPersona().getNombre2(),
                        usuario.getIdPersona().getApellido1(),
                        usuario.getIdPersona().getApellido2(),
                        usuario.getIdPersona().getEmail(),
                        usuario.getIdPersona().getIdTipoDocumento().getIdTipoDocumento(),
                        usuario.getIdPersona().getNumeroDocumento(),
                        usuario.getNombreUsuario());
                listAeUsuarioDTO.add(aeUsuarioDTO);
            }
        }

        return listAeUsuarioDTO;
    }

    @Override
    //@Transactional
    public int registrarUsuario(UsuarioDTO usuarioDTO) {
//        int resultado = Respuestas.SIN_DATOS;
//        if (usuarioDTO != null) {
//            try {
//                // tiene que validar si el usuario ya existe 
//                UsuarioDTO aeUsuarioDTO = getUser(Usuario.getNombreUsuario());
//                if (aeUsuarioDTO != null) {
//                    resultado = Respuestas.EXISTE_REGISTRO;
//                } else {
//                    aeUsuarioIfaceDAO.save(Usuario);
//                    resultado = Respuestas.CREADO;
//                }
//
//            } catch (Exception e) {
//                resultado = Respuestas.ERROR;
//            }
//        }
//
//        return resultado;
        return 0;
    }

    @Override
    public List<PersonaDTO> getPersona(int tipoDoc, long numeroDoc) {
        return null;
    }

    @Override
    public UsuarioDTO getUser(String nombreUsuario) throws Exception {
        Usuario usuario = usuarioIfaceDAO.findByNombreUsuario(nombreUsuario);
        UsuarioDTO aeUsuarioDTO = null;
        if (usuario != null) {
            aeUsuarioDTO = new UsuarioDTO(usuario.getIdPersona().getNombre1(),
                    usuario.getIdPersona().getNombre2(),
                    usuario.getIdPersona().getApellido1(),
                    usuario.getIdPersona().getApellido2(),
                    usuario.getIdPersona().getEmail(),
                    usuario.getIdPersona().getIdTipoDocumento().getIdTipoDocumento(),
                    usuario.getIdPersona().getNumeroDocumento(),
                    usuario.getNombreUsuario());
        }
        return aeUsuarioDTO;
    }

}
