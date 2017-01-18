/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jeio
 */
public class PersistenceApp {

    private EntityManager manager = null;
    private EntityManagerFactory emf = null;
    private EntityTransaction tx = null;
    private static PersistenceApp persistenceApp = null;

    public PersistenceApp() {

    }

    public EntityManagerFactory getEntityManagerFactory() throws Exception {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("appFormDS");
        }
        return emf;
    }

    public EntityManager getEntityManager() throws Exception {
        if (emf == null) {
            getEntityManagerFactory();
        }
        
        if(manager == null){
            manager = emf.createEntityManager();
        }
        return manager;
    }

    public EntityTransaction getEntityTransaction() throws Exception {
        if (emf == null) {
            getEntityManagerFactory();
        }
        if (manager == null) {
            getEntityManager();
        }
        if(tx == null){
            tx = manager.getTransaction();
        }
        return tx;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityTransaction getTx() {
        return tx;
    }

    public void setTx(EntityTransaction tx) {
        this.tx = tx;
    }
    

}
