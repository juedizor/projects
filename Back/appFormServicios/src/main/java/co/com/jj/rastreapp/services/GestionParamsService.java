/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.services;

import co.com.jj.rastreapp.business.Respuestas;
import co.com.jj.rastreapp.business.iface.GestionParamsIface;
import co.com.jj.rastreapp.dto.PerfilDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import co.com.jj.rastreapp.excepcion.ExceptionGenerics;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
