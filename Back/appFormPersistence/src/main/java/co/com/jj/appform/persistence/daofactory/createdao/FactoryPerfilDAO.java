/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.daofactory.createdao;

import co.com.jj.appform.persistence.daofactory.FactoryIface;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import co.com.jj.appform.persistence.impl.PerfilImplDAO;

/**
 *
 * @author julio.izquierdo
 */
public class FactoryPerfilDAO implements FactoryIface<PerfilIfaceDAO> {

    private static FactoryIface factoryIface;

    public static FactoryIface getInstance() {
        if (factoryIface == null) {
            factoryIface = new FactoryPerfilDAO();
        }

        return factoryIface;
    }

    @Override
    public PerfilIfaceDAO newInstance() throws Exception {
        return new PerfilImplDAO();
    }

}
