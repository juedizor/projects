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
import co.com.jj.rastreapp.business.iface.GestionPersonalIface;
import co.com.jj.rastreapp.dto.PerfilDTO;
import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import co.com.jj.rastreapp.util.DateUtils;
import co.com.jj.rastreapp.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeio
 */
@Service
public class GestionPersonalImpl implements GestionPersonalIface {

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
    public int registrarPersona(PersonaDTO personaDTO) throws Exception {
        int resultado = Respuestas.SIN_DATOS;
        if (personaDTO != null) {
            try {
                persistenceApp = new PersistenceApp();
                persistenceApp.getEntityTransaction().begin(); // se inicia la transaccion

                /**
                 * inicializa los DAO para acceso a CRUD
                 */
                tipoDocumentoIfaceDAO.setEntityManager(persistenceApp.getManager());
                perfilIfaceDAO.setEntityManager(persistenceApp.getManager());
                usuarioIfaceDAO.setEntityManager(persistenceApp.getManager());
                personaIfaceDAO.setEntityManager(persistenceApp.getManager());

                Usuario usuario = usuarioIfaceDAO.findByNombreUsuario(personaDTO.getUsuarioDTO().getNombreUsuario());
                if (usuario == null) {
                    if (personaDTO.getUsuarioDTO().getIdUsuario() != null) {
                        usuario = usuarioIfaceDAO.findById(personaDTO.getUsuarioDTO().getIdUsuario());
                        usuario.setNombreUsuario(personaDTO.getUsuarioDTO().getNombreUsuario());
                    } else {
                        usuario = ENTITY_UTILS.getUsuario(personaDTO.getUsuarioDTO());
                    }
                }
                java.sql.Timestamp fechaReg = DATE_UTILS.getFechaActual();
                personaDTO.setFechaRegistro(fechaReg);
                Persona persona = ENTITY_UTILS.getPersona(personaDTO);
                TipoDocumento tipoDocumento = tipoDocumentoIfaceDAO.findById(personaDTO.getTipoDocumento().getIdTipoDocumento());
                persona.setIdTipoDocumento(tipoDocumento);
                Perfil perfil = perfilIfaceDAO.findByNombre(personaDTO.getUsuarioDTO().getPerfil().getNombrePerfil());
                usuario.setIdPerfil(perfil);
                usuario.setIdPersona(persona);
                usuario.setFechaCreacion(fechaReg);
                if (personaDTO.getUsuarioDTO().getIdUsuario() != null) {
                    personaIfaceDAO.merge(persona);
                    persistenceApp.getEntityTransaction().commit();
                    resultado = Respuestas.ACTUALIZADO;
                } else {
                    personaIfaceDAO.save(persona);
                    persistenceApp.getEntityTransaction().commit();
                    resultado = Respuestas.CREADO;
                }
            } catch (Exception e) {
                persistenceApp.getEntityTransaction().rollback();
                throw new Exception("Error realizando transacción persona - usuario:\n" + e.getMessage());
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
    public PersonaDTO getPersona(String email) throws Exception {
        persistenceApp = new PersistenceApp();
        personaIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
        Persona persona = personaIfaceDAO.findByEmail(email);
        PersonaDTO personaDTO = null;
        if (persona != null) {
            personaDTO = ENTITY_UTILS.getPersonaDTO(persona);
        }
        return personaDTO;
    }

}
