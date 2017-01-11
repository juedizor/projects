/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.util;

import co.com.jj.appform.entity.Perfil;
import co.com.jj.appform.entity.Persona;
import co.com.jj.appform.entity.TipoDocumento;
import co.com.jj.appform.entity.Usuario;
import co.com.jj.rastreapp.dto.PerfilDTO;
import co.com.jj.rastreapp.dto.PersonaDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import co.com.jj.rastreapp.dto.UsuarioDTO;
import java.util.Date;

/**
 *
 * @author jeio
 */
public class EntityUtils {

    private static EntityUtils entityUtils;

    private EntityUtils() {
    }

    public static EntityUtils getInstance() {
        if (entityUtils == null) {
            entityUtils = new EntityUtils();
        }
        return entityUtils;
    }

    public TipoDocumentoDTO getTipoDocumentoDTO(TipoDocumento tipoDocumento) {
        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
        tipoDocumentoDTO.setCodigo(tipoDocumento.getCodigo());
        tipoDocumentoDTO.setIdTipoDocumento(tipoDocumento.getIdTipoDocumento());
        tipoDocumentoDTO.setNombre(tipoDocumento.getNombre());
        return tipoDocumentoDTO;
    }

    public PersonaDTO getPersonaDTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setApellido1(persona.getApellido1());
        personaDTO.setApellido2(persona.getApellido2());
        personaDTO.setEmail(persona.getEmail());
        Date dateMod = persona.getFechaModificacion();
        if (dateMod != null) {
            personaDTO.setFechaModificacion(new java.sql.Timestamp(persona.getFechaModificacion().getTime()));
        }
        personaDTO.setFechaRegistro(new java.sql.Timestamp(persona.getFechaRegistro().getTime()));
        personaDTO.setIdPersona(persona.getIdPersona());
        personaDTO.setNombre1(persona.getNombre1());
        personaDTO.setNombre2(persona.getNombre2());
        personaDTO.setNumeroDocumento(persona.getNumeroDocumento());
        return personaDTO;
    }

    public Persona getPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setApellido1(personaDTO.getApellido1());
        persona.setApellido2(personaDTO.getApellido2());
        persona.setEmail(personaDTO.getEmail());
        persona.setFechaModificacion(personaDTO.getFechaModificacion());
        persona.setFechaRegistro(personaDTO.getFechaRegistro());
        persona.setIdPersona(personaDTO.getIdPersona());
        persona.setNombre1(personaDTO.getNombre1());
        persona.setNombre2(personaDTO.getNombre2());
        persona.setNumeroDocumento(personaDTO.getNumeroDocumento());
        return persona;
    }

    public UsuarioDTO getUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setActivo(usuario.getActivo());
        usuarioDTO.setContrasena(usuario.getContrasena());
        usuarioDTO.setFechaCreacion(new java.sql.Timestamp(usuario.getFechaCreacion().getTime()));
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
        return usuarioDTO;
    }

    public Usuario getUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setActivo(true);
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        return usuario;
    }
    
    public PerfilDTO getPerfilDTO(Perfil perfil){
        PerfilDTO perfilDTO = new PerfilDTO();
        perfilDTO.setIdPerfil(perfil.getIdPerfil());
        perfilDTO.setNombrePerfil(perfil.getNombre());
        return perfilDTO;
    }
    
}
