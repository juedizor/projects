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

    private static EntityManager manager = null;
    private static EntityManagerFactory emf = null;
    private static EntityTransaction tx = null;
    private static PersistenceApp persistenceApp = null;

    private PersistenceApp() {

    }

    public static PersistenceApp getInstance() {
        if (persistenceApp == null) {
            persistenceApp = new PersistenceApp();
        }
        return persistenceApp;
    }

    public EntityManagerFactory getEntityManagerFactory() throws Exception {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("appFormDS");
        }
        return emf;
    }

    public EntityManager getEntityManager() throws Exception {
        manager = getEntityManagerFactory().createEntityManager();
        return manager;
    }

    public EntityTransaction getEntityTransaction() throws Exception {
        tx = getEntityManager().getTransaction();
        return tx;
    }

}
