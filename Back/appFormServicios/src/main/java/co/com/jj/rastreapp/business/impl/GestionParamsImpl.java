///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.com.jj.rastreapp.business.impl;
//
//import co.com.jj.appform.PersistenceApp;
//import co.com.jj.appform.vo.CiudadVO;
//import co.com.jj.appform.entity.Departamento;
//import co.com.jj.appform.entity.Pais;
//import co.com.jj.appform.entity.Perfil;
//import co.com.jj.appform.vo.TipoDocumentoVO;
//import co.com.jj.appform.persistence.iface.CiudadIfaceDAO;
//import co.com.jj.appform.persistence.iface.DepartamentoIfaceDAO;
//import co.com.jj.appform.persistence.iface.PaisIfaceDAO;
//import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
//import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
//import co.com.jj.rastreapp.business.iface.GestionParamsIface;
//import co.com.jj.rastreapp.dto.CiudadDTO;
//import co.com.jj.rastreapp.dto.DepartamentoDTO;
//import co.com.jj.rastreapp.dto.PaisDTO;
//import co.com.jj.rastreapp.dto.PerfilDTO;
//import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
//import co.com.jj.rastreapp.util.EntityUtils;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author julio.izquierdo
// */
//@Service
//public class GestionParamsImpl implements GestionParamsIface {
//
//    @Autowired
//    TipoDocumentoIfaceDAO tipoDocumentoIfaceDAO;
//    @Autowired
//    PerfilIfaceDAO perfilIfaceDAO;
//    @Autowired
//    PaisIfaceDAO paisIfaceDAO;
//    @Autowired
//    DepartamentoIfaceDAO departamentoIfaceDAO;
//    @Autowired
//    CiudadIfaceDAO ciudadIfaceDAO;
//
//    private static final EntityUtils ENTITY_UTILS = EntityUtils.getInstance();
//    private PersistenceApp persistenceApp;
//
//    @Override
//    public List<TipoDocumentoDTO> obtenerTiposDocumentos() throws Exception {
//        persistenceApp = new PersistenceApp();
//        tipoDocumentoIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
//        List<TipoDocumentoVO> listTipoDocumento = tipoDocumentoIfaceDAO.findAll();
//        TipoDocumentoDTO tipoDocumentoDTO;
//        List<TipoDocumentoDTO> listTipoDocumentoDTO = new ArrayList<>();
//        if (listTipoDocumento != null && !listTipoDocumento.isEmpty()) {
//            for (TipoDocumentoVO tipoDocumento : listTipoDocumento) {
//                tipoDocumentoDTO = ENTITY_UTILS.getTipoDocumentoDTO(tipoDocumento);
//                listTipoDocumentoDTO.add(tipoDocumentoDTO);
//            }
//        }
//
//        return listTipoDocumentoDTO;
//    }
//
//    @Override
//    public List<PerfilDTO> obtenerPerfiles() throws Exception {
//        persistenceApp = new PersistenceApp();
//        perfilIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
//        List<Perfil> listPerfil = perfilIfaceDAO.findAll();
//        PerfilDTO perfilDTO;
//        List<PerfilDTO> listPerfilDTO = new ArrayList<>();
//        if (listPerfil != null && !listPerfil.isEmpty()) {
//            for (Perfil perfil : listPerfil) {
//                perfilDTO = ENTITY_UTILS.getPerfilDTO(perfil);
//                listPerfilDTO.add(perfilDTO);
//            }
//        }
//
//        return listPerfilDTO;
//    }
//
//    @Override
//    public List<PaisDTO> obtenerPaises() throws Exception {
//        persistenceApp = new PersistenceApp();
//        paisIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
//        List<Pais> listPais = paisIfaceDAO.findAll();
//        List<PaisDTO> listPaisDTO = new ArrayList();
//        if (listPais != null && !listPais.isEmpty()) {
//            for (Pais pais : listPais) {
//                PaisDTO paisDTO = ENTITY_UTILS.getPaisDTO(pais);
//                listPaisDTO.add(paisDTO);
//            }
//        }
//        return listPaisDTO;
//
//    }
//
//    @Override
//    public List<DepartamentoDTO> obtenerDepartamentoPais(int idPais) throws Exception {
//        persistenceApp = new PersistenceApp();
//        departamentoIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
//        List<Departamento> listDepartamentos = departamentoIfaceDAO.findByIdPais(idPais);
//        List<DepartamentoDTO> listDepartamentoDTOs = new ArrayList<>();
//        if (listDepartamentos != null && !listDepartamentos.isEmpty()) {
//            for (Departamento departamento : listDepartamentos) {
//                DepartamentoDTO departamentoDTO = ENTITY_UTILS.getDepartamentoDTO(departamento);
//                listDepartamentoDTOs.add(departamentoDTO);
//            }
//        }
//
//        return listDepartamentoDTOs;
//    }
//
//    @Override
//    public List<CiudadDTO> obtenerCiudadDepartamento(int idDepartamento) throws Exception {
//        persistenceApp = new PersistenceApp();
//        ciudadIfaceDAO.setEntityManager(persistenceApp.getEntityManager());
//        List<CiudadVO> listCiudad = ciudadIfaceDAO.findByIdDepartamento(idDepartamento);
//        List<CiudadDTO> listCiudadDTO = new ArrayList();
//        if (listCiudad != null && !listCiudad.isEmpty()) {
//            for (CiudadVO ciudad : listCiudad) {
//                CiudadDTO ciudadDTO = ENTITY_UTILS.getCiudadDTO(ciudad);
//                listCiudadDTO.add(ciudadDTO);
//            }
//        }
//
//        return listCiudadDTO;
//    }
//}
