/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.impl;

import co.com.jj.appform.PersistenceApp;
import co.com.jj.appform.entity.Ciudad;
import co.com.jj.appform.entity.Direccion;
import co.com.jj.appform.entity.Empresa;
import co.com.jj.appform.entity.Perfil;
import co.com.jj.appform.entity.Persona;
import co.com.jj.appform.entity.TipoDocumento;
import co.com.jj.appform.entity.Usuario;
import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
import co.com.jj.appform.persistence.iface.EmpresaIfaceDAO;
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
import co.com.jj.rastreapp.dto.CiudadDTO;
import co.com.jj.rastreapp.dto.DepartamentoDTO;
import co.com.jj.rastreapp.dto.DireccionDTO;
import co.com.jj.rastreapp.dto.EmpresaDTO;
import co.com.jj.rastreapp.dto.PaisDTO;
import co.com.jj.rastreapp.dto.PerfilDTO;
import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import co.com.jj.rastreapp.util.DateUtils;
import co.com.jj.rastreapp.util.EntityUtils;
import java.util.ArrayList;
import java.util.Arrays;

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
    @Autowired
    EmpresaIfaceDAO empresaIfaceDAO;
    @Autowired
    DireccionIfaceDAO direccionIfaceDAO;

    private static final DateUtils DATE_UTILS = DateUtils.getInstance();
    private static final EntityUtils ENTITY_UTILS = EntityUtils.getInstance();
    private PersistenceApp persistenceApp;

    @Override
    public UsuarioDTO getUserActivo(String nombreUsuario, String contrasena) throws Exception {
        persistenceApp = new PersistenceApp();
        usuarioIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
        empresaIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
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
            Persona persona = listUsuarios.get(0).getIdPersona();
            Empresa empresa = empresaIfaceDAO.findByIdPersona(persona.getIdPersona());
            if (empresa == null) {
                empresa = usuario.getIdEmpresa();
            }
            EmpresaDTO empresaDTO = ENTITY_UTILS.getEmpresaDTO(empresa);
            PersonaDTO personaDTO = ENTITY_UTILS.getPersonaDTO(persona);
            usuarioDTO.setPersona(personaDTO);
            TipoDocumentoDTO tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(persona.getIdTipoDocumento());
            DireccionDTO direccionDTO = ENTITY_UTILS.getDireccionDTO(persona.getDireccionList().get(listUsuarios.get(0).getIdPersona().getDireccionList().size() - 1));
            personaDTO.setTipoDocumento(tipoDocumentoDTO);
            personaDTO.setDireccion(direccionDTO);
            usuarioDTO.setEmpresa(empresaDTO);
            return usuarioDTO;
        } else {
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
        Usuario user = usuarioIfaceDAO.findByNombreUsuario(nombreUsuario);
        List<Usuario> listUsuarios;
        if (user.getIdEmpresa() != null) {
            listUsuarios = usuarioIfaceDAO.findByEmpresaAndNotNombreUsuario(user.getIdEmpresa().getIdEmpresa(),
                    nombreUsuario);
        } else {
            Empresa empresa = user.getIdPersona().getEmpresaList().get(0);
            listUsuarios = usuarioIfaceDAO.findByEmpresaAndNotNombreUsuario(empresa.getIdEmpresa(),
                    nombreUsuario);
        }
        UsuarioDTO usuarioDTO;
        PersonaDTO personaDTO;
        PerfilDTO perfilDTO;
        TipoDocumentoDTO tipoDocumentoDTO;
        DireccionDTO direccionDTO;
        List<UsuarioDTO> listUsuarioDTO = new ArrayList<>();
        if (listUsuarios != null && !listUsuarios.isEmpty()) {
            for (Usuario usuario : listUsuarios) {
                usuarioDTO = ENTITY_UTILS.getUsuarioDTO(usuario);
                usuarioDTO.setContrasena("");
                personaDTO = ENTITY_UTILS.getPersonaDTO(usuario.getIdPersona());
                direccionDTO = ENTITY_UTILS.getDireccionDTO(usuario.getIdPersona().getDireccionList().get(usuario.getIdPersona().getDireccionList().size() - 1));
                tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(usuario.getIdPersona().getIdTipoDocumento());
                PaisDTO paisDTO = ENTITY_UTILS.getPaisDTO(usuario.getIdPersona().getIdCiudad().getIdDepartamento().getIdPais());
                DepartamentoDTO departamentoDTO = ENTITY_UTILS.getDepartamentoDTO(usuario.getIdPersona().getIdCiudad().getIdDepartamento());
                departamentoDTO.setPais(paisDTO);
                CiudadDTO ciudadDTO = ENTITY_UTILS.getCiudadDTO(usuario.getIdPersona().getIdCiudad());
                ciudadDTO.setDepartamento(departamentoDTO);
                personaDTO.setCiudad(ciudadDTO);
                personaDTO.setTipoDocumento(tipoDocumentoDTO);
                personaDTO.setDireccion(direccionDTO);
                usuarioDTO.setPersona(personaDTO);
                perfilDTO = ENTITY_UTILS.getPerfilDTO(usuario.getIdPerfil());
                Empresa empresa = usuario.getIdEmpresa();
                if (empresa == null) {
                    empresa = usuario.getIdPersona().getEmpresaList().get(0);
                }
                EmpresaDTO empresaDTO = ENTITY_UTILS.getEmpresaDTO(empresa);
                usuarioDTO.setPerfil(perfilDTO);
                usuarioDTO.setEmpresa(empresaDTO);
                listUsuarioDTO.add(usuarioDTO);
            }
            return listUsuarioDTO;
        }

        return null;
    }

    @Override
    public int registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if (usuarioDTO != null) {
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

                // obtiene los datos de la direccion
                Direccion direccion = ENTITY_UTILS.getDireccion(usuarioDTO.getPersona().getDireccion());
                direccion.setFechaInicial(fechaReg);
                // obtiene los datos del tipo de documento seleccionado
                TipoDocumento tipoDocumento = ENTITY_UTILS.getTipoDocumento(usuarioDTO.getPersona().getTipoDocumento());
                Ciudad ciudad = ENTITY_UTILS.getCiudad(usuarioDTO.getPersona().getCiudad());
                // obtiene los datos de la persona
                Persona persona = ENTITY_UTILS.getPersona(usuarioDTO.getPersona());
                persona.setIdCiudad(ciudad);
                persona.setIdTipoDocumento(tipoDocumento);
                persona.setFechaRegistro(fechaReg);
                // obtiene los datos del usuario
                Usuario usuario = ENTITY_UTILS.getUsuario(usuarioDTO);
                usuario.setFechaCreacion(fechaReg);
                usuario.setIdPersona(persona);
                //obtiene datos de perfil 
                Perfil perfil = ENTITY_UTILS.getPerfil(usuarioDTO.getPerfil());
                usuario.setIdPerfil(perfil);

                Empresa empresa = ENTITY_UTILS.getEmpresa(usuarioDTO.getEmpresa());
                usuario.setIdEmpresa(empresa);

                usuarioIfaceDAO.save(usuario);
                direccion.setIdPersona(usuario.getIdPersona());
                usuario.getIdPersona().setDireccionList(Arrays.asList(direccion));
                persistenceApp.getEntityTransaction().commit();
                return Respuestas.CREADO;
            } catch (Exception e) {
                persistenceApp.getEntityTransaction().rollback();
                throw new Exception("Error realizando el registro del usuario:\n" + e.getMessage());
            }
        }

        return Respuestas.ERROR;

    }

    @Override
    public int actualizarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if (usuarioDTO != null) {
            persistenceApp = new PersistenceApp();
            try {
                java.sql.Timestamp fechaActual = DATE_UTILS.getFechaActual(); // fecha Actual
                persistenceApp.getEntityTransaction().begin(); // se inicia la transaccion

                /**
                 * inicializa los DAO para acceso a CRUD
                 */
                tipoDocumentoIfaceDAO.setEntityManager(persistenceApp.getManager());
                perfilIfaceDAO.setEntityManager(persistenceApp.getManager());
                usuarioIfaceDAO.setEntityManager(persistenceApp.getManager());
                personaIfaceDAO.setEntityManager(persistenceApp.getManager());
                direccionIfaceDAO.setEntityManager(persistenceApp.getManager());

                // obtiene los datos de la direccion
                Direccion direccion = ENTITY_UTILS.getDireccion(usuarioDTO.getPersona().getDireccion());
                direccion.setFechaInicial(fechaActual);
                // obtiene los datos del tipo de documento seleccionado
                TipoDocumento tipoDocumento = ENTITY_UTILS.getTipoDocumento(usuarioDTO.getPersona().getTipoDocumento());
                // obtiene los datos de la persona
                Ciudad ciudad = ENTITY_UTILS.getCiudad(usuarioDTO.getPersona().getCiudad());
                Persona persona = ENTITY_UTILS.getPersona(usuarioDTO.getPersona());
                persona.setIdCiudad(ciudad);
                persona.setIdTipoDocumento(tipoDocumento);
                persona.setFechaModificacion(fechaActual);
                // obtiene los datos del usuario
                Usuario usuario = ENTITY_UTILS.getUsuario(usuarioDTO);
                List<Direccion> listDireccion = new ArrayList<>();
                Direccion dirPersona = direccionIfaceDAO.findByIdPersona(persona.getIdPersona());
                if (!dirPersona.getNombreDireccion().trim().equals(direccion.getNombreDireccion())) {
                    dirPersona.setFechaFinal(fechaActual);
                    dirPersona.setIdPersona(persona);
                    listDireccion.add(dirPersona);
                    direccion.setIdDireccion(null);
                    direccion.setIdPersona(persona);
                    listDireccion.add(direccion);
                    persona.setDireccionList(listDireccion);
                }

                Usuario userActual = usuarioIfaceDAO.findById(usuarioDTO.getIdUsuario());
                usuario.setIdPersona(persona);
                usuario.setContrasena(userActual.getContrasena());
                Empresa empresa = ENTITY_UTILS.getEmpresa(usuarioDTO.getEmpresa());
                usuario.setIdEmpresa(empresa);
                //obtiene datos de perfil 
                Perfil perfil = ENTITY_UTILS.getPerfil(usuarioDTO.getPerfil());
                usuario.setIdPerfil(perfil);

                usuarioIfaceDAO.merge(usuario);

                persistenceApp.getEntityTransaction().commit();
                return Respuestas.ACTUALIZADO;
            } catch (Exception e) {
                persistenceApp.getEntityTransaction().rollback();
                throw new Exception("Error realizando de actualización del usuario:\n" + e.getMessage());
            }
        }

        return Respuestas.ERROR;
    }

}
