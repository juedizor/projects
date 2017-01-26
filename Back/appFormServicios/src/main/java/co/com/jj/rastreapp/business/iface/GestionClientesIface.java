/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.rastreapp.business.iface;

import co.com.jj.appform.entity.Persona;
import javax.persistence.EntityManager;

/**
 *
 * @author julio.izquierdo
 */
public interface GestionClientesIface {
    
    
    void save(Persona persona) throws Exception;
    
    void merge(Persona persona) throws Exception;
    
    EntityManager setEntityManager(EntityManager manager) throws Exception;
    
}
