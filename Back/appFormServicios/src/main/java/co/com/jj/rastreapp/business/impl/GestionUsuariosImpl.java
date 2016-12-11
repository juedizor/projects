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
import co.com.jj.rastreapp.dto.PerfilDTO;
import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import co.com.jj.rastreapp.util.DateUtils;
import co.com.jj.rastreapp.util.EntityUtils;

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
    private static final PersistenceApp PERSISTENCE_APP = PersistenceApp.getInstance();

    @Override
    public UsuarioDTO getUserActivo(String nombreUsuario) throws Exception {
        List<Usuario> listUsuarios = usuarioIfaceDAO.findByNombreUsuarioActivo(nombreUsuario, true);
        if (listUsuarios != null && !listUsuarios.isEmpty()) {
            UsuarioDTO usuarioDTO = ENTITY_UTILS.getUsuarioDTO(listUsuarios.get(0));
            PerfilDTO perfilDTO = ENTITY_UTILS.getPerfilDTO(listUsuarios.get(0).getIdPerfil());
            usuarioDTO.setPerfil(perfilDTO);
            PersonaDTO personaDTO = ENTITY_UTILS.getPersonaDTO(listUsuarios.get(0).getIdPersona());
            usuarioDTO.setPersona(personaDTO);
            TipoDocumentoDTO tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(listUsuarios.get(0).getIdPersona().getIdTipoDocumento());
            personaDTO.setTipoDocumentoDTO(tipoDocumentoDTO);
            return usuarioDTO;
        }
        return null;
    }

    @Override
    public int registrarUsuario(PersonaDTO personaDTO) throws Exception {
        int resultado = Respuestas.SIN_DATOS;
        if (personaDTO != null) {
            // tiene que validar si el usuario ya existe 
            UsuarioDTO aeUsuarioDTO = getUser(personaDTO.getUsuarioDTO().getNombreUsuario());
            if (aeUsuarioDTO != null) {
                resultado = Respuestas.EXISTE_REGISTRO;
            } else {
                try {
                    PERSISTENCE_APP.getEntityTransaction().begin();
                    personaDTO.setFechaRegistro(DATE_UTILS.getFechaActual());
                    Persona persona = ENTITY_UTILS.getPersona(personaDTO);
                    TipoDocumento tipoDocumento = tipoDocumentoIfaceDAO.findById(personaDTO.getTipoDocumentoDTO().getIdTipoDocumento());
                    persona.setIdTipoDocumento(tipoDocumento);
                    Usuario usuario = ENTITY_UTILS.getUsuario(personaDTO.getUsuarioDTO());
                    Perfil perfil = perfilIfaceDAO.findByNombre(personaDTO.getUsuarioDTO().getPerfil().getNombrePerfil());
                    usuario.setIdPerfil(perfil);
                    usuario.setIdPersona(persona);
                    usuarioIfaceDAO.save(usuario);
                    PERSISTENCE_APP.getEntityTransaction().commit();
                    resultado = Respuestas.CREADO;
                } catch (Exception e) {
                    PERSISTENCE_APP.getEntityTransaction().rollback();
                    throw new Exception("Error realizando transacción usuario:\n" + e.getMessage());
                }
            }
        }

        return resultado;
    }

    @Override
    public PersonaDTO getPersona(int tipoDoc, long numeroDoc) throws Exception {
        Persona persona = personaIfaceDAO.findByTipoDocumentoNumeroDocumento(tipoDoc, numeroDoc);
        PersonaDTO personaDTO = null;
        TipoDocumentoDTO tipoDocumentoDTO;
        UsuarioDTO usuarioDTO;
        if (persona != null) {
            personaDTO = ENTITY_UTILS.getPersonaDTO(persona);
            tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(persona.getIdTipoDocumento());
            usuarioDTO = ENTITY_UTILS.getUsuarioDTO(persona.getUsuarioList().get(0));
            PerfilDTO perfilDTO = ENTITY_UTILS.getPerfilDTO(persona.getUsuarioList().get(0).getIdPerfil());
            usuarioDTO.setPerfil(perfilDTO);
            personaDTO.setTipoDocumentoDTO(tipoDocumentoDTO);
            personaDTO.setUsuarioDTO(usuarioDTO);
        }
        return personaDTO;
    }

    @Override
    public UsuarioDTO getUser(String nombreUsuario) throws Exception {
        Usuario usuario = usuarioIfaceDAO.findByNombreUsuario(nombreUsuario);
        UsuarioDTO aeUsuarioDTO = null;
        if (usuario != null) {
            aeUsuarioDTO = ENTITY_UTILS.getUsuarioDTO(usuario);
        }
        return aeUsuarioDTO;
    }

}
