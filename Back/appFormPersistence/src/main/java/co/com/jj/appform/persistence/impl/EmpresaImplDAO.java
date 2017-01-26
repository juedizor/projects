/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.entity.Empresa;
import co.com.jj.appform.persistence.iface.EmpresaIfaceDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author julio.izquierdo
 */
public class EmpresaImplDAO implements EmpresaIfaceDAO {

    private EntityManager manager;

    @Override
    public Empresa findByIdPersona(int idPersona) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT e FROM Empresa e WHERE e.idPersona.idPersona = :idPersona");
        Query query = manager.createQuery(sql.toString());
        query.setParameter("idPersona", idPersona);
        List<Empresa> listEmpresa = query.getResultList();
        if (listEmpresa != null && !listEmpresa.isEmpty()) {
            return listEmpresa.get(0);
        }
        return null;
    }

    @Override
    public void setEntityManager(EntityManager manager) throws Exception {
        this.manager = manager;
    }

    @Override
    public void save(Empresa empresa) {
        manager.persist(empresa);
    }

    @Override
    public void merge(Empresa empresa) {
        manager.merge(empresa);
    }

}
