/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.impl;

import co.com.jj.appform.MainApp;
import co.com.jj.appform.entity.Persona;
import co.com.jj.appform.persistence.iface.PersonaIfaceDAO;

/**
 *
 * @author jeio
 */
public class PersonaImplDAO implements PersonaIfaceDAO {

    private final MainApp mainApp = MainApp.getInstance();

    @Override
    public void save(Persona persona) throws Exception {
        mainApp.getEntityManager().persist(persona);
    }

}
