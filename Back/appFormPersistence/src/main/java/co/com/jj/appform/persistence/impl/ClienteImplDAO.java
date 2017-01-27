/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.entity.Cliente;
import co.com.jj.appform.persistence.iface.ClienteIfaceDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author jeio
 */
public class ClienteImplDAO implements ClienteIfaceDAO{
    
    private EntityManager manager;

    @Override
    public void save(Cliente cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void merge(Cliente cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntityManager(EntityManager manager) throws Exception {
        this.manager = manager;
    }
    
}
