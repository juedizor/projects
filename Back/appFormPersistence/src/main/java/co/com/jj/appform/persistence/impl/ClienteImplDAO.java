/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.entity.Cliente;
import co.com.jj.appform.persistence.iface.ClienteIfaceDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jeio
 */
public class ClienteImplDAO implements ClienteIfaceDAO {

    private EntityManager manager;

    @Override
    public void save(Cliente cliente) throws Exception {
        manager.persist(cliente);
    }

    @Override
    public void merge(Cliente cliente) throws Exception {
        manager.merge(cliente);
    }

    @Override
    public void setEntityManager(EntityManager manager) throws Exception {
        this.manager = manager;
    }

    @Override
    public List<Cliente> findByIdEmpresa(int idEmpresa) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c FROM Cliente c WHERE c.idEmpresa.idEmpresa = :idEmpresa");
        Query query = manager.createQuery(sql.toString());
        query.setParameter("idEmpresa", idEmpresa);
        List<Cliente> listClientes = query.getResultList();
        if (listClientes != null && !listClientes.isEmpty()) {
            return listClientes;
        }
        return null;
    }

}
