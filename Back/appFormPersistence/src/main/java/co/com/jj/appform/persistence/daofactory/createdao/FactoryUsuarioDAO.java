/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.daofactory.createdao;

import co.com.jj.appform.persistence.daofactory.FactoryIface;
import co.com.jj.appform.persistence.iface.UsuarioIfaceDAO;
import co.com.jj.appform.persistence.impl.UsuarioImplDAO;

/**
 *
 * @author julio.izquierdo
 */
public class FactoryUsuarioDAO implements FactoryIface<UsuarioIfaceDAO> {

    private static FactoryIface factoryIface;

    private FactoryUsuarioDAO() {

    }

    public static FactoryIface getInstance() {
        if (factoryIface == null) {
            factoryIface = new FactoryUsuarioDAO();
        }

        return factoryIface;
    }

    @Override
    public UsuarioIfaceDAO newInstance() throws Exception {
        return new UsuarioImplDAO();
    }

}
