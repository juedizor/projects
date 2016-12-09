///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.com.jj.rastreapp.business.impl;
//
//import co.com.jj.rastreapp.dto.AeFormulariosDTO;
//import co.com.jj.rastreapp.entity.AeFormulario;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import co.com.jj.rastreapp.business.iface.GestionFormulariosIface;
//
///**
// *
// * @author jeio
// */
//@Service
//public class GestionFormularioIsmpl implements GestionFormulariosIface {
//
//    @Autowired
//    AeFormularioRepository aeFormularioRepository;
//
//    @Override 
//    public List<AeFormulariosDTO> getFormularioPorPerfil(int idPerfil) {
//        List<AeFormulario> listAeFormulario = aeFormularioRepository.findByPerfil(idPerfil);
//        List<AeFormulariosDTO> listFormulariosDTO = new ArrayList<>();
//        if (listAeFormulario != null && !listAeFormulario.isEmpty()) {
//            AeFormulariosDTO aeFormulariosDTO;
//            for (AeFormulario aeFormulario : listAeFormulario) {
//                aeFormulariosDTO = new AeFormulariosDTO(aeFormulario.getIdFormulario(),
//                        aeFormulario.getXmlForm());
//                listFormulariosDTO.add(aeFormulariosDTO);
//            }
//        }
//
//        return listFormulariosDTO;
//    }
//
//    @Override
//    public boolean guardarFormulario(AeFormulario aeFormulario) {
//        return procesoActualizacionForm(aeFormulario);
//
//    }
//
//    @Override
//    public boolean actualizarFormulario(AeFormulario aeFormulario) {
//       return procesoActualizacionForm(aeFormulario);
//    }
//    
//    
//    private boolean procesoActualizacionForm(AeFormulario aeFormulario){
//         try {
//            aeFormularioRepository.save(aeFormulario);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//}
