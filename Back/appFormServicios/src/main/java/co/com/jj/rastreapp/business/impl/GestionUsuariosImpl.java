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
        List<Usuario> listUsuarios = usuarioIfaceDAO.findByNombreUsuarioContrasenaActivo(nombreUsuario, contrasena, true);
        if (listUsuarios != null && !listUsuarios.isEmpty()) {
            UsuarioDTO usuarioDTO = ENTITY_UTILS.getUsuarioDTO(listUsuarios.get(0));
            PerfilDTO perfilDTO = ENTITY_UTILS.getPerfilDTO(listUsuarios.get(0).getIdPerfil());
            usuarioDTO.setPerfil(perfilDTO);
            PersonaDTO personaDTO = ENTITY_UTILS.getPersonaDTO(listUsuarios.get(0).getIdPersona());
            usuarioDTO.setPersona(personaDTO);
            TipoDocumentoDTO tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(listUsuarios.get(0).getIdPersona().getIdTipoDocumento());
            personaDTO.setTipoDocumento(tipoDocumentoDTO);
            return usuarioDTO;
        }
        return null;
    }

    @Override
    public int registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        int resultado = Respuestas.SIN_DATOS;
        if (usuarioDTO != null) {
            try {
                persistenceApp = new PersistenceApp();
                persistenceApp.getEntityTransaction().begin();
                tipoDocumentoIfaceDAO.setEntityManager(persistenceApp.getManager());
                perfilIfaceDAO.setEntityManager(persistenceApp.getManager());
                usuarioIfaceDAO.setEntityManager(persistenceApp.getManager());
                
                Usuario usuario = usuarioIfaceDAO.findByNombreUsuario(usuarioDTO.getNombreUsuario());
                if(usuario == null){
                    usuario = ENTITY_UTILS.getUsuario(usuarioDTO);
                }
                java.sql.Timestamp fechaReg = DATE_UTILS.getFechaActual();
                usuarioDTO.getPersona().setFechaRegistro(fechaReg);
                Persona persona = ENTITY_UTILS.getPersona(usuarioDTO.getPersona());
                TipoDocumento tipoDocumento = tipoDocumentoIfaceDAO.findById(usuarioDTO.getPersona().getTipoDocumento().getIdTipoDocumento());
                persona.setIdTipoDocumento(tipoDocumento);
                Perfil perfil = perfilIfaceDAO.findByNombre(usuarioDTO.getPerfil().getNombrePerfil());
                usuario.setIdPerfil(perfil);
                usuario.setIdPersona(persona);
                usuario.setFechaCreacion(fechaReg);
                if(usuarioDTO.getIdUsuario() != null){
                    usuarioIfaceDAO.merge(usuario);
                    persistenceApp.getEntityTransaction().commit();
                    resultado = Respuestas.ACTUALIZADO;
                }else{
                    usuarioIfaceDAO.save(usuario);
                    persistenceApp.getEntityTransaction().commit();
                    resultado = Respuestas.CREADO;
                }
                
            } catch (Exception e) {
                persistenceApp.getEntityTransaction().rollback();
                throw new Exception("Error realizando transacción usuario:\n" + e.getMessage());
            }

        }

        return resultado;
    }

    @Override
    public PersonaDTO getPersona(int tipoDoc, long numeroDoc) throws Exception {
        persistenceApp = new PersistenceApp();
        personaIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
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
            personaDTO.setTipoDocumento(tipoDocumentoDTO);
            personaDTO.setUsuarioDTO(usuarioDTO);
        }
        return personaDTO;
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
    public List<UsuarioDTO> obtenerUsuarios() throws Exception {
        persistenceApp = new PersistenceApp();
        usuarioIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
        List<Usuario> listUsuarios = usuarioIfaceDAO.findAll();
        UsuarioDTO usuarioDTO;
        PersonaDTO personaDTO;
        PerfilDTO perfilDTO;
        TipoDocumentoDTO tipoDocumentoDTO;
        List<UsuarioDTO> listUsuarioDTO = new ArrayList<>();
        if (listUsuarios != null && !listUsuarios.isEmpty()) {
            for (Usuario usuario : listUsuarios) {
                usuarioDTO = ENTITY_UTILS.getUsuarioDTO(usuario);
                usuarioDTO.setContrasena("");
                personaDTO = ENTITY_UTILS.getPersonaDTO(usuario.getIdPersona());
                tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(usuario.getIdPersona().getIdTipoDocumento());
                personaDTO.setTipoDocumento(tipoDocumentoDTO);
                usuarioDTO.setPersona(personaDTO);
                perfilDTO = ENTITY_UTILS.getPerfilDTO(usuario.getIdPerfil());
                usuarioDTO.setPerfil(perfilDTO);
                listUsuarioDTO.add(usuarioDTO);
            }

            return listUsuarioDTO;

        }

        return null;

    }

}
