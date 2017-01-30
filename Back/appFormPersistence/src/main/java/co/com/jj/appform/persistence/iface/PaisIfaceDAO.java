/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.Pais;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author julio.izquierdo
 */
public interface PaisIfaceDAO {
    
    public List<Pais> findAll() throws Exception;
    public Pais findById(int idTipoDocumento) throws Exception;
    public void setEntityManager(EntityManager manager);
    
}
