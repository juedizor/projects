/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.PersistenceApp;
import co.com.jj.appform.entity.Perfil;
import co.com.jj.appform.persistence.iface.PerfilIfaceDAO;
import java.util.List;

/**
 *
 * @author jeio
 */
public class PerfilImplDAO implements PerfilIfaceDAO{

    private final PersistenceApp persistenceApp = PersistenceApp.getInstance();
    
    @Override
    public List<Perfil> findAll() throws Exception {
        return persistenceApp.getEntityManager().createNamedQuery("Perfil.findAll").getResultList();
    }

    @Override
    public Perfil findByNombre(String nombre) throws Exception {
        List<Perfil> listPerfil = persistenceApp.
                getEntityManager().
                createNamedQuery("Perfil.findByNombre").
                setParameter("nombre", nombre).getResultList();
        if(listPerfil != null && !listPerfil.isEmpty()){
            return listPerfil.get(0);
        }
        return null;
    }
    
}
