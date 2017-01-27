/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.iface;

import co.com.jj.rastreapp.dto.ClienteDTO;

/**
 *
 * @author julio.izquierdo
 */
public interface GestionClientesIface {
    
    
    int registrarCliente(ClienteDTO clienteDTO) throws Exception;
    
    int actualizarCliente(ClienteDTO clienteDTO) throws Exception;
    
    
}
