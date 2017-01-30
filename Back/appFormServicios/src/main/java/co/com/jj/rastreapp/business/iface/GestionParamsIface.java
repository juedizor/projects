/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.iface;

import co.com.jj.rastreapp.dto.CiudadDTO;
import co.com.jj.rastreapp.dto.DepartamentoDTO;
import co.com.jj.rastreapp.dto.PaisDTO;
import co.com.jj.rastreapp.dto.PerfilDTO;
import co.com.jj.rastreapp.dto.TipoDocumentoDTO;
import java.util.List;

/**
 *
 * @author julio.izquierdo
 */
public interface GestionParamsIface {

    List<TipoDocumentoDTO> obtenerTiposDocumentos() throws Exception;

    List<PerfilDTO> obtenerPerfiles() throws Exception;

    List<PaisDTO> obtenerPaises() throws Exception;
    
    List<DepartamentoDTO> obtenerDepartamentoPais(int idPais) throws Exception;
    
    List<CiudadDTO> obtenerCiudadDepartamento(int idDepartamento) throws Exception;
    
    
    
    
    
    

}
