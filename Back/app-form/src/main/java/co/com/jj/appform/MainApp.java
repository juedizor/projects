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
public class MainApp {

    private static EntityManager manager = null;
    private static EntityManagerFactory emf = null;
    private static EntityTransaction tx = null;
    private static MainApp mainApp = null;

    private MainApp() {

    }

    public static MainApp getInstance() {
        if (mainApp == null) {
            mainApp = new MainApp();
        }
        return mainApp;
    }

    public EntityManager getEntityManager() throws Exception {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("appFormDS");
            manager = emf.createEntityManager();
        }
        return manager;
    }

    public EntityTransaction getEntityTransaction() throws Exception {
        tx = getEntityManager().getTransaction();
        return tx;
    }

//    @Bean(name = "tx")
//    public EntityTransaction getEntityTransaction() {
//        return manager.getTransaction();
//    }
}
