///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.com.jj.rastreapp.util;
//
//import co.com.jj.appform.vo.CiudadVO;
//import co.com.jj.appform.entity.Cliente;
//import co.com.jj.appform.entity.Departamento;
//import co.com.jj.appform.entity.Direccion;
//import co.com.jj.appform.entity.Empresa;
//import co.com.jj.appform.entity.Pais;
//import co.com.jj.appform.entity.Perfil;
//import co.com.jj.appform.entity.Persona;
//import co.com.jj.appform.vo.TipoDocumentoVO;
//import co.com.jj.appform.entity.Usuario;
//import co.com.jj.rastreapp.dto.CiudadDTO;
//import co.com.jj.rastreapp.dto.ClienteDTO;
//import co.com.jj.rastreapp.dto.DepartamentoDTO;
//import co.com.jj.rastreapp.dto.DireccionDTO;
//import co.com.jj.rastreapp.dto.EmpresaDTO;
//import co.com.jj.rastreapp.dto.PaisDTO;
//import co.com.jj.rastreapp.dto.PerfilDTO;
//import co.com.jj.rastreapp.dto.PersonaDTO;
//import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
//import co.com.jj.rastreapp.dto.UsuarioDTO;
//import java.util.Date;
//
///**
// *
// * @author jeio
// */
//public class EntityUtils {
//
//    private static EntityUtils entityUtils;
//
//    private EntityUtils() {
//    }
//
//    public static EntityUtils getInstance() {
//        if (entityUtils == null) {
//            entityUtils = new EntityUtils();
//        }
//        return entityUtils;
//    }
//
//    public TipoDocumentoDTO getTipoDocumentoDTO(TipoDocumentoVO tipoDocumento) {
//        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
//        tipoDocumentoDTO.setCodigo(tipoDocumento.getCodigo());
//        tipoDocumentoDTO.setIdTipoDocumento(tipoDocumento.getIdTipoDocumento());
//        tipoDocumentoDTO.setNombre(tipoDocumento.getNombre());
//        return tipoDocumentoDTO;
//    }
//
//    public TipoDocumentoVO getTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) {
//        TipoDocumentoVO tipoDocumento = new TipoDocumentoVO();
//        tipoDocumento.setIdTipoDocumento(tipoDocumentoDTO.getIdTipoDocumento());
//        tipoDocumento.setCodigo(tipoDocumentoDTO.getCodigo());
//        tipoDocumento.setNombre(tipoDocumentoDTO.getNombre());
//        return tipoDocumento;
//
//    }
//
//    public PersonaDTO getPersonaDTO(Persona persona) {
//        PersonaDTO personaDTO = new PersonaDTO();
//        personaDTO.setApellido1(persona.getApellido1());
//        personaDTO.setApellido2(persona.getApellido2());
//        personaDTO.setEmail(persona.getEmail());
//        Date dateMod = persona.getFechaModificacion();
//        if (dateMod != null) {
//            personaDTO.setFechaModificacion(new java.sql.Timestamp(persona.getFechaModificacion().getTime()));
//        }
//        personaDTO.setFechaRegistro(new java.sql.Timestamp(persona.getFechaRegistro().getTime()));
//        personaDTO.setIdPersona(persona.getIdPersona());
//        personaDTO.setNombre1(persona.getNombre1());
//        personaDTO.setNombre2(persona.getNombre2());
//        personaDTO.setNumeroDocumento(persona.getNumeroDocumento());
//        return personaDTO;
//    }
//
//    public Persona getPersona(PersonaDTO personaDTO) {
//        Persona persona = new Persona();
//        if (personaDTO.getIdPersona() != null) {
//            persona.setIdPersona(personaDTO.getIdPersona());
//        }
//        persona.setApellido1(personaDTO.getApellido1());
//        persona.setApellido2(personaDTO.getApellido2());
//        persona.setEmail(personaDTO.getEmail());
//        persona.setFechaModificacion(personaDTO.getFechaModificacion());
//        persona.setFechaRegistro(personaDTO.getFechaRegistro());
//        persona.setIdPersona(personaDTO.getIdPersona());
//        persona.setNombre1(personaDTO.getNombre1());
//        persona.setNombre2(personaDTO.getNombre2());
//        persona.setNumeroDocumento(personaDTO.getNumeroDocumento());
//        return persona;
//    }
//
//    public UsuarioDTO getUsuarioDTO(Usuario usuario) {
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//        usuarioDTO.setActivo(usuario.getActivo());
//        usuarioDTO.setContrasena(usuario.getContrasena());
//        usuarioDTO.setFechaCreacion(new java.sql.Timestamp(usuario.getFechaCreacion().getTime()));
//        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
//        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
//        return usuarioDTO;
//    }
//
//    public Usuario getUsuario(UsuarioDTO usuarioDTO) {
//        Usuario usuario = new Usuario();
//        if (usuarioDTO.getIdUsuario() != null) {
//            usuario.setIdUsuario(usuarioDTO.getIdUsuario());
//        }
//        usuario.setActivo(true);
//        usuario.setContrasena(usuarioDTO.getContrasena());
//        usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
//        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
//        return usuario;
//    }
//
//    public PerfilDTO getPerfilDTO(Perfil perfil) {
//        PerfilDTO perfilDTO = new PerfilDTO();
//        perfilDTO.setIdPerfil(perfil.getIdPerfil());
//        perfilDTO.setNombrePerfil(perfil.getNombre());
//        return perfilDTO;
//    }
//
//    public Perfil getPerfil(PerfilDTO perfilDTO) {
//        Perfil perfil = new Perfil();
//        if (perfilDTO.getIdPerfil() != null) {
//            perfil.setIdPerfil(perfilDTO.getIdPerfil());
//        }
//        perfil.setNombre(perfilDTO.getNombrePerfil());
//        return perfil;
//    }
//
//    public Direccion getDireccion(DireccionDTO direccionDTO) {
//        Direccion direccion = new Direccion();
//        direccion.setNombreDireccion(direccionDTO.getNombreDireccion());
//        if (direccionDTO.getIdDireccion() != null) {
//            direccion.setIdDireccion(direccionDTO.getIdDireccion());
//        }
//        if (direccionDTO.getFechaInicial() != null) {
//            direccion.setFechaInicial(direccionDTO.getFechaInicial());
//        }
//
//        if (direccionDTO.getFechaFinal() != null) {
//            direccion.setFechaFinal(direccionDTO.getFechaFinal());
//        }
//
//        return direccion;
//    }
//
//    public DireccionDTO getDireccionDTO(Direccion direccion) {
//        DireccionDTO direccionDTO = new DireccionDTO();
//        direccionDTO.setIdDireccion(direccion.getIdDireccion());
//        direccionDTO.setNombreDireccion(direccion.getNombreDireccion());
//        direccionDTO.setFechaInicial(new java.sql.Timestamp(direccion.getFechaInicial().getTime()));
//        if (direccion.getFechaFinal() != null) {
//            direccionDTO.setFechaFinal(new java.sql.Timestamp(direccion.getFechaFinal().getTime()));
//        }
//
//        return direccionDTO;
//
//    }
//
//    public Empresa getEmpresa(EmpresaDTO empresaDTO) {
//        Empresa empresa = new Empresa();
//        if (empresaDTO.getIdEmpresa() != null) {
//            empresa.setIdEmpresa(empresaDTO.getIdEmpresa());
//        }
//        empresa.setDescripcionEmpresa(empresaDTO.getDescripcionEmpresa());
//        empresa.setNombreEmpresa(empresaDTO.getNombreEmpresa());
//        return empresa;
//
//    }
//
//    public EmpresaDTO getEmpresaDTO(Empresa empresa) {
//        EmpresaDTO empresaDTO = new EmpresaDTO();
//        empresaDTO.setIdEmpresa(empresa.getIdEmpresa());
//        empresaDTO.setDescripcionEmpresa(empresa.getDescripcionEmpresa());
//        empresaDTO.setNombreEmpresa(empresa.getNombreEmpresa());
//        return empresaDTO;
//    }
//
//    public PaisDTO getPaisDTO(Pais pais) {
//        PaisDTO paisDTO = new PaisDTO();
//        paisDTO.setCodigoPais(pais.getCodigoPais());
//        paisDTO.setIdPais(pais.getIdPais());
//        paisDTO.setNombrePais(pais.getNombrePais());
//        return paisDTO;
//    }
//
//    public DepartamentoDTO getDepartamentoDTO(Departamento departamento) {
//        DepartamentoDTO departamentoDTO = new DepartamentoDTO();
//        departamentoDTO.setCodigoDepartamento(departamento.getCodigoDepartamento());
//        departamentoDTO.setIdDepartamento(departamento.getIdDepartamento());
//        departamentoDTO.setNombreDepartamento(departamento.getNombreDepartamento());
//        return departamentoDTO;
//    }
//
//    public CiudadDTO getCiudadDTO(CiudadVO ciudad) {
//        CiudadDTO ciudadDTO = new CiudadDTO();
//        ciudadDTO.setCodigoCiudad(ciudad.getCodigoCiudad());
//        ciudadDTO.setIdCiudad(ciudad.getIdCiudad());
//        ciudadDTO.setNombreCiudad(ciudad.getNombreCiudad());
//        return ciudadDTO;
//    }
//
//    public CiudadVO getCiudad(CiudadDTO ciudadDTO) {
//        CiudadVO ciudad = new CiudadVO();
//        if (ciudadDTO.getIdCiudad() != null) {
//            ciudad.setIdCiudad(ciudadDTO.getIdCiudad());
//        }
//        ciudad.setCodigoCiudad(ciudadDTO.getCodigoCiudad());
//        ciudad.setNombreCiudad(ciudadDTO.getNombreCiudad());
//        return ciudad;
//    }
//    
//}
