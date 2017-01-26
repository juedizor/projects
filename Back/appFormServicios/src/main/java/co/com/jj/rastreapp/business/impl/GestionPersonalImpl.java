/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.PersistenceApp;
import co.com.jj.appform.entity.Direccion;
import co.com.jj.appform.entity.Perfil;
import co.com.jj.appform.entity.Persona;
import co.com.jj.appform.entity.TipoDocumento;
import co.com.jj.appform.entity.Usuario;
import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
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
import java.util.Arrays;
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
    @Autowired
    DireccionIfaceDAO direccionIfaceDAO;

    private static final DateUtils DATE_UTILS = DateUtils.getInstance();
    private static final EntityUtils ENTITY_UTILS = EntityUtils.getInstance();
    private PersistenceApp persistenceApp;

    @Override
    public int registrarPersona(PersonaDTO personaDTO) throws Exception {
        int resultado = Respuestas.SIN_DATOS;
        if (personaDTO != null) {
            persistenceApp = new PersistenceApp();
            try {

                java.sql.Timestamp fechaReg = DATE_UTILS.getFechaActual(); // fecha Actual
                persistenceApp.getEntityTransaction().begin(); // se inicia la transaccion

                /**
                 * inicializa los DAO para acceso a CRUD
                 */
                tipoDocumentoIfaceDAO.setEntityManager(persistenceApp.getManager());
                perfilIfaceDAO.setEntityManager(persistenceApp.getManager());
                usuarioIfaceDAO.setEntityManager(persistenceApp.getManager());
                personaIfaceDAO.setEntityManager(persistenceApp.getManager());
                direccionIfaceDAO.setEntityManager(persistenceApp.getManager());

                Persona persona = ENTITY_UTILS.getPersona(personaDTO);
                TipoDocumento tipoDocumento = ENTITY_UTILS.getTipoDocumento(personaDTO.getTipoDocumento());
                persona.setIdTipoDocumento(tipoDocumento);
                Usuario usuario = ENTITY_UTILS.getUsuario(personaDTO.getUsuario());

                Perfil perfil = ENTITY_UTILS.getPerfil(personaDTO.getUsuario().getPerfil());
                usuario.setIdPerfil(perfil);
                Direccion direccion = ENTITY_UTILS.getDireccion(personaDTO.getDireccion());
                direccion.setFechaInicial(fechaReg);
                if (personaDTO.getIdPersona() != null) {
                    // en este punto entra en proceso de edicion de datos
                    persona.setFechaModificacion(fechaReg);
                    personaIfaceDAO.merge(persona); // actualiza los datos de persona si aplica
                    Usuario user = usuarioIfaceDAO.findById(usuario.getIdUsuario());
                    usuario.setContrasena(user.getContrasena());
                    usuario.setIdPersona(persona);
                    usuarioIfaceDAO.merge(usuario); // actualiza los datos de usuario si aplica
                    Direccion dirPersona = direccionIfaceDAO.findByIdPersona(persona.getIdPersona());
                    if (!dirPersona.getNombreDireccion().trim().equals(direccion.getNombreDireccion())) {
                        dirPersona.setFechaFinal(fechaReg);
                        direccionIfaceDAO.merge(dirPersona);
                        persistenceApp.getEntityTransaction().commit();
                        PersistenceApp persistenceAppDir = new PersistenceApp();
                        try {
                            persistenceAppDir.getEntityTransaction().begin();
                            direccionIfaceDAO.setEntityManager(persistenceAppDir.getEntityManager());
                            direccion.setIdDireccion(null);
                            direccion.setIdPersona(persona);
                            direccionIfaceDAO.save(direccion);
                            persistenceAppDir.getEntityTransaction().commit();
                        } catch (Exception e) {
                            persistenceAppDir.getEntityTransaction().rollback();
                            throw new Exception("Error realizando transacción persona - usuario:\n" + e.getMessage());
                        }
                    } else {
                        persistenceApp.getEntityTransaction().commit();
                    }
                    return Respuestas.ACTUALIZADO;
                } else {
                    // en este punto entra en proceso de registro de datos
                    persona.setFechaRegistro(fechaReg);
                    personaIfaceDAO.save(persona);
                    usuario.setFechaCreacion(fechaReg);
                    usuario.setIdPersona(persona);
                    persona.setUsuarioList(Arrays.asList(usuario));
                    direccion.setIdPersona(persona);
                    persona.setDireccionList(Arrays.asList(direccion));
                    persistenceApp.getEntityTransaction().commit();
                    return Respuestas.CREADO;
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
            personaDTO.setUsuario(usuarioDTO);
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
