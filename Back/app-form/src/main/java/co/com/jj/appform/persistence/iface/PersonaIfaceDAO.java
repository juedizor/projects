/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.Persona;


/**
 *
 * @author jeio
 */
public interface PersonaIfaceDAO {
    
    public void save(Persona persona) throws Exception;
    
}