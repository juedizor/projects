/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.PersistenceApp;
import co.com.jj.appform.entity.TipoDocumento;
import co.com.jj.appform.persistence.iface.TipoDocumentoIfaceDAO;
import java.util.List;

/**
 *
 * @author jeio
 */
public class TipoDocumentoImplDAO implements TipoDocumentoIfaceDAO {

    private final PersistenceApp persistenceApp = PersistenceApp.getInstance();

    @Override
    public List<TipoDocumento> findAll() throws Exception {
        return persistenceApp.getEntityManager().createNamedQuery("TipoDocumento.findAll").getResultList();
    }

    @Override
    public TipoDocumento findById(int idTipoDocumento) throws Exception {
        List<TipoDocumento> listTipoDocumento = persistenceApp.getEntityManager().
                createNamedQuery("TipoDocumento.findByIdTipoDocumento").
                setParameter("idTipoDocumento", idTipoDocumento)
                .getResultList();
        if (listTipoDocumento != null && !listTipoDocumento.isEmpty()) {
            return listTipoDocumento.get(0);
        }
        return null;

    }

}
