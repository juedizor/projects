/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.persistence.daofactory.CreateInstance;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import co.com.jj.appform.persistence.iface.generics.DataAccessGenericIface;
import co.com.jj.appform.persistence.impl.generics.FactoryDataAccesGenerics;
import co.com.jj.appform.vo.TipoDocumentoVO;
import java.util.List;

/**
 *
 * @author jeio
 */
public class TipoDocumentoImplDAO implements TipoDocumentoIfaceDAO {

    private final DataAccessGenericIface DATA_ACCESS_GENERIC_IFACE;
    
    public TipoDocumentoImplDAO() throws Exception {
        CreateInstance<DataAccessGenericIface> instace = new CreateInstance<>();
        DATA_ACCESS_GENERIC_IFACE = instace.newInstance(FactoryDataAccesGenerics.getInstance());
    }

    @Override
    public void save(TipoDocumentoVO object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void merge(TipoDocumentoVO object, TipoDocumentoVO objectAct) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDocumentoVO> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDocumentoVO> findByPrimaryKey(TipoDocumentoVO object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
