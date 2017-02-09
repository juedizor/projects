/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl.generics;

import co.com.jj.appform.persistence.daofactory.FactoryIface;
import co.com.jj.appform.persistence.iface.generics.DataAccessGenericIface;
import co.com.jj.appform.persistence.impl.generics.DataAccesGenericImpl;

/**
 *
 * @author julio.izquierdo
 */
public class FactoryDataAccesGenerics implements FactoryIface<DataAccessGenericIface> {

    private static FactoryDataAccesGenerics factoryDataAccesGenerics;
    private static DataAccessGenericIface dataAccessGenericIface;

    private FactoryDataAccesGenerics() {
    }

    public static FactoryDataAccesGenerics getInstance() {
        if (factoryDataAccesGenerics == null) {
            factoryDataAccesGenerics = new FactoryDataAccesGenerics();
        }

        return factoryDataAccesGenerics;
    }

    @Override
    public DataAccessGenericIface newInstance() throws Exception {
        if(dataAccessGenericIface == null){
            dataAccessGenericIface = new DataAccesGenericImpl();
        }
        return dataAccessGenericIface;
    }

}
