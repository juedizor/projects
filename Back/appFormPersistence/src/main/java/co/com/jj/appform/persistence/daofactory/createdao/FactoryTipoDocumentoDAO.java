/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.daofactory.createdao;

import co.com.jj.appform.persistence.daofactory.FactoryIface;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import co.com.jj.appform.persistence.impl.TipoDocumentoImplDAO;

/**
 *
 * @author julio.izquierdo
 */
public class FactoryTipoDocumentoDAO implements FactoryIface<TipoDocumentoIfaceDAO>{

    private static FactoryIface factoryIface;
    
    private FactoryTipoDocumentoDAO() {
    }

    public static FactoryIface getInstance() {
        if (factoryIface == null) {
            factoryIface = new FactoryTipoDocumentoDAO();
        }

        return factoryIface;
    }
    
    @Override
    public TipoDocumentoIfaceDAO newInstance() throws Exception {
        return new TipoDocumentoImplDAO();
    }
    
}
