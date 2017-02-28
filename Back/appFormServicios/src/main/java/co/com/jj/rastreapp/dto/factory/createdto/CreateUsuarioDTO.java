/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.dto.factory.createdto;

import co.com.jj.rastreapp.dto.UsuarioDTO;
import co.com.jj.rastreapp.dto.factory.FactoryDTOIface;

/**
 *
 * @author julio
 */
public class CreateUsuarioDTO implements FactoryDTOIface<UsuarioDTO>{
    
    private static FactoryDTOIface factoryDTOIface;
    
    private CreateUsuarioDTO(){
        
    }
    
    public static FactoryDTOIface getInstance(){
        if(factoryDTOIface == null){
            factoryDTOIface = new CreateUsuarioDTO();
        }
        
        return factoryDTOIface;
    }

    @Override
    public UsuarioDTO createInstance() {
        return new UsuarioDTO();
    }
    
}
