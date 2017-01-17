/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.PersistenceApp;
import co.com.jj.appform.entity.Persona;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jeio
 */
public class PersonaImplDAO implements PersonaIfaceDAO {

    private final PersistenceApp persistenceApp = PersistenceApp.getInstance();
    private EntityManager manager;

    @Override
    public void save(Persona persona) throws Exception {
        manager.persist(persona);
    }

    @Override
    public Persona findByTipoDocumentoNumeroDocumento(int tipoDocumento, Long numeroDocumento) throws Exception {
        Query query = manager.createNamedQuery("Persona.findByTipoDocumentoNumeroDocumento");
        query.setParameter("idTipoDocumento", tipoDocumento);
        query.setParameter("numeroDocumento", numeroDocumento);
        List<Persona> listPersona = query.getResultList();
        if (listPersona != null && !listPersona.isEmpty()) {
            return listPersona.get(0);
        }

        return null;

    }

    @Override
    public void merge(Persona persona) throws Exception {
        manager.merge(persona);
    }

    @Override
    public void setEntityManager(EntityManager manager) {
        this.manager = manager;
    }

}
