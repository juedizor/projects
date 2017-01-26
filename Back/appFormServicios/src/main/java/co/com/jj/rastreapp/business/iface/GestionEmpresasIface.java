/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.iface;

import co.com.jj.rastreapp.dto.EmpresaDTO;

/**
 *
 * @author julio.izquierdo
 */
public interface GestionEmpresasIface {
    
    int registrarEmpresa(EmpresaDTO empresaDTO) throws Exception;
    
    int actualizarEmpresa(EmpresaDTO empresaDTO) throws Exception;
    
    
}
