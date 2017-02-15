/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.daofactory.createdao;

import co.com.jj.appform.persistence.daofactory.FactoryIface;
import co.com.jj.appform.persistence.iface.EmpresaIfaceDAO;
import co.com.jj.appform.persistence.impl.EmpresaImplDAO;

/**
 *
 * @author jeio
 */
public class FactoryEmpresaDAO implements FactoryIface<EmpresaIfaceDAO> {

    private static FactoryIface factoryIface;

    private FactoryEmpresaDAO() {
    }

    public static FactoryIface getInstance() {
        if (factoryIface == null) {
            factoryIface = new FactoryEmpresaDAO();
        }

        return factoryIface;
    }

    @Override
    public EmpresaIfaceDAO newInstance() throws Exception { 
        return new EmpresaImplDAO();
    }


}
