/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.business.iface.GestionParamsIface;
import co.com.jj.rastreapp.dto.CiudadDTO;
import co.com.jj.rastreapp.dto.DepartamentoDTO;
import co.com.jj.rastreapp.dto.PaisDTO;
import co.com.jj.rastreapp.dto.PerfilDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julio.izquierdo
 */
@RestController
@RequestMapping("/gestionParams")
@CrossOrigin("*")
public class GestionParamsService {

    @Autowired
    GestionParamsIface gestionParamsIface;

    @RequestMapping(value = "/tipoDocumentos", method = RequestMethod.GET)
    public List<TipoDocumentoDTO> getTipoDocumentoDTO() throws ExceptionGenerics {
        List<TipoDocumentoDTO> listTipoDocumentoDTOs;
        try {
            listTipoDocumentoDTOs = gestionParamsIface.obtenerTiposDocumentos();
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }
        if (listTipoDocumentoDTOs == null || listTipoDocumentoDTOs.isEmpty()) {
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No hay datos de tipos de documentos");
            throw new ExceptionGenerics();
        }

        return listTipoDocumentoDTOs;

    }

    @RequestMapping(value = "/perfiles", method = RequestMethod.GET)
    public List<PerfilDTO> getPerfilDTO() throws ExceptionGenerics {
        List<PerfilDTO> listPerfilDTO;
        try {
            listPerfilDTO = gestionParamsIface.obtenerPerfiles();
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }

        if (listPerfilDTO == null || listPerfilDTO.isEmpty()) {
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No hay datos de perfiles");
            throw new ExceptionGenerics();
        }

        return listPerfilDTO;
    }

    @RequestMapping(value = "/paises", method = RequestMethod.GET)
    public List<PaisDTO> getPaisDTO() throws ExceptionGenerics {
        List<PaisDTO> listPaisDTO;
        try {
            listPaisDTO = gestionParamsIface.obtenerPaises();
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }

        if (listPaisDTO != null && !listPaisDTO.isEmpty()) {
            return listPaisDTO;
        } else {
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No hay datos de paises");
            throw new ExceptionGenerics();
        }
    }

    @RequestMapping(value = "/departamentos/{idPais}", method = RequestMethod.GET)
    public List<DepartamentoDTO> getDepartamentoDTO(@PathVariable(value = "idPais") int idPais) throws ExceptionGenerics {
        List<DepartamentoDTO> listDepartamentoDTO;
        try {
            listDepartamentoDTO = gestionParamsIface.obtenerDepartamentoPais(idPais);
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }

        if (listDepartamentoDTO != null && !listDepartamentoDTO.isEmpty()) {
            return listDepartamentoDTO;
        } else {
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No hay datos de departamento");
            throw new ExceptionGenerics();
        }
    }

    @RequestMapping(value = "/ciudades/{idDepartamento}", method = RequestMethod.GET)
    public List<CiudadDTO> getCiudadDTO(@PathVariable(value = "idDepartamento") int idDepartamento) throws ExceptionGenerics {
        List<CiudadDTO> listCiudadDTO;
        try {
            listCiudadDTO = gestionParamsIface.obtenerCiudadDepartamento(idDepartamento);
        } catch (Exception e) {
            ExceptionGenerics.setCodigo(Respuestas.ERROR);
            ExceptionGenerics.setDescripcion(e.getMessage());
            throw new ExceptionGenerics();
        }
        
        if(listCiudadDTO != null && !listCiudadDTO.isEmpty()){
            return listCiudadDTO;
        }else{
            ExceptionGenerics.setCodigo(Respuestas.SIN_DATOS);
            ExceptionGenerics.setDescripcion("No hay datos de Ciudades");
            throw new ExceptionGenerics();
        }
        
        

    }

}
