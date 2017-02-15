/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.daofactory.createdao;

import co.com.jj.appform.persistence.daofactory.FactoryIface;
import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
import co.com.jj.appform.persistence.impl.DireccionImplDAO;

/**
 *
 * @author julio.izquierdo
 */
public class FactoryDireccionDAO implements FactoryIface<DireccionIfaceDAO>{

    private static FactoryIface factoryIface;
    
    
    private FactoryDireccionDAO() {
    }

    public static FactoryIface getInstance() {
        if (factoryIface == null) {
            factoryIface = new FactoryDireccionDAO();
        }

        return factoryIface;
    }
    
    
    
    @Override
    public DireccionIfaceDAO newInstance() throws Exception {
        return new DireccionImplDAO();
    }
    
    
    
}
