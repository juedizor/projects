///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.com.jj.rastreapp.business.impl;
//
//import co.com.jj.appform.PersistenceApp;
//import co.com.jj.appform.vo.CiudadVO;
//import co.com.jj.appform.entity.Direccion;
//import co.com.jj.appform.entity.Empresa;
//import co.com.jj.appform.entity.Perfil;
//import co.com.jj.appform.entity.Persona;
//import co.com.jj.appform.vo.TipoDocumentoVO;
//import co.com.jj.appform.entity.Usuario;
//import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
//import co.com.jj.appform.persistence.iface.EmpresaIfaceDAO;
//import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
//import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
//import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
//import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
//import co.com.jj.rastreapp.business.Respuestas;
//import co.com.jj.rastreapp.business.iface.GestionEmpresasIface;
//import co.com.jj.rastreapp.dto.EmpresaDTO;
//import co.com.jj.rastreapp.util.DateUtils;
//import co.com.jj.rastreapp.util.EntityUtils;
//import java.util.Arrays;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author julio.izquierdo
// */
//@Service
//public class GestionEmpresasImpl implements GestionEmpresasIface {
//
//    @Autowired
//    UsuarioIfaceDAO usuarioIfaceDAO;
//    @Autowired
//    PersonaIfaceDAO personaIfaceDAO;
//    @Autowired
//    TipoDocumentoIfaceDAO tipoDocumentoIfaceDAO;
//    @Autowired
//    PerfilIfaceDAO perfilIfaceDAO;
//    @Autowired
//    EmpresaIfaceDAO empresaIfaceDAO;
//    @Autowired
//    DireccionIfaceDAO direccionIfaceDAO;
//
//    private PersistenceApp persistenceApp;
//    private static final DateUtils DATE_UTILS = DateUtils.getInstance();
//    private static final EntityUtils ENTITY_UTILS = EntityUtils.getInstance();
//
//    @Override
//    public int registrarEmpresa(EmpresaDTO empresaDTO) throws Exception {
//        if (empresaDTO != null) {
//            persistenceApp = new PersistenceApp();
//            try {
//                java.sql.Timestamp fechaReg = DATE_UTILS.getFechaActual(); // fecha Actual
//                persistenceApp.getEntityTransaction().begin(); // se inicia la transaccion
//                /**
//                 * inicializa los DAO para acceso a CRUD
//                 */
//                tipoDocumentoIfaceDAO.setEntityManager(persistenceApp.getManager());
//                perfilIfaceDAO.setEntityManager(persistenceApp.getManager());
//                usuarioIfaceDAO.setEntityManager(persistenceApp.getManager());
//                personaIfaceDAO.setEntityManager(persistenceApp.getManager());
//                direccionIfaceDAO.setEntityManager(persistenceApp.getManager());
//                empresaIfaceDAO.setEntityManager(persistenceApp.getManager());
//
//                Empresa empresa = ENTITY_UTILS.getEmpresa(empresaDTO);
//                TipoDocumentoVO tipoDocumento = ENTITY_UTILS.getTipoDocumento(empresaDTO.getPersona().getTipoDocumento());
//                Perfil perfil = perfilIfaceDAO.findByNombre("ADMINISTRADOR");
//                
//                CiudadVO ciudad = ENTITY_UTILS.getCiudad(empresaDTO.getPersona().getCiudad());
//                Persona persona = ENTITY_UTILS.getPersona(empresaDTO.getPersona());
//                persona.setIdCiudad(ciudad);
//                persona.setIdTipoDocumento(tipoDocumento);
//                persona.setFechaRegistro(fechaReg);
//                empresa.setIdPersona(persona);
//                empresaIfaceDAO.save(empresa);
//                Usuario usuario = ENTITY_UTILS.getUsuario(empresaDTO.getPersona().getUsuario());
//                usuario.setFechaCreacion(fechaReg);
//                usuario.setIdPerfil(perfil);
//                usuario.setIdPersona(empresa.getIdPersona());
//                empresa.getIdPersona().setUsuarioList(Arrays.asList(usuario));
//                Direccion direccion = ENTITY_UTILS.getDireccion(empresaDTO.getPersona().getDireccion());
//                direccion.setFechaInicial(fechaReg);
//                direccion.setIdPersona(empresa.getIdPersona());
//                empresa.getIdPersona().setDireccionList(Arrays.asList(direccion));
//                persistenceApp.getEntityTransaction().commit();
//                return Respuestas.CREADO;
//            } catch (Exception e) {
//                persistenceApp.getEntityTransaction().rollback();
//                throw new Exception("Error realizando el registro del usuario-empresa:\n" + e.getMessage());
//            }
//        }
//
//        return Respuestas.ERROR;
//    }
//
//    @Override
//    public int actualizarEmpresa(EmpresaDTO empresaDTO) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
