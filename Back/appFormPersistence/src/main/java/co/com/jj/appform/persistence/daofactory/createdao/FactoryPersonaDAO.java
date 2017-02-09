/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.daofactory.createdao;

import co.com.jj.appform.persistence.daofactory.FactoryIface;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import co.com.jj.appform.persistence.impl.PersonaImplDAO;

/**
 *
 * @author julio.izquierdo
 */
public class FactoryPersonaDAO implements FactoryIface<PersonaIfaceDAO>{

    private static FactoryIface factoryIface;
    
    public static FactoryIface getInstance(){
        if(factoryIface == null){
            factoryIface = new FactoryPersonaDAO();
        }
        
        return factoryIface;
    }
    
    @Override
    public PersonaIfaceDAO newInstance() throws Exception {
        return new PersonaImplDAO();
    }
    
    
    
}
