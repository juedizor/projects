/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform;

import javax.persistence.Query;

/**
 *
 * @author jeio
 */
public class Test {
    
    public static void main(String[] args) throws Exception {
        PersistenceApp mainApp = PersistenceApp.getInstance();
        Query query = mainApp.getEntityManager().createNamedQuery("Usuario.findByNombreUsuarioActivo");
        query.setParameter("nombreUsuario", "juedizor");
        query.setParameter("activo", true);
        query.getResultList();
    }
    
}
