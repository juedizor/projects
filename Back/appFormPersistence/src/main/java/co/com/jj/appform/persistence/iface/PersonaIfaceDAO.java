/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.Persona;
import javax.persistence.EntityManager;

/**
 *
 * @author jeio
 */
public interface PersonaIfaceDAO {

    public void save(Persona persona) throws Exception;

    public void merge(Persona persona) throws Exception;
    
    Persona findById(int idPersona) throws Exception;

    Persona findByTipoDocumentoNumeroDocumento(int tipoDocumento, Long numeroDocumento) throws Exception;
    
    Persona findByEmail(String email) throws Exception;

    public void setEntityManager(EntityManager manager);

}
