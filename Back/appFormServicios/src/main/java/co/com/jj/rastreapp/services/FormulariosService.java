///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.com.jj.rastreapp.services;
//
//import co.com.jj.rastreapp.dto.AeFormulariosDTO;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import co.com.jj.rastreapp.business.iface.GestionFormulariosIface;
//import co.com.jj.rastreapp.entity.AeFormulario;
//import org.springframework.web.bind.annotation.RequestBody;
//
///**
// *
// * @author jeio
// */
//@RestController
//@RequestMapping ("/formularios")
//public class FormulariosService {
//    
//    
//    @Autowired
//    GestionFormulariosIface formularioIface;
//    
//    
//    @RequestMapping (value = "/form/{idPerfil}", method = RequestMethod.GET)
//    public List<AeFormulariosDTO> getFormularioPorPerfil(@PathVariable ("idPerfil") int idPerfil){
//        return formularioIface.getFormularioPorPerfil(idPerfil);
//    }
//    
//    @RequestMapping (value = "/form", method = RequestMethod.POST)
//    public boolean registrarFormulario(@RequestBody AeFormulario aeFormulario){
//        return formularioIface.guardarFormulario(aeFormulario);
//    }
//    
//    @RequestMapping (value = "/form", method = RequestMethod.PUT)
//    public boolean actualizarFormulario(@RequestBody AeFormulario aeFormulario){
//        return formularioIface.actualizarFormulario(aeFormulario);
//    }
//    
//}
