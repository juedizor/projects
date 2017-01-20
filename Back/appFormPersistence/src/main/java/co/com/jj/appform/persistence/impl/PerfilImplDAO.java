/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.entity.Perfil;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jeio
 */
public class PerfilImplDAO implements PerfilIfaceDAO{

    private EntityManager manager;
    
    @Override
    public List<Perfil> findAll() throws Exception {
        return manager.createNamedQuery("Perfil.findAll").getResultList();
    }

    @Override
    public Perfil findByNombre(String nombre) throws Exception {
        List<Perfil> listPerfil = manager.
                createNamedQuery("Perfil.findByNombre").
                setParameter("nombre", nombre).getResultList();
        if(listPerfil != null && !listPerfil.isEmpty()){
            return listPerfil.get(0);
        }
        return null;
    }

    @Override
    public void setEntityManager(EntityManager manager) {
        this.manager = manager;
    }
    
    
    
    
    
}
