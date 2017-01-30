/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jj.appform.persistence.iface;

import co.com.jj.appform.entity.Departamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author julio.izquierdo
 */
public interface DepartamentoIfaceDAO {
    
    
    public List<Departamento> findAll() throws Exception;
    public List<Departamento> findByIdPais(int idPais) throws Exception;
    public void setEntityManager(EntityManager manager);
    
}
