/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.entity.Direccion;
import co.com.jj.appform.persistence.iface.DireccionIfaceDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author julio.izquierdo
 */
public class DireccionImplDAO implements DireccionIfaceDAO {

    private EntityManager manager;

    @Override
    public void save(Direccion direccion) {
        manager.persist(direccion);
    }

    @Override
    public void merge(Direccion direccion) {
        manager.merge(direccion);
    }

    @Override
    public Direccion findById(int idDireccion) throws Exception {
        return null;
    }

    @Override
    public Direccion findByIdPersona(int idPersona) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT d FROM Direccion d WHERE d.idPersona.idPersona = :idPersona AND d.fechaFinal IS NULL");
        Query query = manager.createQuery(sql.toString());
        query.setParameter("idPersona", idPersona);
        List<Direccion> listDireccion = query.getResultList();
        if (listDireccion != null && !listDireccion.isEmpty()) {
            return listDireccion.get(0);
        }

        return null;
    }

    @Override
    public void setEntityManager(EntityManager manager) {
        this.manager = manager;
    }

}
