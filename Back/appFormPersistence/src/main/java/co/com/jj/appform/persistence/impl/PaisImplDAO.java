/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.entity.Pais;
import co.com.jj.appform.persistence.iface.PaisIfaceDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author julio.izquierdo
 */
public class PaisImplDAO implements PaisIfaceDAO{
    
    private EntityManager manager;

    @Override
    public List<Pais> findAll() throws Exception {
        return manager.createNamedQuery("Pais.findAll").getResultList();
    }

    @Override
    public Pais findById(int idTipoDocumento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntityManager(EntityManager manager) {
        this.manager = manager;
    }
    
}
