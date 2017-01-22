/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.PersistenceApp;
import co.com.jj.appform.entity.Perfil;
import co.com.jj.appform.entity.Persona;
import co.com.jj.appform.entity.TipoDocumento;
import co.com.jj.appform.entity.Usuario;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.jj.rastreapp.business.iface.GestionUsuariosIface;
import co.com.jj.rastreapp.dto.DireccionDTO;
import co.com.jj.rastreapp.dto.PerfilDTO;
import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import co.com.jj.rastreapp.util.DateUtils;
import co.com.jj.rastreapp.util.EntityUtils;
import java.util.ArrayList;

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
    @Autowired
    TipoDocumentoIfaceDAO tipoDocumentoIfaceDAO;
    @Autowired
    PerfilIfaceDAO perfilIfaceDAO;

    private static final DateUtils DATE_UTILS = DateUtils.getInstance();
    private static final EntityUtils ENTITY_UTILS = EntityUtils.getInstance();
    private PersistenceApp persistenceApp;

    @Override
    public UsuarioDTO getUserActivo(String nombreUsuario, String contrasena) throws Exception {
        persistenceApp = new PersistenceApp();
        usuarioIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
        List<Usuario> listUsuarios = usuarioIfaceDAO.findByNombreUsuarioContrasena(nombreUsuario, contrasena);
        if (listUsuarios != null && !listUsuarios.isEmpty()) {
            Usuario usuario = listUsuarios.get(0);
            if (!usuario.getIdPerfil().getAccesoWeb()) {
                throw new Exception("Usuario no tiene acceso a la plataforma");
            }

            if (!usuario.getActivo()) {
                throw new Exception("usuario/contraseña incorrectos");
            }
            UsuarioDTO usuarioDTO = ENTITY_UTILS.getUsuarioDTO(listUsuarios.get(0));
            PerfilDTO perfilDTO = ENTITY_UTILS.getPerfilDTO(listUsuarios.get(0).getIdPerfil());
            usuarioDTO.setPerfil(perfilDTO);
            PersonaDTO personaDTO = ENTITY_UTILS.getPersonaDTO(listUsuarios.get(0).getIdPersona());
            usuarioDTO.setPersona(personaDTO);
            TipoDocumentoDTO tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(listUsuarios.get(0).getIdPersona().getIdTipoDocumento());
            personaDTO.setTipoDocumento(tipoDocumentoDTO);
            return usuarioDTO;
        }else{
            throw new Exception("usuario/contraseña incorrectos");
        }
    }

    @Override
    public UsuarioDTO getUser(String nombreUsuario) throws Exception {
        persistenceApp = new PersistenceApp();
        usuarioIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
        Usuario usuario = usuarioIfaceDAO.findByNombreUsuario(nombreUsuario);
        UsuarioDTO usuarioDTO = null;
        if (usuario != null) {
            usuarioDTO = ENTITY_UTILS.getUsuarioDTO(usuario);
        }
        return usuarioDTO;
    }

    @Override
    public List<UsuarioDTO> obtenerUsuarios(String nombreUsuario) throws Exception {
        persistenceApp = new PersistenceApp();
        usuarioIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
        List<Usuario> listUsuarios = usuarioIfaceDAO.findAll();
        UsuarioDTO usuarioDTO;
        PersonaDTO personaDTO;
        PerfilDTO perfilDTO;
        TipoDocumentoDTO tipoDocumentoDTO;
        DireccionDTO direccionDTO;
        List<UsuarioDTO> listUsuarioDTO = new ArrayList<>();
        if (listUsuarios != null && !listUsuarios.isEmpty()) {
            eliminarUserList(nombreUsuario, listUsuarios);
            for (Usuario usuario : listUsuarios) {
                usuarioDTO = ENTITY_UTILS.getUsuarioDTO(usuario);
                usuarioDTO.setContrasena("");
                personaDTO = ENTITY_UTILS.getPersonaDTO(usuario.getIdPersona());
                direccionDTO = ENTITY_UTILS.getDireccionDTO(usuario.getIdPersona().getDireccionList().get(usuario.getIdPersona().getDireccionList().size() - 1));
                tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(usuario.getIdPersona().getIdTipoDocumento());
                personaDTO.setTipoDocumento(tipoDocumentoDTO);
                personaDTO.setDireccion(direccionDTO);
                usuarioDTO.setPersona(personaDTO);
                perfilDTO = ENTITY_UTILS.getPerfilDTO(usuario.getIdPerfil());
                usuarioDTO.setPerfil(perfilDTO);
                listUsuarioDTO.add(usuarioDTO);
            }
            return listUsuarioDTO;
        }

        return null;
    }
    
    private void eliminarUserList(String nombreUsuario, List<Usuario> listUsuarios){
        int i = 0;
        for (Usuario usuario : listUsuarios) {
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                listUsuarios.remove(i);
                break;
            }
            i++;
        }
    }

}
