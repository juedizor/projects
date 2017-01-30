/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.entity.Departamento;
import co.com.jj.appform.persistence.iface.DepartamentoIfaceDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author julio.izquierdo
 */
public class DepartamentoImplDAO implements DepartamentoIfaceDAO {

    private EntityManager manager;

    @Override
    public List<Departamento> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Departamento> findByIdPais(int idPais) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT d FROM Departamento d WHERE d.idPais.idPais = :idPais");
        Query query = manager.createQuery(sql.toString());
        query.setParameter("idPais", idPais);
        List<Departamento> listDepartamentos = query.getResultList();
        if (listDepartamentos != null && !listDepartamentos.isEmpty()) {
            return listDepartamentos;
        }

        return null;
    }

    @Override
    public void setEntityManager(EntityManager manager) {
        this.manager = manager;
    }

}
