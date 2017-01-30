/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.entity.Ciudad;
import co.com.jj.appform.persistence.iface.CiudadIfaceDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author julio.izquierdo
 */
public class CiudadImplDAO implements CiudadIfaceDAO {

    private EntityManager manager;

    @Override
    public List<Ciudad> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciudad> findByIdDepartamento(int idDepartamento) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c FROM Ciudad c WHERE c.idDepartamento.idDepartamento = :idDepartamento");
        Query query = manager.createQuery(sql.toString());
        query.setParameter("idDepartamento", idDepartamento);
        List<Ciudad> listCiudad = query.getResultList();
        if (listCiudad != null && !listCiudad.isEmpty()) {
            return listCiudad;
        }

        return null;
    }

    @Override
    public void setEntityManager(EntityManager manager) {
        this.manager = manager;
    }

}
